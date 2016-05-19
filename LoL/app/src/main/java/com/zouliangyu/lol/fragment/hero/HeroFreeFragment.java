package com.zouliangyu.lol.fragment.hero;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.HeroItemDetailsAty;
import com.zouliangyu.lol.adapter.HeroFreeAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.bean.HeroFreeFalseData;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouliangyu on 16/5/16.
 */
public class HeroFreeFragment extends BaseFragment implements HeroFreeAdapter.MyItemClickListener {
    private RecyclerView recyclerView;
    private List<HeroFreeFalseData> heroFreeFalseDatas;
    private HeroFreeAdapter heroFreeAdapter;

    @Override
    public int initLayout() {
        return R.layout.fragment_hero_free;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.free_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

    }

    @Override
    public void initData() {
        heroFreeAdapter = new HeroFreeAdapter(getContext());
        heroFreeFalseDatas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            heroFreeFalseDatas.add(new HeroFreeFalseData(R.mipmap.ic_launcher, "韩老梗", "250元", "10点券"));
        }
        heroFreeAdapter.setHeroFreeFalseDatas(heroFreeFalseDatas);
        recyclerView.setAdapter(heroFreeAdapter);

        heroFreeAdapter.setmItemClickListener(this);

    }

    @Override
    public void onItemClickListener(View view, int position) {
        Intent intent = new Intent(getContext(), HeroItemDetailsAty.class);
        // 把id传过去
        startActivity(intent);
    }
}
