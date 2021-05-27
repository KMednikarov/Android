package com.mednikarov.stockscreener.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.mednikarov.stockscreener.data.model.WatchlistStock;
import com.mednikarov.stockscreener.data.model.yahoo.market.Stock;
import com.mednikarov.stockscreener.data.repository.StocksRepository;

import java.util.List;

public class SearchViewModel extends AndroidViewModel {
    private final StocksRepository mRepository;
    private final MutableLiveData<List<Stock>> mWatchlistLiveData = new MutableLiveData<>();

    public SearchViewModel(@NonNull Application application) {
        super(application);
        mRepository = StocksRepository.newInstance(application);
    }

    public void searchStock(String symbol){
        getRepository().searchStock(symbol);
    }

    public MutableLiveData<WatchlistStock> getSearchLiveData(){
        return getRepository().getStockSearchLiveData();
    }

    public void addToWatchlist(WatchlistStock stock) {
        getRepository().addToWatchlist(stock);
    }

    public void removeFromWatchlist(WatchlistStock stock){
        getRepository().removeFromWatchlist(stock);
    }

    public MutableLiveData<List<Stock>> getWatchlistLiveData(){
        return mWatchlistLiveData;
    }

    public void refreshData(){
        getRepository().refreshWatchlist();
    }

    private StocksRepository getRepository(){
        return mRepository;
    }
}
