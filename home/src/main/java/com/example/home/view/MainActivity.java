package com.example.home.view;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.example.home.Apis;
import com.example.home.R;

import com.example.home.bean.HomeBean;
import com.example.home.bean.Sean;
import com.example.home.presonter.Ipresonter;
import com.youth.banner.Banner;
import com.youth.banner.BannerConfig;
import com.youth.banner.loader.ImageLoaderInterface;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements IView{


    private Banner tbanner;
    private Ipresonter ipresonter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tbanner = findViewById(R.id.tbanner);

        ipresonter = new Ipresonter(this);

        ipresonter.setviewRequest(Apis.REQUEST_URL);

        tbanner.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {
                  switch (i){
                      case 0:
                          findViewById(R.id.tiao).setVisibility(View.GONE);//按钮隐藏
                          break;
                      case 1:
                          findViewById(R.id.tiao).setVisibility(View.GONE);//按钮隐藏
                          break;
                      case 2:
                          findViewById(R.id.tiao).setVisibility(View.GONE);//隐藏按钮显示
                          break;

                      case 3:
                          findViewById(R.id.tiao).setVisibility(View.VISIBLE);//隐藏按钮显示
                          break;
                      default:
                          break;

                  }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        findViewById(R.id.tiao).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainActivity.this,HomeActivity.class));
            }
        });

    }


    @Override
    public void setSuccess(final Object data) {
        if(data instanceof Sean){
            Sean sean = (Sean) data;

            tbanner.setBannerStyle(BannerConfig.CIRCLE_INDICATOR);

            tbanner.setImageLoader(new ImageLoaderInterface<ImageView>() {

                @Override
                public void displayImage(Context context, Object path, ImageView imageView) {
                   Sean.NewslistBean sean = ( Sean.NewslistBean) path;
                    Glide.with(context).load(sean.getPicUrl()).into(imageView);
                }

                @Override
                public ImageView createImageView(Context context) {
                    ImageView imageView =new ImageView(context);
                    imageView.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    return null;
                }
            });

            tbanner.setImages(sean.getNewslist());
            tbanner.start();
        }
    }
}
