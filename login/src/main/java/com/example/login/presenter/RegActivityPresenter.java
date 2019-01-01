package com.example.login.presenter;



import com.example.login.activity.ZhuCeActivity;
import com.example.login.model.RegActivityModel;
import com.example.login.model.RegActivityModelListener;

public class RegActivityPresenter {


    private RegActivityViewListener listener ;
    private RegActivityModel model;

    public RegActivityPresenter(RegActivityViewListener regActivityViewListener) {
        this.listener = regActivityViewListener;
        this.model = new RegActivityModel();
    }

    public void login(String username, String password){

        // 空判断 合法性
        model.login(username, password, new RegActivityModelListener() {
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

