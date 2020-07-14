package com.mednikarov.stockscreener.viewmodels;

import android.app.Application;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mednikarov.stockscreener.data.StocksRepository;
import com.mednikarov.stockscreener.data.StocksRepositoryImpl;
import com.mednikarov.stockscreener.data.model.Stock;

import java.util.List;

public class WatchlistViewModel extends ViewModel {
    private MutableLiveData<Stock> mStockLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Stock>> mWatchlistLiveData = new MutableLiveData<>();
    private StocksRepository mStocksRepository;
    private WatchlistViewModel(Application application){
        mStocksRepository = StocksRepositoryImpl.newInstance(application);
    }
    public void updateStockData(){
        getWatchlistLiveData().postValue(getRepository().getWatchlist());
        //Stock stock = getRepository().getStock("AAPL");
        //getLiveData().postValue(stock);
    }

    private StocksRepository getRepository(){
        return mStocksRepository;
    }
    public MutableLiveData<Stock> getLiveData(){
        return mStockLiveData;
    }
    public MutableLiveData<List<Stock>> getWatchlistLiveData(){
        return mWatchlistLiveData;
    }
    public static WatchlistViewModel newInstance(Application application){
        return new WatchlistViewModel(application);
    }
}
