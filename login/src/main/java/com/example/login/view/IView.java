package com.example.login.view;

public interface IView<T>{

    void showResponseData(T data);
    void showResponseFail(T data);
}
