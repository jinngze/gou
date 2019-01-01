package com.example.day5.model;

import com.example.day5.callback.MyCallBack;

import java.util.Map;

public interface IModel {

    void requestData(String url, Map<String,String> params, Class clazz, MyCallBack callBack);
}
