package com.mednikarov.stockscreener.data.repository;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;

import com.mednikarov.stockscreener.data.model.WatchlistStock;
import com.mednikarov.stockscreener.data.model.yahoo.market.Stock;
import com.mednikarov.stockscreener.data.model.yahoo.market.StockResponse;
import com.mednikarov.stockscreener.data.model.yahoo.quote.QuoteResponse;
import com.mednikarov.stockscreener.data.retrofit.RetrofitInstance;
import com.mednikarov.stockscreener.data.retrofit.YahooStockService;
import com.mednikarov.stockscreener.data.room.StockDatabase;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class StocksRepositoryImpl {
    private static final String IEX_API_TOKEN = "pk_37bf63c2ecf04a149ce3c6c6ae64a0fa";
    private static final String YAHOO_API_KEY = "0b8861c73fmshf2d20cfbe923540p1a6e3ajsn098a201bf50d";
    private final YahooStockService mYahooService;

    private final MutableLiveData<WatchlistStock> mSearchStockLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<WatchlistStock>> mWatchlistLiveData = new MutableLiveData<>();
    private final MutableLiveData<List<WatchlistStock>> mWatchlistStockLiveData = new MutableLiveData<>();

    private final StockDatabase mStockDatabase;
    private static StocksRepositoryImpl mRepository;


    public StocksRepositoryImpl(Application application){
        mStockDatabase = StockDatabase.getInstance(application);
        mYahooService = RetrofitInstance.getInstance().create(YahooStockService.class);
    }

    public List<WatchlistStock> getWatchlist() {
        return mStockDatabase.getAllWatchlistQuotes();
    }

    
    public void refreshWatchlist(){
        try{
            //getDatabase().cleanStocksTable();
            getWatchlistStocks();

        }catch(IOException e){
            e.printStackTrace();
        }
    }
    
    public void getWatchlistStocks() throws IOException {
        List<WatchlistStock> watchlistStock = getDatabase().getAllWatchlistQuotes();
        getWatchlistLiveData().setValue(watchlistStock);
    }

    
    public void getChart(String interval, String symbol, String range, String region) {
        Call<StockResponse> call = mYahooService.getChart(interval,symbol,range,region);
        call.enqueue(new Callback<StockResponse>() {
            
            public void onResponse(Call<StockResponse> call, Response<StockResponse> response) {
                if(!response.isSuccessful()) {
                    return;
                }
                if(response.body() == null) {
                    return;
                }

                StockResponse stockResponse = response.body();
                List<Stock> stocks = new ArrayList<>();

                stocks.add(stockResponse.getStock());
                //getWatchlistLiveData().setValue(stocks);
            }

            
            public void onFailure(Call<StockResponse> call, Throwable t) {

            }
        });
    }

    
    public void getQuote(String symbols) {
        Call<QuoteResponse> call = mYahooService.getQuote("US", symbols);
        call.enqueue(new Callback<QuoteResponse>() {
            
            public void onResponse(Call<QuoteResponse> call, Response<QuoteResponse> response) {
                if(!response.isSuccessful() || response.body() == null){
                    return;
                }
                WatchlistStock stock = new WatchlistStock();
                stock.setSymbol(response.body().getQuoteData().get(0).getSymbol());


            }

            
            public void onFailure(Call<QuoteResponse> call, Throwable t) {

            }
        });
    }

    /***
     * Search stock by a given symbol (e.g. AAPL, GOOG).
     * Posts a StockBatch response to live data  if found.
     * @param symbol
     */
    
    public void searchStock(String symbol) {
        List<WatchlistStock> currentWatchlist = getDatabase().getAllWatchlistQuotes();
        for(WatchlistStock stock : currentWatchlist){
            if(stock.getSymbol().equals(symbol)){
                getStockSearchLiveData().setValue(stock);
                return;
            }
        }

        Call<StockResponse> call = mYahooService.getChart("5m",symbol,"1d","US");
        call.enqueue(new Callback<StockResponse>() {
            
            public void onResponse(Call<StockResponse> call, Response<StockResponse> response) {
                if(!response.isSuccessful()) {
                    return;
                }
                if(response.body() == null) {
                    return;
                }

                StockResponse stockResponse = response.body();
                WatchlistStock stock = new WatchlistStock();
                if(stockResponse.getStock().getError() != null){
                    stock.setError(stockResponse.getStock().getError().toString());
                    getStockSearchLiveData().setValue(stock);
                    return;
                }

                stock.setSymbol(stockResponse.getStock().getChartMetadata().getSymbol());
                stock.setLastPrice(stockResponse.getStock().getChartMetadata().getRegularMarketPrice());
                stock.setChart(stockResponse.getStock().getChartData().get(0));
                getStockSearchLiveData().setValue(stock);
            }

            
            public void onFailure(Call<StockResponse> call, Throwable t) {
                t.printStackTrace();
            }
        });
    }

    
    public void addToWatchlist(WatchlistStock stock) {
        getDatabase().insertStock(stock);
    }

    
    public void removeFromWatchlist(WatchlistStock stock) {
        WatchlistStock watchlistStock = new WatchlistStock();
        watchlistStock.setSymbol(stock.getSymbol());
        getDatabase().deleteStock(watchlistStock);
    }


    public static StocksRepositoryImpl newInstance(Application application){
        return new StocksRepositoryImpl(application);
    }

    public static StocksRepositoryImpl getInstance(Application application){
        if(mRepository == null){
            mRepository = new StocksRepositoryImpl(application);
        }

        return mRepository;
    }

    public MutableLiveData<WatchlistStock> getStockSearchLiveData(){
        return mSearchStockLiveData;
    }

    public MutableLiveData<List<WatchlistStock>> getWatchlistLiveData(){
        return mWatchlistLiveData;
    }
    private StockDatabase getDatabase(){
        return mStockDatabase;
    }

}
