package com.hfad.a9gagapp;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class GalleryItemViewHolder extends RecyclerView.ViewHolder {
    private ImageView image;
    private TextView itemTitle;
    private TextView pointsView;
    private TextView commentsView;
    public GalleryItemViewHolder(@NonNull View itemView) {
        super(itemView);
        image = itemView.findViewById(R.id.gag_image);
        itemTitle = (TextView) itemView.findViewById(R.id.gag_title);
        pointsView = (TextView) itemView.findViewById(R.id.points_text);
        commentsView = (TextView) itemView.findViewById(R.id.comments_text);
    }

    public void setViewsData(GalleryItem item) {
        image.setImageResource(item.getImageId());
        itemTitle.setText(item.getItemTitle());
        pointsView.setText(Integer.toString(item.getPointsCount()));
        commentsView.setText(Integer.toString(item.getCommentsCount()));
    }


}
