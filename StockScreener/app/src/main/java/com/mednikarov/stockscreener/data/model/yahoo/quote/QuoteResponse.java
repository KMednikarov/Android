package com.mednikarov.stockscreener.data.model.yahoo.quote;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class QuoteResponse {
    @SerializedName("result")
    private List<QuoteData> result;
    @SerializedName("error")
    private Error error;

    public List<QuoteData> getQuoteData() {
        return result;
    }

    public void setQuoteData(List<QuoteData> result) {
        this.result = result;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
