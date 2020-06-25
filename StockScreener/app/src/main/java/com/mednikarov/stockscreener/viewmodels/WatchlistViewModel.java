package com.mednikarov.stockscreener.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mednikarov.stockscreener.data.Repository;
import com.mednikarov.stockscreener.data.StocksRepository;
import com.mednikarov.stockscreener.data.model.Stock;

public class WatchlistViewModel extends ViewModel {
    private MutableLiveData<Stock> mStockLiveData;
    private Repository mStocksRepository;
    public WatchlistViewModel(){
        mStocksRepository = StocksRepository.getInstance();
    }
    public void updateStockData(){

        Stock stock = getRepository().getStock("AAPL");
        getLiveData().postValue(stock);
    }

    private Repository getRepository(){
        return mStocksRepository;
    }
    private MutableLiveData<Stock> getLiveData(){
        return mStockLiveData;
    }
}
