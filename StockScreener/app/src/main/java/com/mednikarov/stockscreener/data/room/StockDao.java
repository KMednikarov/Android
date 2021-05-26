package com.mednikarov.stockscreener.data.room;

import androidx.room.Dao;
import androidx.room.Query;

import com.mednikarov.stockscreener.data.model.WatchlistStock;

import java.util.List;

@Dao
abstract class StockDao implements BaseDao<WatchlistStock> {

    @Query("SELECT * FROM stocks order by symbol asc")
    abstract List<WatchlistStock> selectAll();
    @Query("SELECT * FROM stocks WHERE symbol = (:name)")
    abstract WatchlistStock selectByName(String name);

    @Query("DELETE FROM stocks")
    abstract void cleanStocksTable();
}
