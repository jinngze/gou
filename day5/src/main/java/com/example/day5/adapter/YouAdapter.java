package com.example.day5.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.day5.R;
import com.example.day5.bean.BeautyBean;
import com.example.day5.bean.Fean;
import com.example.day5.bean.Sean;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class YouAdapter extends RecyclerView.Adapter<YouAdapter.SubViewHolder> {

    Context context;
    List<BeautyBean.ResultsBean> beanList;



    public YouAdapter(Context context, List<BeautyBean.ResultsBean> list) {
        this.context = context;
        beanList = new ArrayList<>();
    }


    public void setdata( List<BeautyBean.ResultsBean> data) {
        beanList.clear();
        beanList.addAll(data);
        notifyDataSetChanged();
    }

    public void adddata( List<BeautyBean.ResultsBean> data) {
        beanList.addAll(data);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        View inflate = LayoutInflater.from(context).inflate(R.layout.recyle, viewGroup, false);
        SubViewHolder subViewHolder = new SubViewHolder(inflate);
        return subViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolder subViewHolder, int i) {

        subViewHolder.tv.setText(beanList.get(i).getCreatedAt());
        Glide.with(context).load(beanList.get(i).getUrl()).into(subViewHolder.im);
    }

    @Override
    public int getItemCount() {
        return beanList.size();
    }

    class SubViewHolder extends RecyclerView.ViewHolder {


        @BindView(R.id.im)
        ImageView im;
        @BindView(R.id.tv)
        TextView tv;

        public SubViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this,itemView);
        }
    }
}
