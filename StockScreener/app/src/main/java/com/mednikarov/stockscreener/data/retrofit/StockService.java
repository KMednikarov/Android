package com.mednikarov.stockscreener.data.retrofit;

import com.mednikarov.stockscreener.data.model.Stock;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;
import retrofit2.http.Query;

public interface StockService {
    @GET("stable/stock/{symbol}/batch")
    public Call<Stock> getBatchStockData(@Path("symbol") String symbol,
                                         @Query("types") String types,
                                         @Query("token") String apiToken);
    @GET("stable/stock/{symbol}/batch")
    public Call<Stock> getBatchStockData(@Path("symbol") String symbol,
                                         @Query("types") String types,
                                         @Query("range") String range,
                                         @Query("last") String last,
                                         @Query("token") String apiToken);

}
