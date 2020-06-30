package com.mednikarov.stockscreener.data;

import com.mednikarov.stockscreener.data.model.Stock;

import java.util.List;

public interface Repository {
    List<Stock> getWatchlist();

}
