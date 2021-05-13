package com.mednikarov.stockscreener.views.watchlist.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.Quote;
import com.mednikarov.stockscreener.data.model.StockBatch;
import com.mednikarov.stockscreener.databinding.FragmentWatchlistBinding;

import java.util.ArrayList;
import java.util.List;

public class WatchlistAdapter extends RecyclerView.Adapter<WatchlistViewHolder> {
    private List<Quote> stockList;
    private FragmentWatchlistBinding binding;
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
    public void addToWatchlist(Quote quote){
        getStockList().add(quote);
    }
    public Quote getItemAt(int position){
        return getStockList().get(position);
    }
    public void removeItemAt(int position){
        getStockList().remove(position);
    }

    public void clearWatchlist() {
        getStockList().clear();
    }

    public List<Quote> getStockList(){
        return stockList;
    }

    public static WatchlistAdapter newInstance(){
        return new WatchlistAdapter();
    }

    public interface OnItemClicked {
        void onItemClick(int position);
    }
}
