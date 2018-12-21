package com.example.dell.jingze20181221.activity;

public interface IView<T>{

    void showResponseData(T data);
    void showResponseFail(T data);
}
