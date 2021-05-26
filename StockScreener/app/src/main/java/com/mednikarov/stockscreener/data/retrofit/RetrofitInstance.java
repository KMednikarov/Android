package com.mednikarov.stockscreener.data.retrofit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Converter;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitInstance {
    private static final String YAHOO_BASE_URL = "https://apidojo-yahoo-finance-v1.p.rapidapi.com";
    private static Retrofit mRetrofit;

    private RetrofitInstance(){
    }

    public static Retrofit getInstance(){
        if(mRetrofit == null){

            mRetrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(getBaseUrl())
                    .client(getHttpClient())
                    .addConverterFactory(getGsonConverterFactory())
                    .build();
        }
        return mRetrofit;
    }

    private static Converter.Factory getGsonConverterFactory() {
        return GsonConverterFactory.create();
    }

    private static OkHttpClient getHttpClient() {
        HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
        interceptor.level(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder().addInterceptor(interceptor).build();
    }

    private static String getBaseUrl(){
        return YAHOO_BASE_URL;
    }
}
