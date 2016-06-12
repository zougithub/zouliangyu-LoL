package com.zouliangyu.lol.fragment.hero;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.HeroDetailsActivity;
import com.zouliangyu.lol.adapter.HeroFreeAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroBean;
import com.zouliangyu.lol.bean.FreeHeroTimeBean;

/**
 * Created by zouliangyu on 16/5/16.
 * 英雄  周免界面
 */
public class HeroFreeFragment extends BaseFragment implements HeroFreeAdapter.MyItemClickListener {
    private RecyclerView recyclerView;
    private HeroFreeAdapter heroFreeAdapter;
    private AllHeroBean allHeroBean;

    private TextView free; // 本期周免
    private TextView freeTime; // 周免时间
    private String url;

    @Override
    public int initLayout() {
        return R.layout.fragment_hero_free;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.free_rv);
        recyclerView.setLayoutManager(new GridLayoutManager(mContext, 3));
        free = (TextView) getView().findViewById(R.id.free_one);
        freeTime = (TextView) getView().findViewById(R.id.free_time);

    }

    @Override
    public void initData() {

        // 获取本期周免及周免时间
        url = "http://lol.zhangyoubao.com/apis/rest/RolesService/freeV1?&i_=600BEB19-A58C-436C-9E3C-12E0581B0BEA&t_=1464849381&p_=30488&v_=40080001&d_=ios&osv_=9.3.1&version=0&userid=23437717&token=667d6fe0a62014eec537e4b96e8bfca0760&a_=lol&u_=23437717";
        VolleySingle.addRequest(url,
                new Response.Listener<FreeHeroTimeBean>() {
                    @Override
                    public void onResponse(FreeHeroTimeBean response) {
                        free.setText(response.getData().getCurrenttitle());
                        freeTime.setText(response.getData().getCurrentdate());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, FreeHeroTimeBean.class);

        heroFreeAdapter = new HeroFreeAdapter(mContext);
        // 获取免费英雄的数据
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
        heroFreeAdapter.setMyItemClickListener(this);


    }


    @Override
    public void onItemClickListener(int position) {
        String enName = allHeroBean.getFree().get(position).getEnName();

        Intent intent = new Intent(getContext(), HeroDetailsActivity.class);
        intent.putExtra("enName", enName);
        startActivity(intent);
    }
}
