package com.zouliangyu.lol.activity;

import android.view.View;
import android.widget.ImageView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;

/**
 * Created by zouliangyu on 16/5/24.
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView exitIv;

    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        exitIv.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        exitIv.setImageResource(R.mipmap.global_back_d);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left_iv:
                finish();
                break;
        }
    }
}
