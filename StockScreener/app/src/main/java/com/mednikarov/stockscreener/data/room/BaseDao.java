package com.mednikarov.stockscreener.data.room;

import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Update;

public interface BaseDao<T> {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insert(T item);
    @Delete
    void delete(T item);
    @Update
    void update(T item);}
