package com.mednikarov.stockscreener.data.model.yahoo.market;

import androidx.room.ColumnInfo;
import androidx.room.Embedded;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;
import java.util.List;

public class ChartData {
    @SerializedName("meta")
    @Embedded
    private ChartMetadata chartMetadata;
    @SerializedName("timestamp")
    @ColumnInfo(name = "timestamp")
    private List<BigDecimal> timestamp;
    @SerializedName("indicators")
    @Embedded
    private Indicator indicators;

    public ChartData(){
    }

    public List<BigDecimal> getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(List<BigDecimal> timestamp) {
        this.timestamp = timestamp;
    }

    public Indicator getIndicators() {
        return indicators;
    }

    public void setIndicators(Indicator indicators) {
        this.indicators = indicators;
    }

    public ChartMetadata getChartMetadata() {
        return chartMetadata;
    }

    public void setChartMetadata(ChartMetadata chartMetadata) {
        this.chartMetadata = chartMetadata;
    }

}
