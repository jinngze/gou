package com.example.k2.model;





import com.example.k2.callback.MyCallBack;

import java.util.Map;

/**
 * Model接口
 */
public interface IModel {
    void requestData(String url, Map<String, String> params, Class clazz, MyCallBack callBack);
}
