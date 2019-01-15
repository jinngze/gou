package com.example.k2.activity;

public interface IView<T> {
    void showResponseData(T data);
    void showResponseFail(T data);
}
