package com.mednikarov.stockscreener.data;

import androidx.room.TypeConverter;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.mednikarov.stockscreener.data.model.yahoo.quote.Quote;

import java.lang.reflect.Type;
import java.math.BigDecimal;
import java.util.Collections;
import java.util.List;

public class Converters {
    static Gson gson = new Gson();
    //BigDecimal
    @TypeConverter
    public static String bigDecimalToString(BigDecimal value){
        return value == null ? null : value.toString();
    }

    @TypeConverter
    public static BigDecimal stringToBigDecimal(String value){
        return value == null ? null : new BigDecimal(value);
    }

    //List<Double>
    @TypeConverter
    public static List<Double> stringToDoubleList(String data){
        if(data == null){
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Double>>() {}.getType();


        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String doubleListToString(List<Double> data){
        return gson.toJson(data);
    }

    //List<BigDecimal>
    @TypeConverter
    public static List<BigDecimal> stringToBigDecimalList(String data){
        if(data == null){
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<BigDecimal>>() {}.getType();


        return gson.fromJson(data, listType);
    }

    @TypeConverter
    public static String bigDecimalListToString(List<BigDecimal> data){
        return gson.toJson(data);
    }


    //List<Quote>
    @TypeConverter
    public static List<Quote> stringToQuote(String data){
        if(data == null){
            return Collections.emptyList();
        }

        Type listType = new TypeToken<List<Quote>>() {}.getType();


        return gson.fromJson(data, listType);
    }
    @TypeConverter
    public static String quoteToString(List<Quote> data){
        return gson.toJson(data);
    }




}
