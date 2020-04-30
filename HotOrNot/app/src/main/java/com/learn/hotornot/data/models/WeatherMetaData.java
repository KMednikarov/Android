package com.learn.hotornot.data.models;

import com.google.gson.annotations.SerializedName;

public class WeatherMetaData {
    @SerializedName("id")
    private long weatherId;
    @SerializedName("main")
    private String weatherName;
    @SerializedName("description")
    private String weatherDescription;
    @SerializedName("icon")
    private String weatherIcon;

    public long getWeatherId() {
        return weatherId;
    }

    public void setWeatherId(long weatherId) {
        this.weatherId = weatherId;
    }

    public String getWeatherName() {
        return weatherName;
    }

    public void setWeatherName(String weatherName) {
        this.weatherName = weatherName;
    }

    public String getWeatherDescription() {
        return weatherDescription;
    }

    public void setWeatherDescription(String weatherDescription) {
        this.weatherDescription = weatherDescription;
    }

    public String getWeatherIcon() {
        return weatherIcon;
    }

    public void setWeatherIcon(String weatherIcon) {
        this.weatherIcon = weatherIcon;
    }
}
