package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.os.Handler;
import android.widget.ImageView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;

/**
 * Created by zouliangyu on 16/5/10.
 */
public class WelcomeActivity extends BaseActivity{
    private ImageView welcomeIv;
    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        welcomeIv = (ImageView) findViewById(R.id.welcome_iv);

    }

    @Override
    protected void initData() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(WelcomeActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        },1000);
    }
}
