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

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import butterknife.BindView;
import butterknife.ButterKnife;

import static java.util.regex.Pattern.compile;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.SubViewHolder> {

    Context context;
    List<Fean.DataBean> beanList;
    private  OnItemClickListener onItemClickListener;


   public interface OnItemClickListener {
        void onItemClick(int position,String title);
   }

    public void setOnItemClickListener(OnItemClickListener onItemClickListener) {
        this.onItemClickListener = onItemClickListener;
    }

    public MyAdapter(Context context, List<Fean.DataBean> list) {
        this.context = context;
        beanList = new ArrayList<>();
    }


    public void setdata( List<Fean.DataBean>data) {
        beanList.clear();
        beanList.addAll(data);
        notifyDataSetChanged();
    }

    public void adddata( List<Fean.DataBean> data) {
       beanList.addAll(data);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public SubViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        //填充子布局
        View inflate = LayoutInflater.from(context).inflate(R.layout.recyclerview_item_layout, viewGroup, false);
        //设置ViewHolder
        SubViewHolder subViewHolder = new SubViewHolder(inflate);
        return subViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull SubViewHolder subViewHolder, final int i) {

        subViewHolder.tvTitle.setText( beanList.get(i).getTitle());
        Glide.with(context).load(beanList.get(i).getImages()).into(subViewHolder.ivIcon);

       String images = beanList.get(i).getImages();

        Pattern pen = compile("\\|");

        String [] img = pen.split(images);

        Glide.with(context).load(img[0]).into(subViewHolder.ivIcon);

        //点击事件
        subViewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(onItemClickListener != null){
                    onItemClickListener.onItemClick(i,beanList.get(i).getTitle());
                }
            }
        });

    }

    @Override
    public int getItemCount() {

        return beanList.size();
    }

    class SubViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

       @BindView(R.id.iv_icon)
        ImageView ivIcon;
        @BindView(R.id.tv_title)
        TextView tvTitle;


        public SubViewHolder(@NonNull View itemView) {
            super(itemView);
           ButterKnife.bind(this,itemView);
           itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v){
            //2.通过接口回调进行事件回传
            //**所需点击的位置
            //获取点击位置
            int position = getLayoutPosition();
            //作为参数进行传递
            onItemClickListener.onItemClick(position,beanList.get(position).getTitle());
        }

    }

}
