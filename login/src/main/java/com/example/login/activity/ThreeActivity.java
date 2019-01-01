package com.example.login.activity;


import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;


import com.example.login.R;
import com.example.login.adapter.MyAdapter;
import com.example.login.bean.Fean;
import com.example.login.presenter.ShowPresenter;
import com.example.login.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class ThreeActivity extends AppCompatActivity implements IView {


    private XRecyclerView xRecyclerView;
    private MyAdapter adapter;
    private ShowPresenter showPresenter;
    private String  urlStr="http://www.zhaoapi.cn/product/searchProducts?keywords=%E6%89%8B%E6%9C%BA";
    private Fean bean;
    private int mPage;
    private List<Fean.DataBean> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three);

        showPresenter = new ShowPresenter(this);
        init();


    }



    private void init() {
        xRecyclerView = findViewById(R.id.Xrecycle);

        showPresenter = new ShowPresenter(this);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(linearLayoutManager);

        adapter = new MyAdapter(this,list);
        xRecyclerView.setAdapter(adapter);

        LinearLayoutManager linearLayoutManager1 = new LinearLayoutManager(this);
        linearLayoutManager1.setOrientation(LinearLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(linearLayoutManager1);

        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                mPage = 1;
                initData();
            }

            @Override
            public void onLoadMore() {

                initData();
            }
        });

        initData();


    }

    private void initData() {

        Map<String,String> map = new HashMap<>();
        map.put("mpage","1");
        showPresenter.startRequest(urlStr,map,Fean.class);

    }

    @Override
    public void showResponseData(Object data) {

        bean = (Fean) data;

        if(mPage == 1){
            adapter.setdata(bean.getData());
        }else{
            adapter.adddata(bean.getData());
        }

        bean = (Fean) data;

        mPage++;
        xRecyclerView.refreshComplete();
        xRecyclerView.loadMoreComplete();
    }

    @Override
    public void showResponseFail(Object data) {

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        showPresenter.onDetach();
    }
}
