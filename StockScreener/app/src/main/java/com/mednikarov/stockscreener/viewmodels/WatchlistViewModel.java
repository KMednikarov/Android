package com.mednikarov.stockscreener.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mednikarov.stockscreener.data.Repository;
import com.mednikarov.stockscreener.data.StocksRepository;
import com.mednikarov.stockscreener.data.model.Stock;

import java.util.List;

public class WatchlistViewModel extends ViewModel {
    private MutableLiveData<Stock> mStockLiveData = new MutableLiveData<>();
    private MutableLiveData<List<Stock>> mWatchlistLiveData = new MutableLiveData<>();
    private Repository mStocksRepository;
    public WatchlistViewModel(){
        mStocksRepository = StocksRepository.getInstance();
    }
    public void updateStockData(){
        getWatchlistLiveData().postValue(getRepository().getWatchlist());
        //Stock stock = getRepository().getStock("AAPL");
        //getLiveData().postValue(stock);
    }

    private Repository getRepository(){
        return mStocksRepository;
    }
    public MutableLiveData<Stock> getLiveData(){
        return mStockLiveData;
    }
    public MutableLiveData<List<Stock>> getWatchlistLiveData(){
        return mWatchlistLiveData;
    }
    public static WatchlistViewModel newInstance(){
        return new WatchlistViewModel();
    }
}
