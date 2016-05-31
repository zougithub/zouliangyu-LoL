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
import com.zouliangyu.lol.adapter.AllHeroAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroBean;
import com.zouliangyu.lol.bean.AllHeroTypeBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouliangyu on 16/5/10.
 * 所有英雄
 */
public class HeroAllHeroFragment extends BaseFragment implements AllHeroAdapter.MyItemClickListener {
    private RecyclerView allHeroRv;
    private Spinner spinnerOne;
    private Spinner spinnerTwo;
    private AllHeroAdapter allHeroAdapter;

    private AllHeroBean allHeroBean;
    private List<AllHeroBean.AllBean> allBeans;


    @Override
    public int initLayout() {
        return R.layout.fragment_hero_all_fragment;
    }

    @Override
    public void initView() {
        spinnerOne = (Spinner) getView().findViewById(R.id.spinner_one);
        spinnerTwo = (Spinner) getView().findViewById(R.id.spinner_two);

        allHeroRv = (RecyclerView) getView().findViewById(R.id.all_hero_rv);
        allHeroRv.setLayoutManager(new GridLayoutManager(mContext, 3));

    }

    @Override
    public void initData() {


        allHeroAdapter = new AllHeroAdapter(mContext);


        // 获取全部英雄的数据
        VolleySingle.addRequest("http://lolbox.duowan.com/phone/apiHeroes.php?OSType=iOS9.3.1&v=180&type=all%20HTTP/1.1",
                new Response.Listener<AllHeroBean>() {
                    @Override
                    public void onResponse(AllHeroBean response) {
                        allHeroBean = response;
                        // 遍历所有英雄,
                        for (AllHeroBean.AllBean allBean : allHeroBean.getAll()) {
                            allBeans.add(allBean);
                        }

                        allHeroAdapter.setAllBeans(allBeans);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, AllHeroBean.class);

        spinner();


        allHeroAdapter.setMyItemClickListener(this);
        allHeroRv.setAdapter(allHeroAdapter);


    }


    private void spinner() {
//        String[] mItemsOne = getResources().getStringArray(R.array.types);
        final String[] mItemsOne = {"位置", "中单", "ADC", "上单", "打野", "辅助"};  // 建立数据源

        //  建立Adapter并且绑定数据源,  第二个参数是Spinner未展开菜单时Spinner的默认样式
        // android.R.layout.simple_spinner_item是系统自带的内置布局。
        ArrayAdapter<String> adapterOne = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, mItemsOne);

        // 设置的是展开的时候下拉菜单的样式（注意和上面区别）
        // 同理android.R.layout.simple_spinner_dropdown_item也是内置布局。
        adapterOne.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerOne.setAdapter(adapterOne);

        spinnerOne.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String type = spinnerOne.getSelectedItem().toString(); // Spinner点击哪个,type就是哪个item
                allBeans = new ArrayList<>(); // 满足条件的一个英雄的数据的集合
                // 获取全部英雄的数据
                VolleySingle.addRequest("http://lolbox.duowan.com/phone/apiHeroes.php?OSType=iOS9.3.1&v=180&type=all%20HTTP/1.1",
                        new Response.Listener<AllHeroBean>() {
                            @Override
                            public void onResponse(AllHeroBean response) {
                                allHeroBean = response;
                                // allHeroBean.getAll() 是所有英雄的数据的集合
                                // 遍历所有英雄, 满足的英雄加入集合
                                for (AllHeroBean.AllBean allBean : allHeroBean.getAll()) {
                                    if (type.equals("位置")) {
                                        allBeans.add(allBean);
                                    } else if (allBean.getLocation().toString().equals(type)) {
                                        allBeans.add(allBean);
                                    }
                                }
                                allHeroAdapter.setAllBeans(allBeans);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        }, AllHeroBean.class);
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {
            }
        });


//        String[] mItemsTwo = getResources().getStringArray(R.array.price);
        String[] mItemsTwo = {"价格", "7800", "6300", "4800", "3150", "1350", "450,"}; // 建立数据源
        //  建立Adapter并且绑定数据源,  第二个参数是Spinner未展开菜单时Spinner的默认样式
        // android.R.layout.simple_spinner_item是系统自带的内置布局。
        ArrayAdapter<String> adapterTwo = new ArrayAdapter<>(mContext, android.R.layout.simple_spinner_item, mItemsTwo);

        // 设置的是展开的时候下拉菜单的样式（注意和上面区别）
        // 同理android.R.layout.simple_spinner_dropdown_item也是内置布局。
        adapterTwo.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinnerTwo.setAdapter(adapterTwo);
        spinnerTwo.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                final String type = spinnerTwo.getSelectedItem().toString(); // Spinner点击哪个,type就是哪个item

                allBeans = new ArrayList<>(); // 满足条件的一个英雄的数据的集合
                // 获取全部英雄的数据
                VolleySingle.addRequest("http://lolbox.duowan.com/phone/apiHeroes.php?OSType=iOS9.3.1&v=180&type=all%20HTTP/1.1",
                        new Response.Listener<AllHeroBean>() {
                            @Override
                            public void onResponse(AllHeroBean response) {
                                allHeroBean = response;
                                // allHeroBean.getAll() 是所有英雄的数据的集合
                                for (AllHeroBean.AllBean allBean : allHeroBean.getAll()) {
                                    if (type.equals("价格")) {
                                        allBeans.add(allBean);
                                    } else if (allBean.getPrice().substring(0, 4).toString().equals(type)) {
                                        allBeans.add(allBean);
                                    }
                                }
                                allHeroAdapter.setAllBeans(allBeans);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        }, AllHeroBean.class);


            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }


    // 跳转详情
    @Override
    public void onItemClickListener(int position) {
        Intent intent = new Intent(mContext, HeroDetailsActivity.class);
        String enName = allBeans.get(position).getEnName();
        intent.putExtra("enName", enName);
        startActivity(intent);
    }
}
