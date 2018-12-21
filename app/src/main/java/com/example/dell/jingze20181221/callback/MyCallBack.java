package com.example.dell.jingze20181221.callback;

public interface MyCallBack<T> {

    void success(T data);
    void failed(Exception e);
}
