package com.mednikarov.stockscreener.views.search.recyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.Quote;
import com.mednikarov.stockscreener.data.model.StockBatch;

import java.util.ArrayList;
import java.util.List;

public class SearchAdapter extends RecyclerView.Adapter<SearchViewHolder> {
    private final List<StockBatch> stockList;

    private SearchAdapter(){
        stockList = new ArrayList<>();
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
        return stockList.size();
    }

    public void addToList(StockBatch quote){
        getStockList().add(quote);
    }

    public void clearList(){
        getStockList().clear();
    }

    private List<StockBatch> getStockList(){
        return stockList;
    }

    public static SearchAdapter newInstance(){
        return new SearchAdapter();
    }
}
