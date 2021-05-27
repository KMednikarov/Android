package com.mednikarov.stockscreener.data.model;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Embedded;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.mednikarov.stockscreener.data.model.yahoo.market.ChartData;

import org.jetbrains.annotations.NotNull;

import java.math.BigDecimal;

/***
 * The WatchlistStock class is used for data transfer throughout the application.
 * When stock information is requested from a REST API, it's values are assigned to this class and then transferred to other parts of the app.
 */
@Entity(tableName = "stocks")
public class WatchlistStock {
    @PrimaryKey
    @NonNull
    private String symbol = "_N/A_";
    @ColumnInfo(name = "company_name")
    private String companyName;
    @ColumnInfo(name = "last_price")
    private double lastPrice;
    private BigDecimal volume;
    @Embedded
    private ChartData chart;
    @Ignore
    private String error;
    @ColumnInfo(name = "is_in_watchlist")
    private boolean isInWatchlist;

    @Ignore
    public WatchlistStock(@NotNull String symbol, String companyName, double lastPrice, BigDecimal volume) {
        this.symbol = symbol;
        this.companyName = companyName;
        this.lastPrice = lastPrice;
        this.volume = volume;
    }
    public WatchlistStock() {
    }

    @NonNull
    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(@NonNull String symbol) {
        this.symbol = symbol;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public ChartData getChart() {
        return chart;
    }

    public void setChart(ChartData chart) {
        this.chart = chart;
    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }

    public boolean isInWatchlist() {
        return isInWatchlist;
    }

    public void setIsInWatchlist(boolean isInWatchlist) {
        this.isInWatchlist = isInWatchlist;
    }
}
