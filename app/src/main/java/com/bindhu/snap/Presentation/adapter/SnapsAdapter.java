package com.bindhu.snap.Presentation.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Base64;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bindhu.snap.R;
import com.bindhu.snap.model.Snap;
import com.bumptech.glide.Glide;

import java.util.List;

public class SnapsAdapter extends RecyclerView.Adapter<SnapsAdapter.SnapItemViewHolder> {

    private List<Snap> mSnaps;
    private Context context;

    public SnapsAdapter(List<Snap> mSnaps, Context context) {
        this.mSnaps = mSnaps;
        this.context = context;
    }

    @NonNull
    @Override
    public SnapItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        return new SnapItemViewHolder(LayoutInflater.from(context).inflate(R.layout.snap_item,viewGroup,false));
    }

    @Override
    public void onBindViewHolder(@NonNull SnapItemViewHolder snapItemViewHolder, int position) {
        Snap currentSnap = mSnaps.get(position);
        snapItemViewHolder.milesTextView.setText(String.valueOf(currentSnap.getDistance()));
        snapItemViewHolder.milesTextView.setText(String.valueOf(currentSnap.getDistance())+""+context.getString(R.string.mts_away));        
        Glide.with(context).load(Base64.decode(currentSnap.getPicture().getContent(),Base64.DEFAULT)).into(snapItemViewHolder.mSnapImage);

    }

    @Override
    public int getItemCount() {
        return mSnaps.size();
    }

    public class SnapItemViewHolder extends RecyclerView.ViewHolder {

        private ImageView mSnapImage;
        private TextView milesTextView;

        public SnapItemViewHolder(@NonNull View itemView){
            super(itemView);
            mSnapImage=itemView.findViewById(R.id.snap_image);  //recuperer snap item
            milesTextView=itemView.findViewById(R.id.snap_info);
                     
            
        }
    }
}
