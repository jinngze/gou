package com.example.k2.callback;

public interface MyCallBack<T> {
    void success(T data);
    void failed(Exception e);
}
