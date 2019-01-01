package com.example.login.model;



import com.example.login.callback.MyCallBack;

import java.util.Map;

public interface IModel {

    void  requestData(String url, Map<String, String> params, Class clazz, MyCallBack callBack);


}
