package com.mednikarov.stockscreener.views.search.recyclerview;

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

public class SearchViewHolder extends RecyclerView.ViewHolder {
    private static List<WatchlistItemChanged> watchlistObsevers = new ArrayList<>();

    private StockBatch mStock;
    private final TextView txtSymbolName;
    private final TextView txtPrice;
    private final CheckBox btnAddToWatchlist;

    public SearchViewHolder(@NonNull View itemView) {
        super(itemView);
        txtSymbolName = itemView.findViewById(R.id.txt_symbol);
        txtPrice = itemView.findViewById(R.id.txt_price);
        btnAddToWatchlist = itemView.findViewById(R.id.btn_stock_watch);

        btnAddToWatchlist.setOnClickListener(addToWatchlistListener);
    }

    public void setData(StockBatch stock){
        mStock = stock;
        String symbolName = getQuote().getSymbol();
        double openPrice = getQuote().getLatestPrice();

        txtSymbolName.setText(symbolName);
        txtPrice.setText(String.valueOf(openPrice));
        if(getQuote().isInWatchlist()){
            btnAddToWatchlist.setChecked(true);
        }
    }

    public static void addObserver(WatchlistItemChanged listener){
        watchlistObsevers.add(listener);
    }

    private final View.OnClickListener addToWatchlistListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(getQuote() == null){
                return;
            }

            if(btnAddToWatchlist.isChecked()){
                getQuote().setInWatchlist(true);
                for(WatchlistItemChanged observer : watchlistObsevers){
                    observer.onAddedToWatchlist(getQuote());
                }
            } else {
                getQuote().setInWatchlist(false);
                for(WatchlistItemChanged observer : watchlistObsevers){
                    observer.onRemovedFromWatchlist(getQuote());
                }
            }
        }

    };

    private Quote getQuote(){
        return mStock.getQuote();
    }
}
