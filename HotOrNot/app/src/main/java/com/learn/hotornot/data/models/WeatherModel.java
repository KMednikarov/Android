package com.learn.hotornot.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class WeatherModel implements Serializable {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("lat")
    @ColumnInfo(name = "latitude")
    private double latitude;
    @SerializedName("lon")
    @ColumnInfo(name = "longitude")
    private double longitude;
    @SerializedName("timezone")
    @ColumnInfo(name = "timezone")
    private String timezone;
    @SerializedName("current")
    @Embedded
    private CurrentWeather currentWeather;
    @SerializedName("daily")
    @ColumnInfo(name = "")
    private List<ForecastWeather> dailyForecast;


    public static WeatherModel getInstance() {
        return new WeatherModel();
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public CurrentWeather getCurrentWeather() {
        return currentWeather;
    }

    public void setCurrentWeather(CurrentWeather currentWeather) {
        this.currentWeather = currentWeather;
    }

    public List<ForecastWeather> getDailyForecast() {
        return dailyForecast;
    }

    public void setDailyForecast(List<ForecastWeather> dailyForecast) {
        this.dailyForecast = dailyForecast;
    }
}
