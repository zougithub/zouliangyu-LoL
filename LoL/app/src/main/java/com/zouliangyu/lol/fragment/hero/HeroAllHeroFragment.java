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
import com.zouliangyu.lol.activity.HeroDetailsActivity;
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
    private Spinner spinnerOne;
    private Spinner spinnerTwo;
    private Spinner spinnerThree;
    private AllHeroAdapter allHeroAdapter;

    private AllHeroBean allHeroBean;


    @Override
    public int initLayout() {
        return R.layout.fragment_hero_all_fragment;
    }

    @Override
    public void initView() {
        spinnerOne = (Spinner) getView().findViewById(R.id.spinner_one);
        spinnerTwo = (Spinner) getView().findViewById(R.id.spinner_two);
        spinnerThree = (Spinner) getView().findViewById(R.id.spinner_three);
        allHeroRv = (RecyclerView) getView().findViewById(R.id.all_hero_rv);
        allHeroRv.setLayoutManager(new GridLayoutManager(mContext, 4));

    }

    @Override
    public void initData() {

        spinner();


        allHeroAdapter = new AllHeroAdapter(mContext);

        // 获取全部英雄的数据
        VolleySingle.addRequest("http://lolbox.duowan.com/phone/apiHeroes.php?OSType=iOS9.3.1&v=180&type=all%20HTTP/1.1",
                new Response.Listener<AllHeroBean>() {
                    @Override
                    public void onResponse(AllHeroBean response) {
                        allHeroBean = response;
                        allHeroAdapter.setAllHeroBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, AllHeroBean.class);


        allHeroAdapter.setMyItemClickListener(this);


        allHeroRv.setAdapter(allHeroAdapter);

    }


    private void spinner() {
        String[] mItemsOne = getResources().getStringArray(R.array.types);
        ArrayAdapter<String> adapterOne = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, mItemsOne);
        adapterOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOne.setAdapter(adapterOne);
        spinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String[] types = getResources().getStringArray(R.array.types);

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });

        String[] mItemsTwo = getResources().getStringArray(R.array.price);
        ArrayAdapter<String> adapterTwo = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mItemsTwo);
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTwo.setAdapter(adapterTwo);
        spinnerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

        String[] mItemsThree = getResources().getStringArray(R.array.newest_publish);
        ArrayAdapter<String> adapterThree = new ArrayAdapter<String>(mContext, android.R.layout.simple_spinner_item, mItemsThree);
        adapterThree.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerThree.setAdapter(adapterThree);
        spinnerThree.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });
    }


    @Override
    public void onItemClickListener(View view, int position) {
        Intent intent = new Intent(mContext, HeroDetailsActivity.class);
        String enName = allHeroBean.getAll().get(position + 1).getEnName();
        intent.putExtra("enName", enName);
        startActivity(intent);
    }
}
