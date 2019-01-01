package com.example.home.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.constraint.ConstraintLayout;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;


import com.bumptech.glide.Glide;
import com.example.home.R;
import com.example.home.bean.GoodsBean;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;

import static java.util.regex.Pattern.*;

public class RecycViewAdptar extends RecyclerView.Adapter<RecycViewAdptar.ViewHolder> {
    private Context context;
    private List<GoodsBean.DataBean.ListBean> mlist;

    public RecycViewAdptar(Context context) {
        this.context = context;
        mlist = new ArrayList<>();
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View view = View.inflate(context, R.layout.body_item, null);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, final int i) {
        viewHolder.item_title.setText(mlist.get(i).getTitle());

        Pattern pen = compile("\\|");
        String images = mlist.get(i).getImages();
        String[] split = pen.split(images);
        Glide.with(context).load(split[0]).into(viewHolder.item_img);

        viewHolder.con.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View v) {
                if(clickCallBack!=null){
                    clickCallBack.setItemOnClick(i);
                }
                return true;
            }
        });


    }

    @Override
    public int getItemCount() {
        return mlist.size();
    }

    public void setData(List<GoodsBean.DataBean.ListBean> listBeans) {
        this.mlist = listBeans;
        notifyDataSetChanged();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        private final TextView item_title;
        private final ImageView item_img;
        private final ConstraintLayout con;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            item_title = itemView.findViewById(R.id.item_title);
            item_img = itemView.findViewById(R.id.item_img);
            con = itemView.findViewById(R.id.con);
        }
    }


    private onClickCallBack clickCallBack;



    public interface onClickCallBack{

        void setItemOnClick(int i);

    }

    public void setItemOnClicklisenter(onClickCallBack clicklisenter){

        this.clickCallBack = clicklisenter;

    }
}
