package com.lanxiang.myanimations;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView mIv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button alpha = (Button) findViewById(R.id.alpha);
        Button scale = (Button) findViewById(R.id.scale);
        Button rotate = (Button) findViewById(R.id.rotate);
        Button translate = (Button) findViewById(R.id.translate);
        Button set = (Button) findViewById(R.id.set);
        mIv = (ImageView) findViewById(R.id.iv);
        Button frame = (Button) findViewById(R.id.frame);
        alpha.setOnClickListener(this);
        scale.setOnClickListener(this);
        rotate.setOnClickListener(this);
        translate.setOnClickListener(this);
        set.setOnClickListener(this);
        frame.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.alpha:
                createAlpha();
                break;
            case R.id.scale:
                createScale();
                break;
            case R.id.rotate:
                createRotate();
                break;
            case R.id.translate:
                createTranslate();
                break;
            case R.id.set:
                createSet();
                break;
            case R.id.frame:
                Intent intent = new Intent(MainActivity.this,FrameActivity.class);
                startActivity(intent);
                break;
        }
    }

    /**
     * 动画集合
     */
    private void createSet() {
        AnimationSet set = new AnimationSet(true);
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f,1.0f);
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f,1.0f,0f,1.0f,
                Animation.RELATIVE_TO_SELF,0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        RotateAnimation rotateAnimation = new RotateAnimation(0,360,Animation.RELATIVE_TO_SELF,
                0.5f,Animation.RELATIVE_TO_SELF,0.5f);
        set.addAnimation(alphaAnimation);
        set.addAnimation(scaleAnimation);
        set.addAnimation(rotateAnimation);
        set.setDuration(5000);
        mIv.startAnimation(set);
    }

    /**
     * 平移
     */
    private void createTranslate() {
        TranslateAnimation translateAnimation = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,1.0f,
                Animation.RELATIVE_TO_SELF,0f,
                Animation.RELATIVE_TO_SELF,1.0f);
        translateAnimation.setDuration(5000);
        mIv.startAnimation(translateAnimation);
    }

    /**
     * 旋转
     */
    private void createRotate() {
        RotateAnimation rotateAnimation = new RotateAnimation(0,270,Animation.RELATIVE_TO_SELF,0.5f,
                Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(5000);
        rotateAnimation.setFillAfter(true);//保持动画之后的状态
        mIv.startAnimation(rotateAnimation);
    }

    /**
     * 缩放
     */
    private void createScale() {
        ScaleAnimation scaleAnimation = new ScaleAnimation(0f//x轴的初始值
                ,1.5f//x轴缩放后的值
                ,0f//y轴的初始值
                ,1.5f//y轴缩放后的值
                , Animation.RELATIVE_TO_SELF//确定x轴的坐标类型
                ,0.5f
                ,Animation.RELATIVE_TO_SELF,0.5f
        );
        scaleAnimation.setDuration(5000);
        mIv.startAnimation(scaleAnimation);
    }

    /**
     * 渐变
     */
    private void createAlpha() {
        AlphaAnimation alphaAnimation = new AlphaAnimation(0f,1f);
        alphaAnimation.setDuration(5000);
        alphaAnimation.setRepeatCount(3);//重复次数
        mIv.startAnimation(alphaAnimation);
    }
}
