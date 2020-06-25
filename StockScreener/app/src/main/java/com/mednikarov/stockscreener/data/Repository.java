package com.mednikarov.stockscreener.data;

import com.mednikarov.stockscreener.data.model.Stock;

public interface Repository {
    Stock getStock(String symbol);
    void insertStock(Stock stock);
}
