package com.example.dell.jingze20181221.presenter;

import com.example.dell.jingze20181221.activity.IView;
import com.example.dell.jingze20181221.callback.MyCallBack;
import com.example.dell.jingze20181221.model.IModel;
import com.example.dell.jingze20181221.model.ShowModel;


import java.util.Map;

public class ShowPresenter implements  IPresenter {

    private IModel iModel;
    private IView iView;

    public ShowPresenter(IView iView) {
        this.iView = iView;
        iModel = new ShowModel();
    }

    @Override
    public void startRequest(String url, Map<String, String> params, Class clazz) {

        iModel.requestData(url, params, clazz, new MyCallBack() {
            @Override
            public void success(Object data) {
                 iView.showResponseData(data);
            }

            @Override
            public void failed(Exception e) {

                iView.showResponseFail(e);
            }
        });

    }


    public void onDetach(){
        if(iModel != null){
            iModel = null;
        }
        if(iView != null){
            iView = null;
        }
    }
}
