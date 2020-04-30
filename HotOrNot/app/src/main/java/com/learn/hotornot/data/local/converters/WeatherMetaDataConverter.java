package com.learn.hotornot.data.local.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.learn.hotornot.data.models.CurrentWeather;
import com.learn.hotornot.data.models.WeatherMetaData;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class WeatherMetaDataConverter {
    Gson gson = new Gson();

    @TypeConverter
    public List<WeatherMetaData> stringToMetaData(String metaData){
        if(metaData == null){
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<WeatherMetaData>>(){}.getType();

        return gson.fromJson(metaData, listType);
    }

    @TypeConverter
    public String metaDataToString(List<WeatherMetaData> weatherMetaData){
        return gson.toJson(weatherMetaData);
    }
}
