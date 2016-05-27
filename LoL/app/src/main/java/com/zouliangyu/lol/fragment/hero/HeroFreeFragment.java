package com.zouliangyu.lol.fragment.hero;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.HeroDetailsActivity;
import com.zouliangyu.lol.adapter.HeroFreeAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroBean;

/**
 * Created by zouliangyu on 16/5/16.
 * 英雄  周免界面
 */
public class HeroFreeFragment extends BaseFragment implements HeroFreeAdapter.MyItemClickListener {
    private RecyclerView recyclerView;
    private HeroFreeAdapter heroFreeAdapter;
    private AllHeroBean allHeroBean;

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


        VolleySingle.addRequest("http://lolbox.duowan.com/phone/apiHeroes.php?OSType=iOS9.3.1&v=180&type=free%20HTTP/1.1",
                new Response.Listener<AllHeroBean>() {
                    @Override
                    public void onResponse(AllHeroBean response) {
                        allHeroBean = response;
                        heroFreeAdapter.setAllHeroBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, AllHeroBean.class);


        recyclerView.setAdapter(heroFreeAdapter);
        heroFreeAdapter.setmItemClickListener(this);


    }

    @Override
    public void onItemClickListener(View view, int position) {
        String enName = allHeroBean.getFree().get(position).getEnName();

        Intent intent = new Intent(getContext(), HeroDetailsActivity.class);
        Log.d("HeroFreeFragment", enName);
        intent.putExtra("enName", enName);
        // 把id传过去
        startActivity(intent);
    }
}
