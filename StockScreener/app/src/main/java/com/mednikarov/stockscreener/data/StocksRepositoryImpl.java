package com.mednikarov.stockscreener.data;

import android.app.Application;

import androidx.room.RoomDatabase;

import com.mednikarov.stockscreener.data.model.Stock;
import com.mednikarov.stockscreener.data.room.StockDatabase;

import java.util.ArrayList;
import java.util.List;

public class StocksRepositoryImpl implements StocksRepository {
    private StockDatabase mStockDatabase;
    private static StocksRepository mRepository;

    public StocksRepositoryImpl(Application application){
        mStockDatabase = StockDatabase.getInstance(application.getApplicationContext());

    }

    public List<Stock> getWatchlist() {
        List<Stock> array = new ArrayList<>();
        array.add(new Stock("AAPL","Apple Inc.","25.06.2020",155,555,235,445));
        array.add(new Stock("GOOGL","Google Inc.","25.06.2020",155,555,235,445));
        array.add(new Stock("TSL","Tesla Inc.","25.06.2020",155,555,235,445));
        return array;
    }

    @Override
    public void addToWatchlist(Stock stock) {

    }

    @Override
    public void removeFromWatchlist(Stock stock) {

    }

    @Override
    public Stock searchStock(String symbol) {
        return new Stock(symbol,symbol + " Inc.","25.06.2020",155,555,235,445);
    }
    public static StocksRepository newInstance(Application application){
        return new StocksRepositoryImpl(application);
    }
    public static StocksRepository getInstance(){
        return mRepository;
    }
}
