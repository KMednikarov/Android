package com.mednikarov.stockscreener.data.room;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.mednikarov.stockscreener.data.model.Stock;

import java.util.List;

@Dao
abstract class StockDao implements BaseDao<Stock> {

    @Query("SELECT * FROM  stock")
    abstract List<Stock> selectAll();
    @Query("SELECT * FROM stock WHERE companyName = (:name)")
    abstract Stock selectByName(String name);
}
