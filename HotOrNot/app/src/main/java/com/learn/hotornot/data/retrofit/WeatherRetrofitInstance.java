package com.learn.hotornot.data.retrofit;

import com.learn.hotornot.data.models.CoordinatesData;
import com.learn.hotornot.data.models.WeatherModel;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class WeatherRetrofitInstance {
    private static final String BASE_URL = "https://api.openweathermap.org/data/2.5/";
    private static Retrofit mRetrofit;

    private WeatherRetrofitInstance(){
    }

    public static Retrofit getInstance(){
        if(mRetrofit == null){
            HttpLoggingInterceptor interceptor = new HttpLoggingInterceptor();
            interceptor.level(HttpLoggingInterceptor.Level.BODY);
            OkHttpClient client = new OkHttpClient.Builder().addInterceptor(interceptor).build();

            mRetrofit = new retrofit2.Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .client(client)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();
        }

        return mRetrofit;
    }

}
