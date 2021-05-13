package com.mednikarov.stockscreener.views;

import com.mednikarov.stockscreener.data.model.Quote;

public interface WatchlistItemChanged {
    void onAddedToWatchlist(Quote quote);
    void onRemovedFromWatchlist(Quote quote);
}
