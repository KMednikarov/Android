package com.learn.hotornot.overall;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.hotornot.R;
import com.learn.hotornot.data.models.CurrentWeather;

import java.util.ArrayList;
import java.util.List;

public class OverallAdapter extends RecyclerView.Adapter<OverallViewHolder>  {
    private List<CurrentWeather> mCurrentWeatherList;

    public OverallAdapter(){
        mCurrentWeatherList = new ArrayList<>();
    }

    @NonNull
    @Override
    public OverallViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View weatherCardView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_card_layout, parent, false);

        return new OverallViewHolder(weatherCardView);
    }

    @Override
    public void onBindViewHolder(@NonNull OverallViewHolder holder, int position) {
        CurrentWeather currentWeather = mCurrentWeatherList.get(position);
        holder.setData(currentWeather);
    }

    @Override
    public int getItemCount() {
        return mCurrentWeatherList.size();
    }

    public void addWeatherModel(List<CurrentWeather> weatherList){
        mCurrentWeatherList = weatherList;
        notifyDataSetChanged();
    }
}
