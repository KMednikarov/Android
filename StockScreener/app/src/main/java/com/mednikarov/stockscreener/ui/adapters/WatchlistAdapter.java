package com.mednikarov.stockscreener.ui.adapters;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.WatchlistStock;

import java.util.ArrayList;
import java.util.List;

public class WatchlistAdapter extends RecyclerView.Adapter<WatchlistViewHolder> {
    private final List<WatchlistStock> stockList;
    private WatchlistAdapter(){
        stockList = new ArrayList<>();
    }
    @NonNull
    @Override
    public WatchlistViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_list_item,parent,false);

        return new WatchlistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WatchlistViewHolder holder, int position) {
        holder.setData(getStockList().get(position));
    }

    @Override
    public int getItemCount() {
        return getStockList().size();
    }
    public void addToWatchlist(WatchlistStock stock){
        getStockList().add(stock);
    }
    public WatchlistStock getItemAt(int position){
        return getStockList().get(position);
    }
    public void removeItemAt(int position){
        getStockList().remove(position);
    }

    public void clearWatchlist() {
        getStockList().clear();
    }

    public List<WatchlistStock> getStockList(){
        return stockList;
    }

    public static WatchlistAdapter newInstance(){
        return new WatchlistAdapter();
    }

}
