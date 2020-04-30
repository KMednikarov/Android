package com.learn.hotornot.data.retrofit;

import com.learn.hotornot.data.models.WeatherModel;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface WeatherService {
    @GET("weather")
    public Call<WeatherModel> getCurrentWeather(@Query("lat") double latitude
                                                , @Query("lon") double longitude
                                                , @Query("appid") String apiKey
                                                , @Query("units") String units);

    @GET("forecast/daily")
    public Call<WeatherModel> getDailyForecast(@Query("lat") double latitude
                                                , @Query("lon") double longitude
                                                , @Query("appid") String apiKey
                                                , @Query("units") String units
                                                , @Query("cnt") int daysCount);
    @GET("onecall")
    public Call<WeatherModel> getWeatherData(@Query("lat") double latitude
                                            , @Query("lon") double longitude
                                            , @Query("appid") String apiKey
                                            , @Query("units") String units);

}
