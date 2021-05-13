package com.mednikarov.stockscreener.data.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.mednikarov.stockscreener.data.model.Quote;
import com.mednikarov.stockscreener.data.model.StockBatch;
import com.mednikarov.stockscreener.data.retrofit.RetrofitInstance;
import com.mednikarov.stockscreener.data.retrofit.StockService;
import com.mednikarov.stockscreener.data.room.StockDatabase;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StocksRepositoryImpl implements StocksRepository {
    private static final String API_TOKEN = "pk_37bf63c2ecf04a149ce3c6c6ae64a0fa";
    private final StockService mStockService;

    private final MutableLiveData<StockBatch> mSearchStockLiveData = new MutableLiveData<>();

    private final StockDatabase mStockDatabase;
    private static StocksRepository mRepository;


    public StocksRepositoryImpl(Application application){
        mStockDatabase = StockDatabase.getInstance(application);
        mStockService = RetrofitInstance.getInstance().create(StockService.class);
    }

    public List<Quote> getWatchlist() {
        return mStockDatabase.getAllStocks();
    }


    @Override
    public void addToWatchlist(Quote quote) {
        getDatabase().insertStock(quote);
    }

    @Override
    public void removeFromWatchlist(Quote quote) {
        getDatabase().deleteStock(quote);
    }

    /***
     * Search stock by a given symbol (e.g. AAPL, GOOG).
     * Posts a StockBatch response to live data  if found.
     * @param symbol
     */
    @Override
    public void searchStock(String symbol) {
        Quote dbQuote = getDatabase().getStock(symbol);

        Call<StockBatch> call = getStockService().getBatchStockData(symbol,"quote,news,chart",getApiToken());
        call.enqueue(new Callback<StockBatch>() {
            @Override
            public void onResponse(Call<StockBatch> call, Response<StockBatch> response) {
                if (response.isSuccessful()) {
                    StockBatch stockBatch= response.body();

                    if(stockBatch != null){
                        stockBatch.getQuote().setInWatchlist(dbQuote != null && dbQuote.isInWatchlist());
                    }

                    mSearchStockLiveData.setValue(stockBatch);
                }
            }

            @Override
            public void onFailure(Call<StockBatch> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    public static StocksRepository newInstance(Application application){
        return new StocksRepositoryImpl(application);
    }

    public static StocksRepository getInstance(Application application){
        if(mRepository == null){
            mRepository = new StocksRepositoryImpl(application);
        }

        return mRepository;
    }

    public MutableLiveData<StockBatch> getStockSearchLiveData(){
        return mSearchStockLiveData;
    }


    private StockService getStockService(){
        return mStockService;
    }
    private static String getApiToken() {
        return API_TOKEN;
    }
    private StockDatabase getDatabase(){
        return mStockDatabase;
    }

}
