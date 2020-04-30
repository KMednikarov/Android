package com.hfad.a9gagapp;

import android.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.content.ContextCompat;
import android.support.v4.graphics.drawable.DrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.hfad.a9gagapp.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private List<GalleryItem> items;
    private RecyclerView recyclerView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        recyclerView = binding.recyclerView;
        items = new ArrayList<GalleryItem>();
        generateItems();
        setupRecyclerView();


    }

    private void setRadioButtonsListeners() {

    }

    private void setupRecyclerView() {
        GalleryItemAdapter adapter = new GalleryItemAdapter(this.items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);
        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(recyclerView.getContext(), LinearLayout.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);

    }

    private void generateItems(){
        items.add(new GalleryItem(R.drawable.meme1, "Title for Meme 1",111, 2));
        items.add(new GalleryItem(R.drawable.meme2, "Title for Meme 2",222, 2));
        items.add(new GalleryItem(R.drawable.meme3, "Title for Meme 3",333, 2));
        items.add(new GalleryItem(R.drawable.meme4, "Title for Meme 4",444, 2));
        items.add(new GalleryItem(R.drawable.meme5, "Title for Meme 5",555, 2));
        items.add(new GalleryItem(R.drawable.meme6, "Title for Meme 6",666, 2));
        items.add(new GalleryItem(R.drawable.meme7, "Title for Meme 7",777, 2));
    }
}
