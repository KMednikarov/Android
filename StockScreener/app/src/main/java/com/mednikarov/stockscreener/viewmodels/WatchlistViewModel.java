package com.mednikarov.stockscreener.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.mednikarov.stockscreener.data.model.WatchlistStock;
import com.mednikarov.stockscreener.data.repository.StocksRepositoryImpl;

import java.util.List;

public class WatchlistViewModel extends AndroidViewModel {
    private final StocksRepositoryImpl mStocksRepository;

    public WatchlistViewModel(@NonNull Application application){
        super(application);
        mStocksRepository = StocksRepositoryImpl.newInstance(application);
    }

    public void refreshData(){
        getRepository().refreshWatchlist();
    }

    public void addToWatchlist(WatchlistStock stock){
        getRepository().addToWatchlist(stock);
    }

    public void removeFromWatchlist(WatchlistStock stock){
        getRepository().removeFromWatchlist(stock);
    }

    public MutableLiveData<List<WatchlistStock>> getWatchlistLiveData(){
        return getRepository().getWatchlistLiveData();
    }

    public static WatchlistViewModel newInstance(Application application){
        return new WatchlistViewModel(application);
    }

    private StocksRepositoryImpl getRepository(){
        return mStocksRepository;
    }
}
