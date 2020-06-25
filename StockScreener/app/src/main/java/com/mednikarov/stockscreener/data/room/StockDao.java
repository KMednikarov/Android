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
public interface StockDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(Stock stock);
    @Delete
    void delete(Stock stock);
    @Update
    void update(Stock stock);
    @Query("SELECT * FROM  stock")
    List<Stock> selectAll();
    @Query("SELECT * FROM stock WHERE companyName = (:name)")
    Stock selectByName(String name);
}
