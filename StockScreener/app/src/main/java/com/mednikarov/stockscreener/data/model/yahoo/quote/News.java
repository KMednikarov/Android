package com.mednikarov.stockscreener.data.model.yahoo.quote;

import java.math.BigInteger;

public class News {
    private BigInteger datetime;
    private String headline;
    private String source;
    private String url;
    private String summary;
    private String related;
    private String image;
    private String lang;
    private boolean hasPaywall;

    public BigInteger getDatetime() {
        return datetime;
    }

    public void setDatetime(BigInteger datetime) {
        this.datetime = datetime;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getRelated() {
        return related;
    }

    public void setRelated(String related) {
        this.related = related;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getLang() {
        return lang;
    }

    public void setLang(String lang) {
        this.lang = lang;
    }

    public boolean isHasPaywall() {
        return hasPaywall;
    }

    public void setHasPaywall(boolean hasPaywall) {
        this.hasPaywall = hasPaywall;
    }
}
