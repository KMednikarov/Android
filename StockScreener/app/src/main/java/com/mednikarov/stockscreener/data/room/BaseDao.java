package com.mednikarov.stockscreener.data.room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

import com.mednikarov.stockscreener.data.model.Stock;

public interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    public void insert(T item);
    @Delete
    void delete(T item);
    @Update
    void update(T item);}
