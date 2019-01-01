package com.example.login.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.login.R;
import com.example.login.bean.Fean;


import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.compile;

public class MyAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

   Context context;
   List<Fean.DataBean> dataBeans;

    public MyAdapter(Context context, List<Fean.DataBean> list) {
        this.context = context;
        dataBeans = new ArrayList<>();
    }

    public void setdata(List<Fean.DataBean> data) {
        dataBeans.clear();
        dataBeans.addAll(data);
        notifyDataSetChanged();
    }

    public void adddata(List<Fean.DataBean> data) {
        dataBeans.addAll(data);
        notifyDataSetChanged();
    }
    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {

        ViewHolder viewHolder = null;
        View v = View.inflate(context,R.layout.one_image,null);
        viewHolder = new MyAdapter.ViewHolder(v);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {

        ViewHolder holder = (ViewHolder) viewHolder;
        Glide.with(context).load(dataBeans.get(i).getImages()).into(holder.image);
        holder.text.setText(dataBeans.get(i).getTitle());
        holder.price.setText(dataBeans.get(i).getPrice()+"");

        String images = dataBeans.get(i).getImages();

        Pattern pen = compile("\\|");

        String [] img = pen.split(images);

        Glide.with(context).load(img[0]).into(holder.image);

    }

    @Override
    public int getItemCount() {
        return dataBeans.size();
    }


    class ViewHolder extends  RecyclerView.ViewHolder{

        ImageView image;
        TextView text,price;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            text = itemView.findViewById(R.id.text1);
            price = itemView.findViewById(R.id.price);
            image = itemView.findViewById(R.id.tu);

        }

    }

}
