package com.learn.hotornot.data.retrofit;

import com.learn.hotornot.data.DataRepository;
import com.learn.hotornot.data.models.CoordinatesData;
import com.learn.hotornot.data.models.WeatherModel;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class WeatherRetrofitManager {
    private static final String API_KEY = "191b014a8ad926eae15966f14cabc9f5";
    private static String mTemperatureUnits = "metric";
    private WeatherService mWeatherService;
    private WeatherModel mWeatherModel;

    public WeatherRetrofitManager(){
        mWeatherService = WeatherRetrofitInstance.getInstance().create(WeatherService.class);
        mWeatherModel = WeatherModel.getInstance();
    }

    public static WeatherRetrofitManager getInstance() {
        return new WeatherRetrofitManager();
    }

    public void fetchWeatherData(CoordinatesData coordinates, DataFetchedListener listener) {
        Call<WeatherModel> call = mWeatherService.getWeatherData(coordinates.getLatitude()
                , coordinates.getLongitude()
                ,API_KEY
                ,mTemperatureUnits);
        call.enqueue(new Callback<WeatherModel>() {
            @Override
            public void onResponse(Call<WeatherModel> call, Response<WeatherModel> response) {
                if (response.isSuccessful()) {
                    mWeatherModel = response.body();
                    listener.onDataFetched(mWeatherModel);
                }
            }

            @Override
            public void onFailure(Call<WeatherModel> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }
}
