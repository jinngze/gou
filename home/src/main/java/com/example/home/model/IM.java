package com.example.home.model;


import com.example.home.callback.MyCallBack;

public interface IM {
    void setResponse(String url, MyCallBack myCallBack);
    void setbodyResponse(String url, MyCallBack myCallBack);
    void setviewResponse(String url, MyCallBack myCallBack);
}
