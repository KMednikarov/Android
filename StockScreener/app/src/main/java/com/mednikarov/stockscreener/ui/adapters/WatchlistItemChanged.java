package com.mednikarov.stockscreener.ui.adapters;

import com.mednikarov.stockscreener.data.model.WatchlistStock;

/***
 * Handle adding and removing stocks to watch list.
 */
public interface WatchlistItemChanged {
    void onAddedToWatchlist(WatchlistStock stock);
    void onRemovedFromWatchlist(WatchlistStock stock);
}
