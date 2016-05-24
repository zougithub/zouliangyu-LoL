package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.util.SlidingMenu;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.fragment.community.CommunityFragment;
import com.zouliangyu.lol.fragment.hero.HeroFragment;
import com.zouliangyu.lol.fragment.information.InformationFragment;
import com.zouliangyu.lol.fragment.more.MoreFragment;
import com.zouliangyu.lol.fragment.video.VideoFragment;

/**
 * 邹良禹
 * LoL掌游宝
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private String[] titles = {"新闻资讯", "视频", "英雄搜索", "社区", "更多"};
    private TextView titleTv;
    private ImageView rightIv;

    private int[] ids = {R.id.main_information_rb, R.id.main_video_rb,
            R.id.main_hero_rb, R.id.main_community_rb, R.id.main_more_rb};

    private SlidingMenu mLeftMenu;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        for (int i = 0; i < ids.length; i++) {
            findViewById(ids[i]).setOnClickListener(this);
        }

        titleTv = (TextView) findViewById(R.id.title_tv);
        rightIv = (ImageView) findViewById(R.id.title_right_iv);
        mLeftMenu = (SlidingMenu) findViewById(R.id.menu);


    }

    @Override
    protected void initData() {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_replace, new InformationFragment());

        titleTv.setText(titles[0]);
        titleTv.setTextColor(Color.WHITE);
        rightIv.setImageResource(R.mipmap.information_search);
        transaction.commit();

    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.main_information_rb:
                transaction.replace(R.id.main_replace, new InformationFragment());
                titleTv.setText(titles[0]);
                rightIv.setImageResource(R.mipmap.information_search);
                rightIv.setVisibility(View.VISIBLE);
                break;
            case R.id.main_video_rb:
                transaction.replace(R.id.main_replace, new VideoFragment());
                titleTv.setText(titles[1]);
                rightIv.setImageResource(R.mipmap.video_download);
                rightIv.setVisibility(View.VISIBLE);
                break;
            case R.id.main_hero_rb:
                transaction.replace(R.id.main_replace, new HeroFragment());
                titleTv.setText(titles[2]);
                rightIv.setVisibility(View.GONE);
                break;
            case R.id.main_community_rb:
                transaction.replace(R.id.main_replace, new CommunityFragment());
                titleTv.setText(titles[3]);
                rightIv.setVisibility(View.GONE);
                break;
            case R.id.main_more_rb:
                transaction.replace(R.id.main_replace, new MoreFragment());
                titleTv.setText(titles[4]);
                rightIv.setVisibility(View.GONE);
                break;
        }
        transaction.commit();

    }

    public void toggleMenu(View view) {
        mLeftMenu.toggle();

    }
}
