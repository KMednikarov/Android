package com.mednikarov.stockscreener.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.mednikarov.stockscreener.data.model.Stock;

@Database(entities = {Stock.class}, version = 1, exportSchema = false)
public abstract class StockDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "stock_screener_database";
    private static StockDatabase mDatabaseInstance;
    public abstract StockDao stockDao();

    public static StockDatabase getInstance(Context context){
        if(mDatabaseInstance == null){
            mDatabaseInstance = Room.databaseBuilder(context, StockDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return mDatabaseInstance;
    }
}
