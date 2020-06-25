package com.mednikarov.stockscreener.data.model;

public class Stock {
    private String symbolName;
    private String companyName;
    private String date;
    private double openPrice;
    private double closePrice;
    private double lowPrice;
    private double highPrice;

    public Stock(String symbolName, String companyName, String date, double openPrice, double closePrice, double lowPrice, double highPrice) {
        this.symbolName = symbolName;
        this.companyName = companyName;
        this.date = date;
        this.openPrice = openPrice;
        this.closePrice = closePrice;
        this.lowPrice = lowPrice;
        this.highPrice = highPrice;
    }

    public String getSymbolName() {
        return symbolName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public String getDate() {
        return date;
    }

    public double getOpenPrice() {
        return openPrice;
    }

    public double getClosePrice() {
        return closePrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }
}
