package com.mednikarov.stockscreener.ui.adapters;


import android.graphics.Color;
import android.view.View;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.github.mikephil.charting.charts.LineChart;
import com.github.mikephil.charting.data.Entry;
import com.github.mikephil.charting.data.LineData;
import com.github.mikephil.charting.data.LineDataSet;
import com.github.mikephil.charting.interfaces.datasets.ILineDataSet;
import com.mednikarov.stockscreener.R;
import com.mednikarov.stockscreener.data.model.WatchlistStock;
import com.mednikarov.stockscreener.data.model.yahoo.market.ChartData;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

public class WatchlistViewHolder extends RecyclerView.ViewHolder{
    private static List<WatchlistItemChanged> watchlistObsevers = new ArrayList<>();
    private WatchlistStock mStock;
    private final TextView txtSymbolName;
    private final TextView txtPrice;
    private final CheckBox btnWatchlist;
    private LineChart chartStock;

    public WatchlistViewHolder(@NonNull View itemView) {
        super(itemView);

        txtSymbolName = itemView.findViewById(R.id.txt_symbol);
        txtPrice = itemView.findViewById(R.id.txt_price);
        btnWatchlist = itemView.findViewById(R.id.btn_stock_watch);
        chartStock = itemView.findViewById(R.id.chart_stock);
        btnWatchlist.setOnCheckedChangeListener(addToWatchlistListener);
    }


    public void setData(WatchlistStock stock){
        mStock = stock;

        setupVisualData();
        setupChart();
    }

    /***
     * Set the data inside the CardView (everything except the chart)
     */

    private void setupVisualData() {
        String symbolName = getStock().getSymbol();
        double lastPrice = getStock().getLastPrice();

        txtSymbolName.setText(symbolName);
        txtPrice.setText(String.valueOf(lastPrice));
        if(isInWatchlist()){
            btnWatchlist.setChecked(true);
        }
    }


    /***
     * Setup the chart for the CardView
     */
    private void setupChart() {
        List<Entry> values = getChartEntries(getStock().getChart());
        LineDataSet dataSet;

        dataSet = new LineDataSet(values, getStock().getChart().getChartMetadata().getSymbol());
        dataSet.setColor(Color.WHITE);
        dataSet.setDrawIcons(false);
        dataSet.setDrawCircles(false);
        dataSet.setDrawValues(false);
        dataSet.setDrawFilled(true);
        dataSet.setFillColor(Color.GREEN);

        dataSet.setLineWidth(1f);
        dataSet.setFormLineWidth(1f);
        dataSet.setFormSize(15.f);
        dataSet.setValueTextSize(0f);
        dataSet.setLabel("");

        ArrayList<ILineDataSet> dataSets = new ArrayList<>();
        dataSets.add(dataSet);

        LineData data = new LineData(dataSets);

        chartStock.setDrawGridBackground(false);
        chartStock.setData(data);
        chartStock.setDescription(null);
        chartStock.getLegend().setEnabled(false);
        chartStock.getAxisRight().setEnabled(false);
        chartStock.getAxisLeft().setEnabled(false);
        chartStock.getXAxis().setEnabled(false);
        chartStock.setPadding(0,0,0,0);
        chartStock.setTouchEnabled(false);
    }


    /***
     * Get ArrayList<Entry> objects used by LineChart to visualize x and y axis
     * @param chartData Data used to extract x and y axises
     * @return ArrayList<Entry>
     */
    private ArrayList<Entry> getChartEntries(ChartData chartData) {
        List<BigDecimal> xAxis = getStock().getChart().getTimestamp();
        List<Double> yAxis = getStock().getChart().getIndicators().getQuote().get(0).getClose();
        ArrayList<Entry> values = new ArrayList<>();
        for(int i = 0; i < xAxis.size(); i++){
            try{
                values.add(new Entry(xAxis.get(i).floatValue()
                        ,yAxis.get(i).floatValue()));
            } catch (Exception e){
                return null;
            }
        }
        return values;
    }

    /***
     * Check if the stock is already in watchlist.
     * @return  boolean
     */
    private boolean isInWatchlist() {
        return getStock().isInWatchlist();
    }

    public static void addObserver(WatchlistItemChanged listener){
        watchlistObsevers.add(listener);
    }


    /***
     * Handle favorite button clicks.
     * Add/remove the stock from watchlist.
     */
    private final CompoundButton.OnCheckedChangeListener addToWatchlistListener = new CompoundButton.OnCheckedChangeListener() {
        @Override
        public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
            if(getStock() == null){
                return;
            }

            if(isChecked){
                //add to watchlist
                for(WatchlistItemChanged observer : watchlistObsevers){
                    observer.onAddedToWatchlist(getStock());
                }
            } else {
                //remove from watchlist
                for(WatchlistItemChanged observer : watchlistObsevers){
                    observer.onRemovedFromWatchlist(getStock());
                }
            }
        }
    };




    /***
     * @return The WatchlistStock item for the current CardView
     */
    private WatchlistStock getStock(){
        return mStock;
    }
}