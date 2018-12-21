package com.example.dell.jingze20181221.model;

import com.example.dell.jingze20181221.callback.MyCallBack;
import com.example.dell.jingze20181221.util.ICallBack;
import com.example.dell.jingze20181221.util.OkHttpUtils;

import java.util.Map;

import okhttp3.OkHttpClient;

public class ShowModel implements IModel {
    @Override
    public void requestData(String url, Map<String, String> params, Class clazz, final MyCallBack callBack) {

        OkHttpUtils.getInstance().postEnqueue(url, params, clazz, new ICallBack() {
            @Override
            public void success(Object obj) {
                callBack.success(obj);
            }

            @Override
            public void failed(Exception e) {

                callBack.failed(e);
            }
        });
    }
}
