package com.mednikarov.stockscreener.data.model.yahoo.market;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Stock {
    @SerializedName("result")
    private List<ChartData> chartData;
    @SerializedName("error")
    private Error error;

    public List<ChartData> getChartData() {
        return chartData;
    }

    public ChartData getSingleChartData(){
        return chartData.get(0);
    }

    public ChartMetadata getChartMetadata(){
        return getSingleChartData().getChartMetadata();
    }

    public void setChartData(List<ChartData> chartData) {
        this.chartData = chartData;
    }

    public Error getError() {
        return error;
    }

    public void setError(Error error) {
        this.error = error;
    }
}
