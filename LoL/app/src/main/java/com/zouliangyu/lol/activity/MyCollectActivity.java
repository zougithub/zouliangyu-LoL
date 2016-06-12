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
<<<<<<< HEAD
 */
public class MyCollectActivity extends BaseActivity implements View.OnClickListener {
    // 标题
=======
 *
 */
public class MyCollectActivity extends BaseActivity implements View.OnClickListener {
    private RelativeLayout article;
    private RelativeLayout hero;
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private ImageView exitIv;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.drawer_collect;
    }

    // 初始化
    @Override
    protected void initView() {
<<<<<<< HEAD
        findViewById(R.id.article).setOnClickListener(this); // 收藏文章
        findViewById(R.id.hero).setOnClickListener(this); // 收藏英雄
        //标题
=======
        article = (RelativeLayout) findViewById(R.id.article);
        article.setOnClickListener(this);
        hero = (RelativeLayout) findViewById(R.id.hero);
        hero.setOnClickListener(this);

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        exitIv.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        // 设置标题栏
        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("我的收藏");
        titleTv.setTextColor(Color.WHITE);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.article:
<<<<<<< HEAD
                // 跳到收藏的文章界面
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                Intent intentArticle = new Intent(this, CollectArticleActivity.class);
                startActivity(intentArticle);
                break;
            case R.id.hero:
<<<<<<< HEAD
                // 跳到收藏的英雄的界面
                Intent intentHero = new Intent(this, CollectHeroActivity.class);
=======
                Intent intentHero = new Intent(this,CollectHeroActivity.class);
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                startActivity(intentHero);
                break;
            case R.id.title_left_iv:
                finish();
                break;
        }
    }
}
