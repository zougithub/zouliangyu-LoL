package com.zouliangyu.lol.fragment.hero;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.HeroItemDetailsAty;
import com.zouliangyu.lol.adapter.AllHeroAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroBean;

/**
 * Created by zouliangyu on 16/5/10.
 * 所有英雄
 */
public class HeroAllHeroFragment extends BaseFragment implements AllHeroAdapter.MyItemClickListener {
    private RecyclerView allHeroRv;
    private Spinner spinner;
    private AllHeroAdapter allHeroAdapter;
    private AllHeroBean allHeroBean;
    private String enName;

    @Override
    public int initLayout() {
        return R.layout.fragment_hero_all_fragment;
    }

    @Override
    public void initView() {
        spinner = (Spinner) getView().findViewById(R.id.spinner_one);
        allHeroRv = (RecyclerView) getView().findViewById(R.id.all_hero_rv);
        allHeroRv.setLayoutManager(new GridLayoutManager(mContext, 4));

    }

    @Override
    public void initData() {
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


        allHeroAdapter = new AllHeroAdapter(mContext);

        // 获取全部英雄的数据
        VolleySingle.addRequest("http://lolbox.duowan.com/phone/apiHeroes.php?OSType=iOS9.3.1&v=180&type=all%20HTTP/1.1",
                new Response.Listener<AllHeroBean>() {
                    @Override
                    public void onResponse(AllHeroBean response) {
                        allHeroBean = response;
                        allHeroAdapter.setAllHeroBean(allHeroBean);

                        Log.d("654", "allHeroBean:" + allHeroBean.getAll().size());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, AllHeroBean.class);

        allHeroAdapter.setMyItemClickListener(this);


        allHeroRv.setAdapter(allHeroAdapter);

    }


    @Override
    public void onItemClickListener(View view, int position) {
        Intent intent = new Intent(mContext, HeroItemDetailsAty.class);
        enName = allHeroBean.getAll().get(position).getEnName();
        intent.putExtra("enName", enName);
        startActivity(intent);
    }
}
