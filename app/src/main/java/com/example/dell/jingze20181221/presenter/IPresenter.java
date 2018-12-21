package com.example.dell.jingze20181221.presenter;

import com.example.dell.jingze20181221.callback.MyCallBack;

import java.util.Map;

public interface IPresenter {

    void  startRequest(String url, Map<String,String> params, Class clazz);
}
