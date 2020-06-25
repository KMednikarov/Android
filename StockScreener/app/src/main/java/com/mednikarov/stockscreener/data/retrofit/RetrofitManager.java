package com.mednikarov.stockscreener.data.retrofit;

import com.mednikarov.stockscreener.data.model.Stock;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class RetrofitManager {
    private static final String API_TOKEN = "pk_37bf63c2ecf04a149ce3c6c6ae64a0fa";
    private StockService mStockService;
    private Stock mStock;
    public RetrofitManager(){
        mStockService = RetrofitInstance.getInstance().create(StockService.class);
        mStock = Stock.newInstance();
    }
    public void fetchStockData(){
        Call<Stock> call = getStockService().getBatchStockData("AAPL","quote,news,chart",getApiToken());
        call.enqueue(new Callback<Stock>() {
            @Override
            public void onResponse(Call<Stock> call, Response<Stock> response) {
                if (response.isSuccessful()) {
                    mStock = response.body();
                }
            }

            @Override
            public void onFailure(Call<Stock> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    private StockService getStockService(){
        return mStockService;
    }
    private static String getApiToken() {
        return API_TOKEN;
    }
}
