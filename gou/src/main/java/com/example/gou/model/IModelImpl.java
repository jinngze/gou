package com.example.gou.model;



import com.example.gou.callback.ICallBack;
import com.example.gou.callback.MyCallBack;
import com.example.gou.utils.OkHttps;

import java.util.Map;

public class IModelImpl implements IModel {


    @Override
    public void mRequestData(String urlStr, Map<String, String> params, Class clazz, final MyCallBack myCallBack) {
        OkHttps.getInstance().postRequest(urlStr, params, clazz, new ICallBack() {
            @Override
            public void success(Object object) {
                myCallBack.OnSuccess(object);
            }

            @Override
            public void fails(Exception e) {

            }
        });
    }

}
