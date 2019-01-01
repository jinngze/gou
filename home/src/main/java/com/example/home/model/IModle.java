package com.example.home.model;

import android.util.Log;


import com.example.home.bean.GoodsBean;
import com.example.home.bean.HandBean;
import com.example.home.bean.HomeBean;
import com.example.home.bean.Sean;
import com.example.home.callback.MyCallBack;
import com.example.home.okhttputil.Httputil;
import com.example.home.okhttputil.ICallBack;


public class IModle implements IM {

    @Override
    public void setResponse(String url, final MyCallBack myCallBack) {
        Httputil.getInstance().getEnqueue(url, HandBean.class, new ICallBack() {
            @Override
            public void success(Object obj) {
                myCallBack.setCallback(obj);
            }
            @Override
            public void failed(Exception e) {
                Log.d("ws",""+e);
            }
        });
    }

    @Override
    public void setbodyResponse(String url, final MyCallBack myCallBack) {
        Httputil.getInstance().getEnqueue(url, GoodsBean.class, new ICallBack() {
            @Override
            public void success(Object obj) {
               myCallBack.setCallback(obj);
            }

            @Override
            public void failed(Exception e) {
                Log.d("ws",""+e);
            }
        });
    }

    @Override
    public void setviewResponse(String url, final MyCallBack myCallBack) {
        Httputil.getInstance().getEnqueue(url, Sean.class, new ICallBack() {
            @Override
            public void success(Object obj) {
                myCallBack.setCallback(obj);
            }

            @Override
            public void failed(Exception e) {

            }
        });
    }
}
