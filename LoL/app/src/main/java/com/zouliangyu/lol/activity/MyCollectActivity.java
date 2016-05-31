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
 *
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
        article.setOnClickListener(this);
        hero = (RelativeLayout) findViewById(R.id.hero);
        hero.setOnClickListener(this);

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
                Intent intentArticle = new Intent(this, CollectArticleActivity.class);
                startActivity(intentArticle);
                break;
            case R.id.hero:
                Intent intentHero = new Intent(this,CollectHeroActivity.class);
                startActivity(intentHero);
                break;
            case R.id.title_left_iv:
                finish();
                break;
        }
    }
}
