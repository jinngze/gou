package com.example.dell.jingze20181221.model;

import com.example.dell.jingze20181221.callback.MyCallBack;

import java.util.Map;

public interface IModel {

    void  requestData(String url, Map<String,String> params, Class clazz, MyCallBack callBack);


}
