package com.mednikarov.stockscreener.data.retrofit;

import com.mednikarov.stockscreener.data.model.yahoo.market.StockResponse;
import com.mednikarov.stockscreener.data.model.yahoo.quote.QuoteResponse;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;

public interface YahooStockService {
    static final String API_KEY = "x-rapidapi-key: 0b8861c73fmshf2d20cfbe923540p1a6e3ajsn098a201bf50d";
    static final String API_HOST = "x-rapidapi-host: apidojo-yahoo-finance-v1.p.rapidapi.com";

    @Headers({API_KEY,API_HOST})
    @GET("/market/v2/get-quotes")
    public Call<QuoteResponse> getQuote(@Query("region") String region
                                    , @Query("symbols") String symbols);
    @Headers({API_KEY,API_HOST})
    @GET("/stock/v2/get-chart")
    public Call<StockResponse> getChart(@Query("interval") String interval
                                    , @Query("symbol") String symbol
                                    , @Query("range") String range
                                    , @Query("region") String region);
}
