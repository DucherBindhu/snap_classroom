package com.bindhu.snap.Presentation.loader;

import android.content.Context;
import android.location.Location;
import android.os.Build;


import com.bindhu.snap.Presentation.infrastructure.AppUtils;
import com.bindhu.snap.Presentation.infrastructure.NetworkUtils;
import com.bindhu.snap.model.SimpleLocation;
import com.bindhu.snap.model.Snap;

import java.util.ArrayList;
import java.util.List;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;
import androidx.loader.content.AsyncTaskLoader;

import static com.bindhu.snap.Presentation.infrastructure.NetworkUtils.getSnaps;

public class SnapsLoader extends AsyncTaskLoader<List<Snap>> {
    private Location mCurrentLocation;
    private double mScope;

    public SnapsLoader(@NonNull Context context, Location mCurrentLocation, double mScope) {
        super(context);
        this.mCurrentLocation = mCurrentLocation;
        this.mScope = mScope;
    }

    @Override
    protected void onStartLoading() {
        onForceLoad();
        super.onStartLoading();
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Nullable
    @Override
    public List<Snap> loadInBackground() {
        List<Snap> snaps = NetworkUtils.getSnaps(mScope, mCurrentLocation);
        for (int i = 0; i < snaps.size(); i++) {
            Snap snap = snaps.get(i);
            SimpleLocation currentSimpleLocation = new SimpleLocation(mCurrentLocation.getLongitude(), mCurrentLocation.getLatitude());
            SimpleLocation snapPostedAtSimpleLocation = snap.getPostedAt();

            double distanceBetweenAsDouble = AppUtils.distanceBetweenAsMeters(currentSimpleLocation, snapPostedAtSimpleLocation, 0, 0);

            snap.setDistance((int) distanceBetweenAsDouble);
        }
        return snaps;
    }
}
        //List<Snap> snaps = new ArrayList<>();
        // Snap snap;
        //Picture picture = new Picture();

        //for (int i = 0; i < 10; i++) {
        //  snap = new Snap();
        //  snap.setDistance(i+1);

        //   Drawable drawable = this.getContext().getResources().getDrawable(i % 2 == 0 ? R.drawable.img_golf: R.drawable.img_soccer, null);
        //   Bitmap bitmap = ((BitmapDrawable) drawable).getBitmap();
        //  ByteArrayOutputStream stream = new ByteArrayOutputStream();
        //  bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
        //   String pictureContent = Base64.encodeToString(stream.toByteArray(), Base64.DEFAULT);
        //   picture.setContent(pictureContent);
        //  snap.setPicture(picture);
        // snaps.add(snap);
        //}
        //  return snaps;
        // }
//return getSnaps(mScope, mCurrentLocation);
    //}
//}
