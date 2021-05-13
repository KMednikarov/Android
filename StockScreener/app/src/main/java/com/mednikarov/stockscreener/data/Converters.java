package com.mednikarov.stockscreener.data;

import androidx.room.TypeConverter;

import java.math.BigInteger;

public class Converters {
    @TypeConverter
    public static String fromBigInteger(BigInteger value){
        return value == null ? null : value.toString();
    }

    @TypeConverter
    public static BigInteger stringToBigInteger(String value){
        return value == null ? null : new BigInteger(value);
    }

}
