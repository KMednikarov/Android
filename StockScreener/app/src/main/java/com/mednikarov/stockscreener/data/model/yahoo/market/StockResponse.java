package com.mednikarov.stockscreener.data.model.yahoo.market;

import com.google.gson.annotations.SerializedName;

public class StockResponse {
    @SerializedName("chart")
    private Stock stock;

    public Stock getStock() {
        return stock;
    }

    public void setStock(Stock stock) {
        this.stock = stock;
    }
}
