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

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private final List<WatchlistStock> mStockList;

    private SearchAdapter(){
        mStockList = new ArrayList<>();
    }
    @NonNull
    @Override
    public SearchViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.stock_list_item,parent,false);

        return new SearchViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull SearchViewHolder holder, int position) {
        holder.setData(getStockList().get(position));
    }

    @Override
    public int getItemCount() {
        return mStockList.size();
    }

    /***
     * Add new item to the stocks list
     * @param stock
     */
    public void addToWatchlist(WatchlistStock stock){
        getStockList().add(stock);
    }

    /***
     * Clear the stocks list
     */
    public void clearWatchlist(){
        getStockList().clear();
    }

    /***
     *
     * @return A list with stocks found by the performed search
     */
    private List<WatchlistStock> getStockList(){
        return mStockList;
    }

    public static SearchAdapter newInstance(){
        return new SearchAdapter();
    }
}
