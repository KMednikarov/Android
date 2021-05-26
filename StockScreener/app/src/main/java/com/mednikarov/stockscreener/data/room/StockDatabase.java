package com.mednikarov.stockscreener.data.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.room.TypeConverters;

import com.mednikarov.stockscreener.data.Converters;
import com.mednikarov.stockscreener.data.model.WatchlistStock;

import java.util.List;

@Database(entities = {WatchlistStock.class}, version = 7, exportSchema = false)
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

    public void insertStock(WatchlistStock stock){
        stock.setIsInWatchlist(true);
        stockDao().insert(stock);
    }
    public void cleanStocksTable(){
        stockDao().cleanStocksTable();
    }
    public void deleteStock(WatchlistStock stock){
        stockDao().delete(stock);
    }

    public WatchlistStock getStock(String symbol){
        return stockDao().selectByName(symbol);
    }

    public List<WatchlistStock> getAllWatchlistQuotes(){
        return stockDao().selectAll();
    }
}
