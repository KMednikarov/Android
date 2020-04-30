package com.learn.hotornot;

import com.learn.hotornot.data.DataRepository;
import com.learn.hotornot.data.models.CoordinatesData;
import com.learn.hotornot.data.models.WeatherModel;

public class Presenter {
    private DataRepository mDataRepository;

    public WeatherModel getWeatherData(){
        return mDataRepository.getWeatherModel();
    }

    public CoordinatesData getGpsLocation(){
        CoordinatesData coordinates = new CoordinatesData();
        coordinates.setLongitude(27.91);
        coordinates.setLatitude(43.21);

        return coordinates;
    }
}
