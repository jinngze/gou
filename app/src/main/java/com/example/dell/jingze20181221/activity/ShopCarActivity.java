package com.example.dell.jingze20181221.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;


import com.example.dell.jingze20181221.Apis;
import com.example.dell.jingze20181221.Constants;
import com.example.dell.jingze20181221.R;
import com.example.dell.jingze20181221.adapter.ShopAdapter;
import com.example.dell.jingze20181221.bean.ShopBean;
import com.example.dell.jingze20181221.presenter.ShowPresenter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ShopCarActivity extends AppCompatActivity implements  IView, View.OnClickListener {

    private ShopAdapter mShopAdapter;
    private CheckBox mIvCircle;
    private List<ShopBean.DataBean> mList = new ArrayList<>();
    private TextView mAllpriceTxt,nSumprice;
    private ShowPresenter mShowPresenter;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu);

        mShowPresenter = new ShowPresenter(this);

        initView();
        getData();

    }



    private void initView() {

        mIvCircle = findViewById(R.id.checkbox);
        mAllpriceTxt= findViewById(R.id.all_price);
        nSumprice =  findViewById(R.id.summit);
        mIvCircle.setOnClickListener(this);

       

        RecyclerView mRecyclerView = findViewById(R.id.recycle);
        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        mRecyclerView.setLayoutManager(linearLayoutManager);
        mShowPresenter = new ShowPresenter(this);
        mShopAdapter = new ShopAdapter(this);
        mRecyclerView.setAdapter(mShopAdapter);

      mShopAdapter.setListener(new ShopAdapter.ShopCallBackListener() {
          @Override
          public void callBack(List<ShopBean.DataBean> list) {



              double totalPrice = 0;


              int num = 0;

              int totalNum = 0;
              for (int a = 0; a<list.size(); a++){

                  List<ShopBean.DataBean.ListBean> listAll = list.get(a).getList();
                  for (int i = 0; i<listAll.size(); i++){
                      totalNum = totalNum + listAll.get(i).getNum();

                      if(listAll.get(i).isCheck()) {
                          totalPrice = totalPrice + (listAll.get(i).getPrice() * listAll.get(i).getNum());

                          num = num + listAll.get(i).getNum();
                      }
                  }
              }

              if(num < totalNum) {
                  //不是全部选中
                  mIvCircle.setChecked(false);
              }else{
                  //是全部选中
                  mIvCircle.setChecked(true);
              }
              mAllpriceTxt.setText("合计:"+ totalPrice);
              nSumprice.setText("去结算("+ num +")");
          }
      });
    }

    private void getData() {
        Map<String,String> map = new HashMap<>();
        map.put(Constants.UID,"71");
        mShowPresenter.startRequest(Apis.URL,map,ShopBean.class);


    }
    @Override
    public void showResponseData(Object data) {
         if(data instanceof  ShopBean) {
             ShopBean shopBean = (ShopBean) data;
             mList = shopBean.getData();
             if(mList != null) {
                 mList.remove(0);
                 mShopAdapter.setList(mList);
             }
         }
    }

    @Override
    public void showResponseFail(Object data) {

    }


    @Override
    public void onClick(View view) {

        switch (view.getId()){
            case R.id.checkbox:
                checkSeller(mIvCircle.isChecked());
                mShopAdapter.notifyDataSetChanged();
                break;
                default:
        }
    }


     //修改选中状态，获取价格和数量

    private void checkSeller(boolean checked) {

        double totalPrice = 0;
        int num = 0;
        for (int a = 0; a<mList.size(); a++) {
            //遍历商家，改变状态
            ShopBean.DataBean dataBean = mList.get(a);
            dataBean.setCheck(checked);

            List<ShopBean.DataBean.ListBean> listAll = mList.get(a).getList();
            for (int i = 0; i<listAll.size(); i++){
                //遍历商品，改变状态
                listAll.get(i).setCheck(checked);
                totalPrice = totalPrice + (listAll.get(i).getPrice() * listAll.get(i).getNum());
                num = num + listAll.get(i).getNum();
            }
        }

        if(checked) {
            mAllpriceTxt.setText("合计:" + totalPrice);
            nSumprice.setText("去结算（"+ num +")");
        }else{
            mAllpriceTxt.setText("合计: 0.00");
            nSumprice.setText("去结算(0)");
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mShowPresenter.onDetach();
    }


}
