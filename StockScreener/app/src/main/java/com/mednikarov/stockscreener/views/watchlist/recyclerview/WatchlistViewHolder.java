package com.mednikarov.stockscreener.views.watchlist.recyclerview;

import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.Quote;
import com.mednikarov.stockscreener.data.model.StockBatch;
import com.mednikarov.stockscreener.views.WatchlistItemChanged;

import java.util.ArrayList;
import java.util.List;

public class WatchlistViewHolder extends RecyclerView.ViewHolder {
    private Quote mQuote;
    private TextView txtSymbolName;
    private TextView txtPrice;
    private CheckBox btnRemoveFromWatchlist;
    private static final List<WatchlistItemChanged> watchlistObservers = new ArrayList<>();

    public WatchlistViewHolder(@NonNull View itemView) {
        super(itemView);

        txtSymbolName = itemView.findViewById(R.id.txt_symbol);
        txtPrice = itemView.findViewById(R.id.txt_price);
        btnRemoveFromWatchlist = itemView.findViewById(R.id.btn_stock_watch);

        btnRemoveFromWatchlist.setChecked(true);
        btnRemoveFromWatchlist.setOnClickListener(removeFromWatchlistListener);
    }

    public void setData(Quote quote){
        mQuote = quote;
        String symbolName = getQuote().getSymbol();
        String openPrice = getQuote().getLatestPrice() + "$";

        txtSymbolName.setText(symbolName);
        txtPrice.setText(openPrice);
    }


    public static void addObserver(WatchlistItemChanged observer){
        watchlistObservers.add(observer);
    }

    /***
     * Change favorite icon and remove stock from watchlist
     */
    private View.OnClickListener removeFromWatchlistListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if (getQuote() == null) {
                return;
            }

            if(btnRemoveFromWatchlist.isChecked()){
                for(WatchlistItemChanged observer : watchlistObservers){
                    observer.onAddedToWatchlist(getQuote());
                }
            } else {
                for(WatchlistItemChanged observer : watchlistObservers){
                    observer.onRemovedFromWatchlist(getQuote());
                }
            }
        }
    };

    private Quote getQuote(){
        return mQuote;
    }
}
