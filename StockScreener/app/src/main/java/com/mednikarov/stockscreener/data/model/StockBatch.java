package com.mednikarov.stockscreener.data.model;

import java.util.List;

public class StockBatch {
    private Quote quote;
    private List<News> news;
    private List<Chart> chart;

    public Quote getQuote() {
        return quote;
    }

    public void setQuote(Quote quote) {
        this.quote = quote;
    }

    public List<News> getNews() {
        return news;
    }

    public void setNews(List<News> news) {
        this.news = news;
    }

    public List<Chart> getChart() {
        return chart;
    }

    public void setChart(List<Chart> chart) {
        this.chart = chart;
    }
}
