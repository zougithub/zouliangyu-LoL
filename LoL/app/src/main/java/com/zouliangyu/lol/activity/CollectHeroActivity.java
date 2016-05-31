package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.CollectHeroAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.greendao.GreendaoSingle;
import com.zouliangyu.lol.greendao.Hero;
import com.zouliangyu.lol.greendao.HeroDao;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/29.
 * 收藏英雄的详情
 */
public class CollectHeroActivity extends BaseActivity implements CollectHeroAdapter.MyItemClickListener {
    private RecyclerView recyclerView;
    private CollectHeroAdapter collectHeroAdapter;
    private HeroDao heroDao;
    private List<Hero> heros;

    private ImageView exitIv;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_collect_hero;
    }
    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.collect_hero_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 4));


        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        exitIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {
        titleTv.setText("我收藏的英雄");
        titleTv.setTextColor(Color.WHITE);
        exitIv.setImageResource(R.mipmap.global_back_d);


        collectHeroAdapter = new CollectHeroAdapter(this);
        // 单例 用到一个
        heroDao = GreendaoSingle.getInstance().getHeroDao();
        // 查询数据库
        heros = heroDao.queryBuilder().list();
        collectHeroAdapter.setHeros(heros);
        recyclerView.setAdapter(collectHeroAdapter);

        collectHeroAdapter.setMyItemClickListener(this);

    }


    @Override
    public void onItemClickListener(int position) {
        String enName = heros.get(position).getEnName();
        Intent intent = new Intent(this, HeroDetailsActivity.class);
        intent.putExtra("enName", enName);
        startActivity(intent);
    }
}
