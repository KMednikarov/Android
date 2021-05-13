package com.mednikarov.stockscreener.viewmodels;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.MutableLiveData;

import com.mednikarov.stockscreener.data.model.Quote;
import com.mednikarov.stockscreener.data.model.StockBatch;
import com.mednikarov.stockscreener.data.repository.StocksRepository;
import com.mednikarov.stockscreener.data.repository.StocksRepositoryImpl;

import java.util.List;

public class WatchlistViewModel extends AndroidViewModel {
    private MutableLiveData<Quote> mStockLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Quote>> mWatchlistLiveData = new MutableLiveData<>();
    private StocksRepository mStocksRepository;
    public WatchlistViewModel(@NonNull Application application){
        super(application);
        mStocksRepository = StocksRepositoryImpl.newInstance(application);

    }
    public void updateStockData(){
        getWatchlistLiveData().setValue(getRepository().getWatchlist());
    }

    public void addToWatchlist(Quote quote){
        getRepository().addToWatchlist(quote);
    }

    public void removeFromWatchlist(Quote quote){
        getRepository().removeFromWatchlist(quote);
    }

    private StocksRepository getRepository(){
        return mStocksRepository;
    }
    public MutableLiveData<Quote> getLiveData(){
        return mStockLiveData;
    }
    public MutableLiveData<List<Quote>> getWatchlistLiveData(){
        return mWatchlistLiveData;
    }
    public static WatchlistViewModel newInstance(Application application){
        return new WatchlistViewModel(application);
    }
}
