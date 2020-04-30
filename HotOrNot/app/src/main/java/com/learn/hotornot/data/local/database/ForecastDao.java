package com.learn.hotornot.data.local.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learn.hotornot.data.models.ForecastWeather;

import java.util.List;

@Dao
public interface ForecastDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(ForecastWeather... forecastWeathers);
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(List<ForecastWeather> forecastList);
    @Delete
    void delete(ForecastWeather forecastWeather);
    @Query("SELECT * FROM  ForecastWeather")
    List<ForecastWeather> selectAll();
}
