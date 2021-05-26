package com.mednikarov.stockscreener.data.model.yahoo.quote;

import androidx.room.TypeConverters;

import com.google.gson.annotations.SerializedName;
import com.mednikarov.stockscreener.data.Converters;

import java.math.BigDecimal;
import java.util.List;

@TypeConverters(Converters.class)
public class Quote {
    @SerializedName("open")
    private List<Double> open;
    @SerializedName("close")
    private List<Double> close;
    @SerializedName("low")
    private List<Double> low;
    @SerializedName("volume")
    private List<BigDecimal> volume;
    @SerializedName("high")
    private List<Double> high;

    public List<Double> getOpen() {
        return open;
    }

    public void setOpen(List<Double> open) {
        this.open = open;
    }

    public List<Double> getClose() {
        return close;
    }

    public void setClose(List<Double> close) {
        this.close = close;
    }

    public List<Double> getLow() {
        return low;
    }

    public void setLow(List<Double> low) {
        this.low = low;
    }

    public List<BigDecimal> getVolume() {
        return volume;
    }

    public void setVolume(List<BigDecimal> volume) {
        this.volume = volume;
    }

    public List<Double> getHigh() {
        return high;
    }

    public void setHigh(List<Double> high) {
        this.high = high;
    }
}
