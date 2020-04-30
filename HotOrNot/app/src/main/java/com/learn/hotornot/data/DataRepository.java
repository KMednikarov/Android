package com.learn.hotornot.data;

import android.content.Context;

import androidx.room.Room;

import com.learn.hotornot.MainActivity;
import com.learn.hotornot.WeatherObserver;
import com.learn.hotornot.data.local.database.WeatherDatabase;
import com.learn.hotornot.data.models.CurrentWeather;
import com.learn.hotornot.data.models.ForecastWeather;
import com.learn.hotornot.data.models.WeatherMetaData;
import com.learn.hotornot.data.retrofit.DataFetchedListener;
import com.learn.hotornot.data.retrofit.WeatherRetrofitManager;
import com.learn.hotornot.data.models.CoordinatesData;
import com.learn.hotornot.data.models.WeatherModel;

import java.util.ArrayList;
import java.util.List;

public class DataRepository implements DataFetchedListener {
    public static final String WEATHER_DATABASE = "weather-database";
    private Context mContext;
    private List<WeatherObserver> observers;
    private CoordinatesData mCoordinates;
    private WeatherRetrofitManager mRetrofit;
    private WeatherModel mWeatherModel;
    private WeatherDatabase mDatabase;

    public DataRepository(Context context){
        mCoordinates = new CoordinatesData();
        mCoordinates.setLongitude(27.91);
        mCoordinates.setLatitude(43.21);
        observers = new ArrayList<>();

        mContext = context;
        mWeatherModel = WeatherModel.getInstance();
        mRetrofit = WeatherRetrofitManager.getInstance();
        mDatabase = WeatherDatabase.getInstance(context);
    }

    public void fetchCurrentWeatherData() {
        /*Call<WeatherModel> call = mWeatherService.getCurrentWeather(getGpsCoordinates().getLatitude()
                , getGpsCoordinates().getLongitude()
                , API_KEY, mTemperatureUnits);
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful()) {
                    mWeatherModel = response.body();
                    notifyObservers();
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                t.printStackTrace();
            }
        });*/
    }

    public void getWeatherData() {
        List<CurrentWeather> currentWeatherList = mDatabase.currentWeatherDao().selectAll();
        List<ForecastWeather> forecastWeatherList = mDatabase.forecastDao().selectAll();
        if(currentWeatherList.isEmpty() || forecastWeatherList.isEmpty()) {
            mRetrofit.fetchWeatherData(getGpsCoordinates(), this);
        } else {
            mWeatherModel.setCurrentWeather(currentWeatherList.get(0));
            mWeatherModel.setDailyForecast(forecastWeatherList);
            notifyObservers();
        }
    }

    private CoordinatesData getGpsCoordinates(){
        return mCoordinates;
    }

    public WeatherModel getWeatherModel() {
        return mWeatherModel;
    }


    @Override
    public void onDataFetched(WeatherModel model) {
        mWeatherModel = model;
        mDatabase.currentWeatherDao().insert(mWeatherModel.getCurrentWeather());
        mDatabase.forecastDao().insertAll(model.getDailyForecast());
        notifyObservers();
    }

    public void attach(WeatherObserver observer){
        observers.add(observer);
    }
    private void notifyObservers(){
        for (WeatherObserver observer : observers){
            observer.update();
        }
    }
}
