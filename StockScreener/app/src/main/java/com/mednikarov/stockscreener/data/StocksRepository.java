package com.mednikarov.stockscreener.data;

import com.mednikarov.stockscreener.data.model.Stock;
import com.mednikarov.stockscreener.data.room.StockDatabase;

import java.util.ArrayList;
import java.util.List;

public class StocksRepository implements Repository {
    private StockDatabase mStockDatabase;
    
    @Override
    public List<Stock> getWatchlist() {
        List<Stock> array = new ArrayList<>();
        array.add(new Stock("AAPL","Apple Inc.","25.06.2020",155,555,235,445));
        array.add(new Stock("GOOGL","Google Inc.","25.06.2020",155,555,235,445));
        array.add(new Stock("TSL","Tesla Inc.","25.06.2020",155,555,235,445));
        return array;
    }



    public static StocksRepository getInstance(){
        return new StocksRepository();
    }
}
