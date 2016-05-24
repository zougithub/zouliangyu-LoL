package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
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
 *
 * 社区 找战友
 */
public class CommunityFriendDetailsAty extends BaseActivity {
    private RecyclerView recyclerView;
    private CommunityFriendDetailsAdapter communityFriendDetailsAdapter;
    private TextView titleTv;
    private ImageView leftIv;


    @Override
    protected int getLayout() {
        return R.layout.aty_community_friend_details;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.community_friend_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        titleTv = (TextView) findViewById(R.id.title_tv);
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        leftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {
        leftIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("找战友");
        titleTv.setTextColor(Color.WHITE);

        communityFriendDetailsAdapter = new CommunityFriendDetailsAdapter(this);
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

}
