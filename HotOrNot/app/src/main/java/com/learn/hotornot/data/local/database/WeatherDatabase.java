package com.learn.hotornot.data.local.database;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.learn.hotornot.data.models.CurrentWeather;
import com.learn.hotornot.data.models.ForecastWeather;

import kotlin.contracts.Returns;

@Database(entities = {CurrentWeather.class, ForecastWeather.class}, version = 3, exportSchema = false)
public abstract class WeatherDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "weather-database";
    private static WeatherDatabase databaseInstance;
    public abstract CurrentWeatherDao currentWeatherDao();
    public abstract ForecastDao forecastDao();

    public static WeatherDatabase getInstance(Context context){
        if(databaseInstance == null){
            databaseInstance = Room.databaseBuilder(context, WeatherDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();

        }

        return databaseInstance;
    }
}