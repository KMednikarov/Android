package com.mednikarov.stockscreener.data;

import com.mednikarov.stockscreener.data.model.Stock;

import java.util.List;

public interface StocksRepository {
    List<Stock> getWatchlist();
    Stock searchStock(String symbol); // Replace String with Stock variable?
    void addToWatchlist(Stock stock);
    void removeFromWatchlist(Stock stock);
}
