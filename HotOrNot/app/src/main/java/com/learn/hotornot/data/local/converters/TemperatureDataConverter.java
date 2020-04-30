package com.learn.hotornot.data.local.converters;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.learn.hotornot.data.models.Temperature;
import com.learn.hotornot.data.models.WeatherMetaData;

import java.lang.reflect.Type;
import java.util.Collections;
import java.util.List;

public class TemperatureDataConverter {
    Gson gson = new Gson();

    @TypeConverter
    public Temperature stringToTemperature(String data){
        if(data == null){
            return new Temperature();
        }

        Type dataType = new TypeToken<Temperature>(){}.getType();

        return gson.fromJson(data, dataType);
    }

    @TypeConverter
    public String temperatureToString(Temperature temperature){
        return gson.toJson(temperature);
    }
}
