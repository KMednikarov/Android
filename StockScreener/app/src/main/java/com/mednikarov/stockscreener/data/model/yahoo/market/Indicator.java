package com.mednikarov.stockscreener.data.model.yahoo.market;

import com.google.gson.annotations.SerializedName;
import com.mednikarov.stockscreener.data.model.yahoo.quote.Quote;

import java.util.List;

public class Indicator {
    @SerializedName("quote")
    private List<Quote> quote;

    public Indicator(){
    }

    public List<Quote> getQuote() {
        return quote;
    }

    public void setQuote(List<Quote> quote) {
        this.quote = quote;
    }

}
