package com.mednikarov.stockscreener.data;

import com.mednikarov.stockscreener.data.model.Stock;
import com.mednikarov.stockscreener.data.room.StockDatabase;

public class StocksRepository implements Repository {
    private StockDatabase mStockDatabase;
    @Override
    public Stock getStock(String symbol) {
        return new Stock(symbol,"Apple Inc.","25.06.2020",155,555,235,445);
    }

    @Override
    public void insertStock(Stock stock) {

    }

    public static StocksRepository getInstance(){
        return new StocksRepository();
    }
}
