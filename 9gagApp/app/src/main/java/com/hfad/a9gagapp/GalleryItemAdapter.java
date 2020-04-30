package com.hfad.a9gagapp;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

public class GalleryItemAdapter extends RecyclerView.Adapter<GalleryItemViewHolder> {
    private List<GalleryItem> itemsList = new ArrayList<GalleryItem>();

    public GalleryItemAdapter(List<GalleryItem> items) {
        this.itemsList.addAll(items);
    }

    @NonNull
    @Override
    public GalleryItemViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View galleryItemView = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.gallery_item, viewGroup, false);

        GalleryItemViewHolder holder = new GalleryItemViewHolder(galleryItemView);
        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull GalleryItemViewHolder galleryItemViewHolder, int i) {
        GalleryItem item = itemsList.get(i);
        galleryItemViewHolder.setViewsData(item);
    }

    @Override
    public int getItemCount() {
        return itemsList.size();
    }
}
