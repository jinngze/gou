package com.example.day5.fragment;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.day5.Constant;
import com.example.day5.R;
import com.example.day5.adapter.MyAdapter;
import com.example.day5.adapter.YouAdapter;
import com.example.day5.bean.BeautyBean;
import com.example.day5.bean.Fean;
import com.example.day5.bean.Sean;
import com.example.day5.presenter.ShowPresenter;
import com.example.day5.view.IView;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment_ju extends Fragment implements IView {

    Context context;
    private XRecyclerView xRecyclerView;
    private YouAdapter adapter;
    private ShowPresenter showPresenter;
    private List<BeautyBean.ResultsBean> list;
    private int mPage;
    private BeautyBean beautyBean;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_ju,container,false);

     

        xRecyclerView = view.findViewById(R.id.Xrecy1);
        showPresenter = new ShowPresenter(this);

        //瀑布流
        //2、*布局管理器
        //①线性   LinearLayoutManager
        //②网格   GridLayoutManager
        //③瀑布流 StaggeredGridLayoutManager
        //LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.VERTICAL, false);
        GridLayoutManager manager = new GridLayoutManager(context, 2,GridLayoutManager.VERTICAL,false);
        //final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);

        //适配器
        adapter = new YouAdapter(getActivity(),list);
        xRecyclerView.setAdapter(adapter);

        //刷新 加载
        xRecyclerView.setPullRefreshEnabled(true);
        xRecyclerView.setLoadingMoreEnabled(true);

        xRecyclerView.setLoadingListener(new XRecyclerView.LoadingListener() {
            @Override
            public void onRefresh() {

                mPage =1 ;
                initData();
            }

            @Override
            public void onLoadMore() {

                initData();
            }
        });

        initData();


        return view;
    }

    private void initData() {

        Map<String,String> map = new HashMap<>();
        map.put("mpage","1");
        showPresenter.startRequest(Constant.BEAUTY_URL,map,BeautyBean.class);

    }


    @Override
    public void showResponseData(Object data) {

         beautyBean = (BeautyBean) data;

        if(mPage == 1){
            adapter.setdata(beautyBean.getResults() );
        }else{
            adapter.adddata(beautyBean.getResults());
        }

        beautyBean = (BeautyBean) data;

        mPage++;
        xRecyclerView.refreshComplete();
        xRecyclerView.loadMoreComplete();
    }

    @Override
    public void showResponseFail(Object data) {

    }


    //内存泄漏
    @Override
    public void onDestroy() {
        super.onDestroy();
        showPresenter.onDetach();
    }
}