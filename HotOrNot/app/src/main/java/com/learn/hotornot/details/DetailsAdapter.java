package com.learn.hotornot.details;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.learn.hotornot.R;
import com.learn.hotornot.data.models.ForecastWeather;

import java.util.ArrayList;
import java.util.List;

public class DetailsAdapter extends RecyclerView.Adapter<DetailsViewHolder> {
    private List<ForecastWeather> mForecastList;

    public DetailsAdapter(){
        mForecastList = new ArrayList<>();
    }

    @NonNull
    @Override
    public DetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View forecastView = LayoutInflater.from(parent.getContext()).inflate(R.layout.weather_card_layout, parent, false);

        return new DetailsViewHolder(forecastView);
    }

    @Override
    public void onBindViewHolder(@NonNull DetailsViewHolder holder, int position) {
        ForecastWeather forecast = mForecastList.get(position);
        holder.setData(forecast);
    }

    @Override
    public int getItemCount() {
        return mForecastList.size();
    }

    public void setForecastList(List<ForecastWeather> forecast){
        mForecastList = forecast;
        notifyDataSetChanged();
    }
}
