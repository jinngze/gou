package com.example.day5.view;

public interface IView<T>{

    void showResponseData(T data);
    void showResponseFail(T data);
}
