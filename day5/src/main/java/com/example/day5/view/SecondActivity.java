package com.example.day5.view;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.example.day5.R;

import butterknife.BindView;
import butterknife.ButterKnife;


public class SecondActivity extends AppCompatActivity {


    @BindView(R.id.an)
    Button an;
    @BindView(R.id.image)
    ImageView image;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        ButterKnife.bind(this);


        an.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                //旋转动画
                ObjectAnimator animator = ObjectAnimator.ofFloat(image, "rotation", 0f, 180f);
                // 透明  渐变动画
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(image, "alpha", 0f, 0.8f);
                //组合动画对象
                AnimatorSet animatorSet = new AnimatorSet();
                animatorSet.play(animator1).with(animator);
                //  执行动画时长
                animatorSet.setDuration(2000);
                //  开始的动画
                animatorSet.start();
                //跳转
                animatorSet.addListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animator) {

                    }

                    //   End  代表 结束后  跳转
                    @Override
                    public void onAnimationEnd(Animator animator) {

                        startActivity(new Intent(SecondActivity.this,MainActivity.class));
                        finish();
                    }

                    @Override
                    public void onAnimationCancel(Animator animator) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animator) {

                    }
                });

            }
        });
    }

}
