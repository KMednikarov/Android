package com.learn.hotornot.data.local.database;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;

import com.learn.hotornot.data.models.CurrentWeather;

import java.util.List;

@Dao
public interface CurrentWeatherDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(CurrentWeather currentWeather);
    @Delete
    void delete(CurrentWeather currentWeather);
    @Query("SELECT * FROM  CurrentWeather WHERE timestamp in (:timestamp)")
    CurrentWeather selectByDate(int timestamp);
    @Query("SELECT * FROM  CurrentWeather")
    List<CurrentWeather> selectAll();
}
