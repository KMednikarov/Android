package com.mednikarov.stockscreener.data.model.yahoo.quote;

import java.math.BigDecimal;

public class QuoteData {
    private String symbol;
    private String language;
    private String region;
    private String quoteType;
    private String quoteSourceName;
    private String currency;
    private BigDecimal totalCash;
    private BigDecimal floatShares;
    private BigDecimal ebitda;
    private double shortRatio;
    private double preMarketChange;
    private double preMarketChangePercent;
    private BigDecimal preMarketTime;
    private double targetPriceHigh;
    private double targetPriceLow;
    private double targetPriceMean;
    private double targetPriceMedian;
    private double preMarketPrice;
    private double heldPercentInsiders;
    private double heldPercentInstitutions;
    private double regularMarketChange;
    private double regularMarketChangePercent;
    private BigDecimal regularMarketTime;
    private double regularMarketPrice;
    private double regularMarketDayHigh;
    private String regularMarketDayRange;
    private double regularMarketDayLow;
    private BigDecimal regularMarketVolume;
    private BigDecimal sharesShort;
    private BigDecimal sharesShortPrevMonth;
    private double shortPercentFloat;
    private double regularMarketPreviousClose;
    private double bid;
    private double ask;
    private double bidSize;
    private double askSize;
    private String exchange;
    private String market;
    private String messageBoardId;
    private String fullExchangeName;
    private String shortName;
    private String longName;
    private double regularMarketOpen;
    private BigDecimal averageDailyVolume3Month;
    private BigDecimal averageDailyVolume10Day;
    private double fiftyTwoWeekLowChange;
    private double fiftyTwoWeekLowChangePercent;
    private String fiftyTwoWeekRange;
    private double fiftyTwoWeekHighChange;
    private double fiftyTwoWeekHighChangePercent;
    private double fiftyTwoWeekLow;
    private double fiftyTwoWeekHigh;
    private BigDecimal exDividendDate;
    private BigDecimal earningsTimestamp;
    private BigDecimal earningsTimestampStart;
    private BigDecimal earningsTimestampEnd;
    private double trailingPE;
    private double pegRatio;
    private double dividendsPerShare;
    private BigDecimal revenue;
    private double priceToSales;
    private String marketState;
    private double epsTrailingTwelveMonths;
    private double epsForward;
    private double epsCurrentYear;
    private double epsNextQuarter;
    private double priceEpsCurrentYear;
    private double priceEpsNextQuarter;
    private BigDecimal sharesOutstanding;
    private double bookValue;
    private double fiftyDayAverage;
    private double fiftyDayAverageChange;
    private double fiftyDayAverageChangePercent;
    private double twoHundredDayAverage;
    private double twoHundredDayAverageChange;
    private double twoHundredDayAverageChangePercent;
    private BigDecimal marketCap;
    private double forwardPE;
    private double priceToBook;
    private int sourceInterval;
    private int exchangeDataDelayedBy;
    private String exchangeTimezoneName;
    private String exchangeTimezoneShortName;
    private boolean esgPopulated;
    private boolean tradeable;
    private BigDecimal firstTradeDateMilliseconds;
    private int priceHint;

    public String getSymbol() {
        return symbol;
    }

