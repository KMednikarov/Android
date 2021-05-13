package com.mednikarov.stockscreener.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.mednikarov.stockscreener.data.Converters;
import com.mednikarov.stockscreener.data.model.Quote;

import java.util.List;

@Database(entities = {Quote.class}, version = 2, exportSchema = false)
@TypeConverters({Converters.class})
public abstract class StockDatabase extends RoomDatabase {
    private static final String DATABASE_NAME = "stock_screener_database";
    private static StockDatabase mDatabaseInstance;
    public abstract StockDao stockDao();

    public StockDatabase() {

    }

    public static StockDatabase getInstance(final Context context){
        if(mDatabaseInstance == null){
            mDatabaseInstance = Room.databaseBuilder(context, StockDatabase.class, DATABASE_NAME)
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build();
        }

        return mDatabaseInstance;
    }

    public void insertStock(Quote quote){
        stockDao().insert(quote);
    }

    public void deleteStock(Quote quote){
        stockDao().delete(quote);
    }

    public Quote getStock(String symbol){
        return stockDao().selectByName(symbol);
    }

    public List<Quote> getAllStocks(){
        return stockDao().selectAll();
    }
}
