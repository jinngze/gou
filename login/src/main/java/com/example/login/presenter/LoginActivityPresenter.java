package com.example.login.presenter;


import com.example.login.model.LoginActivityModel;
import com.example.login.model.LoginActivityModelListener;

public class LoginActivityPresenter {

    private LoginActivityViewListener listener ;
    private LoginActivityModel model;
    public LoginActivityPresenter(LoginActivityViewListener loginActivityViewListener){

        this.listener = loginActivityViewListener;
        this.model = new LoginActivityModel();

    }
    public void login(String username,String password){

    // 空判断 合法性
        model.login(username, password, new LoginActivityModelListener() {
            @Override
            public void success(Object object) {
                listener.success(object);
            }

            @Override
            public void onfailed() {
                listener.onfailed();
            }
        });


    }

}

