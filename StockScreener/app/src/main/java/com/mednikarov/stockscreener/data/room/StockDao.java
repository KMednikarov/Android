package com.mednikarov.stockscreener.data.room;

import androidx.room.Dao;
import androidx.room.Query;

import com.mednikarov.stockscreener.data.model.Quote;

import java.util.List;

@Dao
abstract class StockDao implements BaseDao<Quote> {

    @Query("SELECT * FROM quotes")
    abstract List<Quote> selectAll();
    @Query("SELECT * FROM quotes WHERE symbol = (:name)")
    abstract Quote selectByName(String name);
}
