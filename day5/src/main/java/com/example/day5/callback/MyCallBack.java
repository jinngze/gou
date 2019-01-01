package com.example.day5.callback;

public interface MyCallBack<T> {

    void success(T data);
    void failed(Exception e);
}
