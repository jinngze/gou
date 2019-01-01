package com.example.day5.view;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.example.day5.R;
import com.example.day5.fragment.Fragment_ju;
import com.example.day5.fragment.Fragment_shu;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends FragmentActivity {
    private ViewPager viewpager;
    private List<Fragment> fragmentList;
    private RadioGroup group;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();


    }

    private void initView() {
        viewpager = (ViewPager) findViewById(R.id.viewpager);
        group = (RadioGroup) findViewById(R.id.group);

        fragmentList = new ArrayList<Fragment>();
        fragmentList.add(new Fragment_shu());
        fragmentList.add(new Fragment_ju());


        viewpager.setAdapter(new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int i) {
                return fragmentList.get(i);
            }

            @Override
            public int getCount() {
                return fragmentList.size();
            }
        });

        viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int i, float v, int i1) {

            }

            @Override
            public void onPageSelected(int i) {

                switch (i){
                    case 0:
                        group.check(R.id.button1);
                      break;
                    case 1:
                        group.check(R.id.button2);
                        break;
                        default:
                         break;
                }
            }

            @Override
            public void onPageScrollStateChanged(int i) {

            }
        });

        group.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int i) {

                switch (i){

                    case R.id.button1:
                        viewpager.setCurrentItem(0);
                        break;
                    case R.id.button2:
                        viewpager.setCurrentItem(1);
                        break;
                        default:
                            break;
                }
            }
        });

    }
}
