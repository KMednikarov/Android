package com.mednikarov.stockscreener.data.model.yahoo.market;

import androidx.room.Ignore;

import com.google.gson.annotations.SerializedName;

import java.math.BigDecimal;

public class ChartMetadata {
    @SerializedName("currency")
    private String currency;
    @SerializedName("symbol")
    @Ignore
    private String symbol;
    @SerializedName("exchangeName")
    private String exchangeName;
    @SerializedName("instrumentType")
    private String instrumentType;
    @SerializedName("firstTradeDate")
    private BigDecimal firstTradeDate;
    @SerializedName("regularMarketTime")
    private BigDecimal regularMarketTime;
    @SerializedName("gmtoffset")
    private int gmtoffset;
    @SerializedName("timezone")
    private String timezone;
    @SerializedName("exchangeTimezoneName")
    private String exchangeTimezoneName;
    @SerializedName("regularMarketPrice")
    private double regularMarketPrice;
    @SerializedName("chartPreviousClose")
    private double chartPreviousClose;
    @SerializedName("previousClose")
    private double previousClose;
    @SerializedName("scale")
    private int scale;
    @SerializedName("priceHint")
    private int priceHint;
    @SerializedName("dataGranularity")
    private String dataGranularity;
    @SerializedName("range")
    private String range;

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getExchangeName() {
        return exchangeName;
    }

    public void setExchangeName(String exchangeName) {
        this.exchangeName = exchangeName;
    }

    public String getInstrumentType() {
        return instrumentType;
    }

    public void setInstrumentType(String instrumentType) {
        this.instrumentType = instrumentType;
    }

    public BigDecimal getFirstTradeDate() {
        return firstTradeDate;
    }

    public void setFirstTradeDate(BigDecimal firstTradeDate) {
        this.firstTradeDate = firstTradeDate;
    }

    public BigDecimal getRegularMarketTime() {
        return regularMarketTime;
    }

    public void setRegularMarketTime(BigDecimal regularMarketTime) {
        this.regularMarketTime = regularMarketTime;
    }

    public int getGmtoffset() {
        return gmtoffset;
    }

    public void setGmtoffset(int gmtoffset) {
        this.gmtoffset = gmtoffset;
    }

    public String getTimezone() {
        return timezone;
    }

    public void setTimezone(String timezone) {
        this.timezone = timezone;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(double regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public double getChartPreviousClose() {
        return chartPreviousClose;
    }

    public void setChartPreviousClose(double chartPreviousClose) {
        this.chartPreviousClose = chartPreviousClose;
    }

    public double getPreviousClose() {
        return previousClose;
    }

    public void setPreviousClose(double previousClose) {
        this.previousClose = previousClose;
    }

    public int getScale() {
        return scale;
    }

    public void setScale(int scale) {
        this.scale = scale;
    }

    public int getPriceHint() {
        return priceHint;
    }

    public void setPriceHint(int priceHint) {
        this.priceHint = priceHint;
    }

    public String getDataGranularity() {
        return dataGranularity;
    }

    public void setDataGranularity(String dataGranularity) {
        this.dataGranularity = dataGranularity;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }
}
