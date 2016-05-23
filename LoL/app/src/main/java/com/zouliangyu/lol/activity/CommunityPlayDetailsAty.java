package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.CommunityPlayDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.CommunityPlayBean;

/**
 * Created by zouliangyu on 16/5/16.
 * <p>
 * 社区 晒玩法 详情
 */
public class CommunityPlayDetailsAty extends BaseActivity implements View.OnClickListener {
    private ListView listView;
    private CommunityPlayDetailsAdapter communityPlayDetailsAdapter;
    private LinearLayout publish;

    private TextView titleTv;
    private ImageView leftIv;


    @Override
    protected int getLayout() {
        return R.layout.aty_community_play_details;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.community_play_details_lv);
        publish = (LinearLayout) findViewById(R.id.show_publish_play);
        publish.setOnClickListener(this);

        titleTv = (TextView) findViewById(R.id.title_tv);
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        leftIv.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        titleTv.setText("晒玩法");
        titleTv.setTextColor(Color.WHITE);
        leftIv.setImageResource(R.mipmap.global_back_d);


        communityPlayDetailsAdapter = new CommunityPlayDetailsAdapter(this);
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/PlaysService/userPlayList?order_kind=0&role_id=0&season=8&page=1&i_=869765028748315&t_=1463625582052&p_=8501&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<CommunityPlayBean>() {
                    @Override
                    public void onResponse(CommunityPlayBean response) {
                        communityPlayDetailsAdapter.setCommunityPlayBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, CommunityPlayBean.class);

        listView.setAdapter(communityPlayDetailsAdapter);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.show_publish_play:
                Intent intent = new Intent(CommunityPlayDetailsAty.this, WelcomeActivity.class);
                startActivity(intent);
                break;
            case R.id.title_left_iv:
                finish();
                break;
        }
    }
}
