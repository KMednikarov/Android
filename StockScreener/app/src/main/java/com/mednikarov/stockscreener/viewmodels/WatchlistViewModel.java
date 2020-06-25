package com.mednikarov.stockscreener.viewmodels;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.mednikarov.stockscreener.data.Repository;
import com.mednikarov.stockscreener.data.model.Stock;

public class WatchlistViewModel extends ViewModel {
    private MutableLiveData<Stock> stockLiveData;
    private Repository stocksRepository;
    public MutableLiveData<Stock> getStockLiveData() {
        return stockLiveData;
    }

    public void updateStockData(){
        Stock stock = new Stock("AAPL","Apple Inc.","25.06.2020",155,555,235,445);
        stockLiveData.postValue(stock);
    }
}
