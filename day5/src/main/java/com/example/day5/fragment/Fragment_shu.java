package com.example.day5.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.day5.Constant;
import com.example.day5.R;
import com.example.day5.adapter.MyAdapter;
import com.example.day5.bean.Fean;
import com.example.day5.presenter.ShowPresenter;
import com.example.day5.view.IView;
import com.example.day5.view.MainActivity;
import com.jcodecraeer.xrecyclerview.XRecyclerView;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Fragment_shu extends Fragment implements IView {


    private XRecyclerView xRecyclerView;
    private MyAdapter adapter;
    private ShowPresenter showPresenter;
    private Fean fean;
    private int mPage;
    private List<Fean.DataBean> list;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_shu,container,false);

        showPresenter = new ShowPresenter(this);

        xRecyclerView = view.findViewById(R.id.Xrecy);
        showPresenter = new ShowPresenter(this);

        //瀑布流
        final StaggeredGridLayoutManager manager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        xRecyclerView.setLayoutManager(manager);

        //适配器
        adapter = new MyAdapter(getActivity(),list);
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


        //点击吐丝事件
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position, String title) {
                Toast.makeText(getActivity(), "点击了"+(title)+"数据", Toast.LENGTH_SHORT).show();
            }
        });

        return view;
    }



    private void initData() {

        Map<String,String> map = new HashMap<>();
        map.put("mpage","1");
        showPresenter.startRequest(Constant.ULT_STR,map,Fean.class);

    }

    @Override
    public void showResponseData(Object data) {

        fean = (Fean) data;

        if(mPage == 1){
            adapter.setdata(fean.getData());
        }else{
            adapter.adddata(fean.getData());
        }

        fean = (Fean) data;

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

