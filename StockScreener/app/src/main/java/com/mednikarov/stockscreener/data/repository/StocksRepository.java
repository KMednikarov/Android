package com.mednikarov.stockscreener.data.repository;

import com.mednikarov.stockscreener.data.model.Quote;
import com.mednikarov.stockscreener.data.model.StockBatch;

import java.util.List;

public interface StocksRepository {
    List<Quote> getWatchlist();
    void searchStock(String symbol);
    void addToWatchlist(Quote quote);
    void removeFromWatchlist(Quote quote);
}
