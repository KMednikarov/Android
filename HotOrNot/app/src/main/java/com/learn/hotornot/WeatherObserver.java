package com.learn.hotornot;

import com.learn.hotornot.data.DataRepository;

public interface WeatherObserver {
    DataRepository dataRepository = null;
    void update();
}
