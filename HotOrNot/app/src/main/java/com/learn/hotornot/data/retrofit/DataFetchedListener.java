package com.learn.hotornot.data.retrofit;

import com.learn.hotornot.data.models.WeatherModel;

public interface DataFetchedListener {
    void onDataFetched(WeatherModel model);
}
