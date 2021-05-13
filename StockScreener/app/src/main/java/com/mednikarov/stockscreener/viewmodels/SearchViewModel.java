package com.mednikarov.stockscreener.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.mednikarov.stockscreener.data.model.Quote;
import com.mednikarov.stockscreener.data.model.StockBatch;
import com.mednikarov.stockscreener.data.repository.StocksRepositoryImpl;

import java.util.List;

public class SearchViewModel extends AndroidViewModel {
    private final StocksRepositoryImpl mRepository;
    private final MutableLiveData<List<Quote>> mWatchlistLiveData = new MutableLiveData<>();

    public SearchViewModel(@NonNull Application application) {
        super(application);
        mRepository = new StocksRepositoryImpl(application);
    }

    public void searchStock(String symbol){
        getRepository().searchStock(symbol);
    }

    public MutableLiveData<StockBatch> getSearchLiveData(){
        return getRepository().getStockSearchLiveData();
    }

    private StocksRepositoryImpl getRepository(){
        return mRepository;
    }

    public void addToWatchlist(Quote quote) {
        getRepository().addToWatchlist(quote);
    }

    public void removeFromWatchlist(Quote quote){
        getRepository().removeFromWatchlist(quote);
    }

    public MutableLiveData<List<Quote>> getWatchlistLiveData(){
        return mWatchlistLiveData;
    }

    public void updateStockData(){
        getWatchlistLiveData().setValue(getRepository().getWatchlist());
    }
}
