package com.bindhu.snap.Presentation.loader;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.support.v4.content.AsyncTaskLoader;
import android.util.Base64;

import com.bindhu.snap.Presentation.NetworkUtils;
import com.bindhu.snap.R;
import com.bindhu.snap.model.Picture;
import com.bindhu.snap.model.Snap;

import java.io.ByteArrayOutputStream;
import java.util.ArrayList;
import java.util.List;

public class SnapsLoader extends AsyncTaskLoader<List<Snap>> {

    public SnapsLoader(@NonNull Context context) {
        super(context);
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
        // List<Snap> snaps = new ArrayList<>();
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
        // }
        //  return snaps;
        // }
return NetworkUtils.getSnaps();
    }
}
