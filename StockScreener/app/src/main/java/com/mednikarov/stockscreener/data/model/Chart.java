package com.mednikarov.stockscreener.data.model;

import java.math.BigInteger;

public class Chart {
    private double close;
    private double high;
    private double low;
    private double open;
    private String symbol;
    private BigInteger volume;
    private String id;
    private String key;
    private String subkey;
    private String date;
    /*private BigInteger updated;
    private double changeOverTime;
    private double marketChangeOverTime;
    private double uOpen;
    private double uClose;
    private double uHigh;
    private double uLow;
    private double uVolume;
    private double fOpen;
    private double fClose;
    private double fHigh;
    private double fLow;
    private double fVolume;
    private String label;*/
    private double change;
    private double changePercent;


    public double getClose() {
        return close;
    }

    public void setClose(double close) {
        this.close = close;
    }

    public double getHigh() {
        return high;
    }

    public void setHigh(double high) {
        this.high = high;
    }

    public double getLow() {
        return low;
    }

    public void setLow(double low) {
        this.low = low;
    }

    public double getOpen() {
        return open;
    }

    public void setOpen(double open) {
        this.open = open;
    }

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public BigInteger getVolume() {
        return volume;
    }

    public void setVolume(BigInteger volume) {
        this.volume = volume;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getSubkey() {
        return subkey;
    }

    public void setSubkey(String subkey) {
        this.subkey = subkey;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getChange() {
        return change;
    }

    public void setChange(double change) {
        this.change = change;
    }

    public double getChangePercent() {
        return changePercent;
    }

    public void setChangePercent(double changePercent) {
        this.changePercent = changePercent;
    }
}
