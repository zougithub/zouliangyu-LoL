package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;

/**
 * Created by zouliangyu on 16/5/26.
 * 收藏界面
 */
public class MyCollectActivity extends BaseActivity implements View.OnClickListener {
    private RelativeLayout article;
    private RelativeLayout hero;
    private ImageView exitIv;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.drawer_collect;

    }

    @Override
    protected void initView() {
        article = (RelativeLayout) findViewById(R.id.article);
        hero = (RelativeLayout) findViewById(R.id.hero);
        article.setOnClickListener(this);

        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        exitIv.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("我的收藏");
        titleTv.setTextColor(Color.WHITE);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.article:
                Intent intentCollect = new Intent(this, MyCollectDetailsActivity.class);
                startActivity(intentCollect);
                break;
            case R.id.hero:

                break;
            case R.id.title_left_iv:
                finish();
                break;
        }
    }
}
