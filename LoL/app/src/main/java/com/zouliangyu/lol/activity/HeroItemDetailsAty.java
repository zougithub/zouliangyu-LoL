package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroImgBean;
import com.zouliangyu.lol.fragment.hero.herodetails.HeroDetailsAroundFragment;
import com.zouliangyu.lol.fragment.hero.herodetails.HeroDetailsDataFragment;
import com.zouliangyu.lol.fragment.hero.herodetails.HeroDetailsGuideFragment;
import com.zouliangyu.lol.fragment.hero.herodetails.HeroDetailsIntroduceFragment;
import com.zouliangyu.lol.fragment.hero.herodetails.HeroDetailsPlayFragment;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/16.
 * <p/>
 * 英雄详情界面
 */
public class HeroItemDetailsAty extends BaseActivity implements View.OnClickListener {
    private int[] ids = {R.id.aty_hero_item_details_introduce, R.id.aty_hero_item_details_data,
            R.id.aty_hero_item_details_play, R.id.aty_hero_item_details_guide,
            R.id.aty_hero_item_details_around};
    private ImageView headIv;
    private List<AllHeroImgBean> allHeroImgBeans;

    @Override
    protected int getLayout() {
        return R.layout.aty_hero_item_details;
    }

    @Override
    protected void initView() {
        for (int i = 0; i < ids.length; i++) {
            findViewById(ids[i]).setOnClickListener(this);
        }
        headIv = (ImageView) findViewById(R.id.aty_hero_item_details_head);

    }

    @Override
    protected void initData() {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.aty_hero_item_details_replace, new HeroDetailsIntroduceFragment());
        transaction.commit();

    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.aty_hero_item_details_introduce:
                transaction.replace(R.id.aty_hero_item_details_replace, new HeroDetailsIntroduceFragment());
                break;
            case R.id.aty_hero_item_details_data:
                transaction.replace(R.id.aty_hero_item_details_replace, new HeroDetailsDataFragment());
                break;
            case R.id.aty_hero_item_details_play:
                transaction.replace(R.id.aty_hero_item_details_replace, new HeroDetailsPlayFragment());
                break;
            case R.id.aty_hero_item_details_guide:
                transaction.replace(R.id.aty_hero_item_details_replace, new HeroDetailsGuideFragment());
                break;
            case R.id.aty_hero_item_details_around:
                transaction.replace(R.id.aty_hero_item_details_replace, new HeroDetailsAroundFragment());
                break;
        }
        transaction.commit();
    }
}
