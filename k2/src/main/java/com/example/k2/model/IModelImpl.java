package com.example.k2.model;



import com.example.k2.callback.MyCallBack;
import com.example.k2.okHttp.ICallBack;
import com.example.k2.okHttp.OkHttpUtils;

import java.util.Map;

public class IModelImpl implements IModel {
    @Override
    public void requestData(final String url, Map<String, String> params, final Class clazz, final MyCallBack callBack) {
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
