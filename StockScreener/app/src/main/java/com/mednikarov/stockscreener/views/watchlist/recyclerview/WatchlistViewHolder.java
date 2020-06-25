package com.mednikarov.stockscreener.views.watchlist.recyclerview;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.Stock;

public class WatchlistViewHolder extends RecyclerView.ViewHolder {
    private TextView txtSymbolName;
    private TextView txtPrice;
    public WatchlistViewHolder(@NonNull View itemView) {
        super(itemView);

        this.txtSymbolName = itemView.findViewById(R.id.txt_symbol);
        this.txtPrice = itemView.findViewById(R.id.txt_price);
    }

    public void setData(Stock stock){
        String symbolName = stock.getSymbolName();
        String openPrice = stock.getOpenPrice() + "$";

        txtSymbolName.setText(stock.getSymbolName());
        txtPrice.setText(openPrice);
    }
}
