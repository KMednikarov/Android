package com.learn.hotornot.data.models;

import com.google.gson.annotations.SerializedName;

public class Temperature {
    @SerializedName("day")
    private double dailyTemperature;
    @SerializedName("min")
    private double minTemperature;
    @SerializedName("max")
    private double maxTemperature;
    @SerializedName("night")
    private double nightTemperature;
    @SerializedName("eve")
    private double eveningTemperature;
    @SerializedName("morn")
    private double morningTemperature;

    public double getDailyTemperature() {
        return dailyTemperature;
    }

    public void setDailyTemperature(double dailyTemperature) {
        this.dailyTemperature = dailyTemperature;
    }

    public double getMinTemperature() {
        return minTemperature;
    }

    public void setMinTemperature(double minTemperature) {
        this.minTemperature = minTemperature;
    }

    public double getMaxTemperature() {
        return maxTemperature;
    }

    public void setMaxTemperature(double maxTemperature) {
        this.maxTemperature = maxTemperature;
    }

    public double getNightTemperature() {
        return nightTemperature;
    }

    public void setNightTemperature(double nightTemperature) {
        this.nightTemperature = nightTemperature;
    }

    public double getEveningTemperature() {
        return eveningTemperature;
    }

    public void setEveningTemperature(double eveningTemperature) {
        this.eveningTemperature = eveningTemperature;
    }

    public double getMorningTemperature() {
        return morningTemperature;
    }

    public void setMorningTemperature(double morningTemperature) {
        this.morningTemperature = morningTemperature;
    }
}
