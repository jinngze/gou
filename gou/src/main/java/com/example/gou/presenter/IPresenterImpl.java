package com.example.gou.presenter;



import com.example.gou.callback.MyCallBack;
import com.example.gou.model.IModelImpl;
import com.example.gou.view.IView;

import java.util.Map;

public class IPresenterImpl implements IPresenter {
    private IView iView;
    private IModelImpl iModel;

    public IPresenterImpl(IView iView) {
        this.iView = iView;
        iModel = new IModelImpl();
    }

    @Override
    public void pRequestData(String urlStr, Map<String, String> params, Class clazz) {
        iModel.mRequestData(urlStr, params, clazz, new MyCallBack() {
            @Override
            public void OnSuccess(Object object) {
                iView.viewDatas(object);
            }
        });
    }

    public void onDetch(){
        if (iView != null){
            iView = iView;
        }
        if (iModel != null){
            iModel = null;
        }
    }

}
