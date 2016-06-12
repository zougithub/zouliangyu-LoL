package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.CommunityFriendDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.CommunityFriendBean;

/**
 * Created by zouliangyu on 16/5/21.
 * 社区 找战友
 */
public class CommunityFriendDetailsAty extends BaseActivity implements View.OnClickListener {
    private RecyclerView recyclerView;
    private CommunityFriendDetailsAdapter communityFriendDetailsAdapter;
    // 标题
    private TextView titleTv;
    private ImageView leftIv;
    private Button find;
<<<<<<< HEAD
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068

    @Override
    protected int getLayout() {
        return R.layout.aty_community_friend_details;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.community_friend_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        // 初始化标题栏
        titleTv = (TextView) findViewById(R.id.title_tv);
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        leftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        find = (Button) findViewById(R.id.find);
        find.setOnClickListener(this);
<<<<<<< HEAD
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    }

    @Override
    protected void initData() {
        // 设置标题栏
        leftIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("找战友");
        titleTv.setTextColor(Color.WHITE);

        communityFriendDetailsAdapter = new CommunityFriendDetailsAdapter(this);
        // 获取网络数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getCompanions?i_=869765028748315&t_=1463625658335&p_=27350&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<CommunityFriendBean>() {
                    @Override
                    public void onResponse(CommunityFriendBean response) {
                        communityFriendDetailsAdapter.setCommunityFriendBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, CommunityFriendBean.class);
        recyclerView.setAdapter(communityFriendDetailsAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            // 点击 按钮 重新获取数据
            case R.id.find:
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getCompanions?i_=869765028748315&t_=1463625658335&p_=27350&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityFriendBean>() {
                            @Override
                            public void onResponse(CommunityFriendBean response) {
                                communityFriendDetailsAdapter.setCommunityFriendBean(response);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityFriendBean.class);
                break;
        }
    }
}
