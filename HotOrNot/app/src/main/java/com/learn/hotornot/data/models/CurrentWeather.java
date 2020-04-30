package com.learn.hotornot.data.models;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;
import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.learn.hotornot.data.local.converters.WeatherMetaDataConverter;

import java.util.List;

@Entity
public class CurrentWeather {
    @PrimaryKey(autoGenerate = true)
    private int id;
    @SerializedName("dt")
    @ColumnInfo(name = "timestamp")
    private int timestamp;
    @SerializedName("temp")
    @ColumnInfo(name = "temperature")
    private double temperatureData;
    @SerializedName("pressure")
    @ColumnInfo(name = "pressure")
    private double pressure;
    @SerializedName("humidity")
    @ColumnInfo(name = "humidity")
    private double humidity;
    @SerializedName("clouds")
    @ColumnInfo(name = "clouds")
    private double clouds;
    @SerializedName("wind_speed")
    @ColumnInfo(name = "wind_speed")
    private double windSpeed;
    @SerializedName("weather")
    @ColumnInfo(name = "weather_meta_data")
    @TypeConverters(WeatherMetaDataConverter.class)
    private List<WeatherMetaData> weatherMetaData;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(int timestamp) {
        this.timestamp = timestamp;
    }

    public double getTemperatureData() {
        return temperatureData;
    }

    public void setTemperatureData(double temperatureData) {
        this.temperatureData = temperatureData;
    }

    public double getPressure() {
        return pressure;
    }

    public void setPressure(double pressure) {
        this.pressure = pressure;
    }

    public double getHumidity() {
        return humidity;
    }

    public void setHumidity(double humidity) {
        this.humidity = humidity;
    }

    public double getClouds() {
        return clouds;
    }

    public void setClouds(double clouds) {
        this.clouds = clouds;
    }

    public double getWindSpeed() {
        return windSpeed;
    }

    public void setWindSpeed(double windSpeed) {
        this.windSpeed = windSpeed;
    }

    public List<WeatherMetaData> getWeatherMetaData() {
        return weatherMetaData;
    }

    public void setWeatherMetaData(List<WeatherMetaData> weatherMetaData) {
        this.weatherMetaData = weatherMetaData;
    }
}