    public void setSymbol(String symbol) {
        this.symbol = symbol;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public String getRegion() {
        return region;
    }

    public void setRegion(String region) {
        this.region = region;
    }

    public String getQuoteType() {
        return quoteType;
    }

    public void setQuoteType(String quoteType) {
        this.quoteType = quoteType;
    }

    public String getQuoteSourceName() {
        return quoteSourceName;
    }

    public void setQuoteSourceName(String quoteSourceName) {
        this.quoteSourceName = quoteSourceName;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    public BigDecimal getTotalCash() {
        return totalCash;
    }

    public void setTotalCash(BigDecimal totalCash) {
        this.totalCash = totalCash;
    }

    public BigDecimal getFloatShares() {
        return floatShares;
    }

    public void setFloatShares(BigDecimal floatShares) {
        this.floatShares = floatShares;
    }

    public BigDecimal getEbitda() {
        return ebitda;
    }

    public void setEbitda(BigDecimal ebitda) {
        this.ebitda = ebitda;
    }

    public double getShortRatio() {
        return shortRatio;
    }

    public void setShortRatio(double shortRatio) {
        this.shortRatio = shortRatio;
    }

    public double getPreMarketChange() {
        return preMarketChange;
    }

    public void setPreMarketChange(double preMarketChange) {
        this.preMarketChange = preMarketChange;
    }

    public double getPreMarketChangePercent() {
        return preMarketChangePercent;
    }

    public void setPreMarketChangePercent(double preMarketChangePercent) {
        this.preMarketChangePercent = preMarketChangePercent;
    }

    public BigDecimal getPreMarketTime() {
        return preMarketTime;
    }

    public void setPreMarketTime(BigDecimal preMarketTime) {
        this.preMarketTime = preMarketTime;
    }

    public double getTargetPriceHigh() {
        return targetPriceHigh;
    }

    public void setTargetPriceHigh(double targetPriceHigh) {
        this.targetPriceHigh = targetPriceHigh;
    }

    public double getTargetPriceLow() {
        return targetPriceLow;
    }

    public void setTargetPriceLow(double targetPriceLow) {
        this.targetPriceLow = targetPriceLow;
    }

    public double getTargetPriceMean() {
        return targetPriceMean;
    }

    public void setTargetPriceMean(double targetPriceMean) {
        this.targetPriceMean = targetPriceMean;
    }

    public double getTargetPriceMedian() {
        return targetPriceMedian;
    }

    public void setTargetPriceMedian(double targetPriceMedian) {
        this.targetPriceMedian = targetPriceMedian;
    }

    public double getPreMarketPrice() {
        return preMarketPrice;
    }

    public void setPreMarketPrice(double preMarketPrice) {
        this.preMarketPrice = preMarketPrice;
    }

    public double getHeldPercentInsiders() {
        return heldPercentInsiders;
    }

    public void setHeldPercentInsiders(double heldPercentInsiders) {
        this.heldPercentInsiders = heldPercentInsiders;
    }

    public double getHeldPercentInstitutions() {
        return heldPercentInstitutions;
    }

    public void setHeldPercentInstitutions(double heldPercentInstitutions) {
        this.heldPercentInstitutions = heldPercentInstitutions;
    }

    public double getRegularMarketChange() {
        return regularMarketChange;
    }

    public void setRegularMarketChange(double regularMarketChange) {
        this.regularMarketChange = regularMarketChange;
    }

    public double getRegularMarketChangePercent() {
        return regularMarketChangePercent;
    }

    public void setRegularMarketChangePercent(double regularMarketChangePercent) {
        this.regularMarketChangePercent = regularMarketChangePercent;
    }

    public BigDecimal getRegularMarketTime() {
        return regularMarketTime;
    }

    public void setRegularMarketTime(BigDecimal regularMarketTime) {
        this.regularMarketTime = regularMarketTime;
    }

    public double getRegularMarketPrice() {
        return regularMarketPrice;
    }

    public void setRegularMarketPrice(double regularMarketPrice) {
        this.regularMarketPrice = regularMarketPrice;
    }

    public double getRegularMarketDayHigh() {
        return regularMarketDayHigh;
    }

    public void setRegularMarketDayHigh(double regularMarketDayHigh) {
        this.regularMarketDayHigh = regularMarketDayHigh;
    }

    public String getRegularMarketDayRange() {
        return regularMarketDayRange;
    }

    public void setRegularMarketDayRange(String regularMarketDayRange) {
        this.regularMarketDayRange = regularMarketDayRange;
    }

    public double getRegularMarketDayLow() {
        return regularMarketDayLow;
    }

    public void setRegularMarketDayLow(double regularMarketDayLow) {
        this.regularMarketDayLow = regularMarketDayLow;
    }

    public BigDecimal getRegularMarketVolume() {
        return regularMarketVolume;
    }

    public void setRegularMarketVolume(BigDecimal regularMarketVolume) {
        this.regularMarketVolume = regularMarketVolume;
    }

    public BigDecimal getSharesShort() {
        return sharesShort;
    }

    public void setSharesShort(BigDecimal sharesShort) {
        this.sharesShort = sharesShort;
    }

    public BigDecimal getSharesShortPrevMonth() {
        return sharesShortPrevMonth;
    }

    public void setSharesShortPrevMonth(BigDecimal sharesShortPrevMonth) {
        this.sharesShortPrevMonth = sharesShortPrevMonth;
    }

    public double getShortPercentFloat() {
        return shortPercentFloat;
    }

    public void setShortPercentFloat(double shortPercentFloat) {
        this.shortPercentFloat = shortPercentFloat;
    }

    public double getRegularMarketPreviousClose() {
        return regularMarketPreviousClose;
    }

    public void setRegularMarketPreviousClose(double regularMarketPreviousClose) {
        this.regularMarketPreviousClose = regularMarketPreviousClose;
    }

    public double getBid() {
        return bid;
    }

    public void setBid(double bid) {
        this.bid = bid;
    }

    public double getAsk() {
        return ask;
    }

    public void setAsk(double ask) {
        this.ask = ask;
    }

    public double getBidSize() {
        return bidSize;
    }

    public void setBidSize(double bidSize) {
        this.bidSize = bidSize;
    }

    public double getAskSize() {
        return askSize;
    }

    public void setAskSize(double askSize) {
        this.askSize = askSize;
    }

    public String getExchange() {
        return exchange;
    }

    public void setExchange(String exchange) {
        this.exchange = exchange;
    }

    public String getMarket() {
        return market;
    }

    public void setMarket(String market) {
        this.market = market;
    }

    public String getMessageBoardId() {
        return messageBoardId;
    }

    public void setMessageBoardId(String messageBoardId) {
        this.messageBoardId = messageBoardId;
    }

    public String getFullExchangeName() {
        return fullExchangeName;
    }

    public void setFullExchangeName(String fullExchangeName) {
        this.fullExchangeName = fullExchangeName;
    }

    public String getShortName() {
        return shortName;
    }

    public void setShortName(String shortName) {
        this.shortName = shortName;
    }

    public String getLongName() {
        return longName;
    }

    public void setLongName(String longName) {
        this.longName = longName;
    }

    public double getRegularMarketOpen() {
        return regularMarketOpen;
    }

    public void setRegularMarketOpen(double regularMarketOpen) {
        this.regularMarketOpen = regularMarketOpen;
    }

    public BigDecimal getAverageDailyVolume3Month() {
        return averageDailyVolume3Month;
    }

    public void setAverageDailyVolume3Month(BigDecimal averageDailyVolume3Month) {
        this.averageDailyVolume3Month = averageDailyVolume3Month;
    }

    public BigDecimal getAverageDailyVolume10Day() {
        return averageDailyVolume10Day;
    }

    public void setAverageDailyVolume10Day(BigDecimal averageDailyVolume10Day) {
        this.averageDailyVolume10Day = averageDailyVolume10Day;
    }

    public double getFiftyTwoWeekLowChange() {
        return fiftyTwoWeekLowChange;
    }

    public void setFiftyTwoWeekLowChange(double fiftyTwoWeekLowChange) {
        this.fiftyTwoWeekLowChange = fiftyTwoWeekLowChange;
    }

    public double getFiftyTwoWeekLowChangePercent() {
        return fiftyTwoWeekLowChangePercent;
    }

    public void setFiftyTwoWeekLowChangePercent(double fiftyTwoWeekLowChangePercent) {
        this.fiftyTwoWeekLowChangePercent = fiftyTwoWeekLowChangePercent;
    }

    public String getFiftyTwoWeekRange() {
        return fiftyTwoWeekRange;
    }

    public void setFiftyTwoWeekRange(String fiftyTwoWeekRange) {
        this.fiftyTwoWeekRange = fiftyTwoWeekRange;
    }

    public double getFiftyTwoWeekHighChange() {
        return fiftyTwoWeekHighChange;
    }

    public void setFiftyTwoWeekHighChange(double fiftyTwoWeekHighChange) {
        this.fiftyTwoWeekHighChange = fiftyTwoWeekHighChange;
    }

    public double getFiftyTwoWeekHighChangePercent() {
        return fiftyTwoWeekHighChangePercent;
    }

    public void setFiftyTwoWeekHighChangePercent(double fiftyTwoWeekHighChangePercent) {
        this.fiftyTwoWeekHighChangePercent = fiftyTwoWeekHighChangePercent;
    }

    public double getFiftyTwoWeekLow() {
        return fiftyTwoWeekLow;
    }

    public void setFiftyTwoWeekLow(double fiftyTwoWeekLow) {
        this.fiftyTwoWeekLow = fiftyTwoWeekLow;
    }

    public double getFiftyTwoWeekHigh() {
        return fiftyTwoWeekHigh;
    }

    public void setFiftyTwoWeekHigh(double fiftyTwoWeekHigh) {
        this.fiftyTwoWeekHigh = fiftyTwoWeekHigh;
    }

    public BigDecimal getExDividendDate() {
        return exDividendDate;
    }

    public void setExDividendDate(BigDecimal exDividendDate) {
        this.exDividendDate = exDividendDate;
    }

    public BigDecimal getEarningsTimestamp() {
        return earningsTimestamp;
    }

    public void setEarningsTimestamp(BigDecimal earningsTimestamp) {
        this.earningsTimestamp = earningsTimestamp;
    }

    public BigDecimal getEarningsTimestampStart() {
        return earningsTimestampStart;
    }

    public void setEarningsTimestampStart(BigDecimal earningsTimestampStart) {
        this.earningsTimestampStart = earningsTimestampStart;
    }

    public BigDecimal getEarningsTimestampEnd() {
        return earningsTimestampEnd;
    }

    public void setEarningsTimestampEnd(BigDecimal earningsTimestampEnd) {
        this.earningsTimestampEnd = earningsTimestampEnd;
    }

    public double getTrailingPE() {
        return trailingPE;
    }

    public void setTrailingPE(double trailingPE) {
        this.trailingPE = trailingPE;
    }

    public double getPegRatio() {
        return pegRatio;
    }

    public void setPegRatio(double pegRatio) {
        this.pegRatio = pegRatio;
    }

    public double getDividendsPerShare() {
        return dividendsPerShare;
    }

    public void setDividendsPerShare(double dividendsPerShare) {
        this.dividendsPerShare = dividendsPerShare;
    }

    public BigDecimal getRevenue() {
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        this.revenue = revenue;
    }

    public double getPriceToSales() {
        return priceToSales;
    }

    public void setPriceToSales(double priceToSales) {
        this.priceToSales = priceToSales;
    }

    public String getMarketState() {
        return marketState;
    }

    public void setMarketState(String marketState) {
        this.marketState = marketState;
    }

    public double getEpsTrailingTwelveMonths() {
        return epsTrailingTwelveMonths;
    }

    public void setEpsTrailingTwelveMonths(double epsTrailingTwelveMonths) {
        this.epsTrailingTwelveMonths = epsTrailingTwelveMonths;
    }

    public double getEpsForward() {
        return epsForward;
    }

    public void setEpsForward(double epsForward) {
        this.epsForward = epsForward;
    }

    public double getEpsCurrentYear() {
        return epsCurrentYear;
    }

    public void setEpsCurrentYear(double epsCurrentYear) {
        this.epsCurrentYear = epsCurrentYear;
    }

    public double getEpsNextQuarter() {
        return epsNextQuarter;
    }

    public void setEpsNextQuarter(double epsNextQuarter) {
        this.epsNextQuarter = epsNextQuarter;
    }

    public double getPriceEpsCurrentYear() {
        return priceEpsCurrentYear;
    }

    public void setPriceEpsCurrentYear(double priceEpsCurrentYear) {
        this.priceEpsCurrentYear = priceEpsCurrentYear;
    }

    public double getPriceEpsNextQuarter() {
        return priceEpsNextQuarter;
    }

    public void setPriceEpsNextQuarter(double priceEpsNextQuarter) {
        this.priceEpsNextQuarter = priceEpsNextQuarter;
    }

    public BigDecimal getSharesOutstanding() {
        return sharesOutstanding;
    }

    public void setSharesOutstanding(BigDecimal sharesOutstanding) {
        this.sharesOutstanding = sharesOutstanding;
    }

    public double getBookValue() {
        return bookValue;
    }

    public void setBookValue(double bookValue) {
        this.bookValue = bookValue;
    }

    public double getFiftyDayAverage() {
        return fiftyDayAverage;
    }

    public void setFiftyDayAverage(double fiftyDayAverage) {
        this.fiftyDayAverage = fiftyDayAverage;
    }

    public double getFiftyDayAverageChange() {
        return fiftyDayAverageChange;
    }

    public void setFiftyDayAverageChange(double fiftyDayAverageChange) {
        this.fiftyDayAverageChange = fiftyDayAverageChange;
    }

    public double getFiftyDayAverageChangePercent() {
        return fiftyDayAverageChangePercent;
    }

    public void setFiftyDayAverageChangePercent(double fiftyDayAverageChangePercent) {
        this.fiftyDayAverageChangePercent = fiftyDayAverageChangePercent;
    }

    public double getTwoHundredDayAverage() {
        return twoHundredDayAverage;
    }

    public void setTwoHundredDayAverage(double twoHundredDayAverage) {
        this.twoHundredDayAverage = twoHundredDayAverage;
    }

    public double getTwoHundredDayAverageChange() {
        return twoHundredDayAverageChange;
    }

    public void setTwoHundredDayAverageChange(double twoHundredDayAverageChange) {
        this.twoHundredDayAverageChange = twoHundredDayAverageChange;
    }

    public double getTwoHundredDayAverageChangePercent() {
        return twoHundredDayAverageChangePercent;
    }

    public void setTwoHundredDayAverageChangePercent(double twoHundredDayAverageChangePercent) {
        this.twoHundredDayAverageChangePercent = twoHundredDayAverageChangePercent;
    }

    public BigDecimal getMarketCap() {
        return marketCap;
    }

    public void setMarketCap(BigDecimal marketCap) {
        this.marketCap = marketCap;
    }

    public double getForwardPE() {
        return forwardPE;
    }

    public void setForwardPE(double forwardPE) {
        this.forwardPE = forwardPE;
    }

    public double getPriceToBook() {
        return priceToBook;
    }

    public void setPriceToBook(double priceToBook) {
        this.priceToBook = priceToBook;
    }

    public int getSourceInterval() {
        return sourceInterval;
    }

    public void setSourceInterval(int sourceInterval) {
        this.sourceInterval = sourceInterval;
    }

    public int getExchangeDataDelayedBy() {
        return exchangeDataDelayedBy;
    }

    public void setExchangeDataDelayedBy(int exchangeDataDelayedBy) {
        this.exchangeDataDelayedBy = exchangeDataDelayedBy;
    }

    public String getExchangeTimezoneName() {
        return exchangeTimezoneName;
    }

    public void setExchangeTimezoneName(String exchangeTimezoneName) {
        this.exchangeTimezoneName = exchangeTimezoneName;
    }

    public String getExchangeTimezoneShortName() {
        return exchangeTimezoneShortName;
    }

    public void setExchangeTimezoneShortName(String exchangeTimezoneShortName) {
        this.exchangeTimezoneShortName = exchangeTimezoneShortName;
    }

    public boolean isEsgPopulated() {
        return esgPopulated;
    }

    public void setEsgPopulated(boolean esgPopulated) {
        this.esgPopulated = esgPopulated;
    }

    public boolean isTradeable() {
        return tradeable;
    }

    public void setTradeable(boolean tradeable) {
        this.tradeable = tradeable;
    }

    public BigDecimal getFirstTradeDateMilliseconds() {
        return firstTradeDateMilliseconds;
    }

    public void setFirstTradeDateMilliseconds(BigDecimal firstTradeDateMilliseconds) {
        this.firstTradeDateMilliseconds = firstTradeDateMilliseconds;
    }

    public int getPriceHint() {
        return priceHint;
    }

    public void setPriceHint(int priceHint) {
        this.priceHint = priceHint;
    }
}
