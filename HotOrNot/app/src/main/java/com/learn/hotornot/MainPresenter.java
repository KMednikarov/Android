package com.learn.hotornot;

public class MainPresenter extends Presenter{

    public MainPresenter() {

    }

    public void refreshWeatherData(){
        getGpsLocation();
        getWeatherData();
    }
}
