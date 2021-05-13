package com.mednikarov.stockscreener.data.model;

import java.util.List;

public class Response<T> {
    private List<T> responseData;
    private boolean success = false;

    public List<T> getData(){
        return responseData;
    }

    public void setData(List<T> data){
        responseData = data;
    }

    public void addToData(T data){
        responseData.add(data);
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

}
