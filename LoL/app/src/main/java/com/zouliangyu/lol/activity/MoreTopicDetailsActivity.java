package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.MoreTopicDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreTopicDetailsBean;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/21.
 * 精彩专栏  详情
 */
public class MoreTopicDetailsActivity extends BaseActivity {
    private ListView listView;
    private MoreTopicDetailsAdapter moreTopicDetailsAdapter;
    private ImageView topImage;
    private ImageView leftTv;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_more_topic_details;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.topic_details_listview);
        topImage = (ImageView) findViewById(R.id.topic_details_image);
        leftTv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        leftTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {
        titleTv.setText("精彩专栏");
        titleTv.setTextColor(Color.WHITE);
        leftTv.setImageResource(R.mipmap.global_back_d);

        moreTopicDetailsAdapter = new MoreTopicDetailsAdapter(this);
        Intent intent = getIntent();
        String ids = intent.getStringExtra("ids");
        String imageUrl = intent.getStringExtra("imageUrl");
        String urls = "http://lol.zhangyoubao.com/apis/rest/TopicsService/items?topicid=" + ids + "&page=1&i_=600BEB19-A58C-436C-9E3C-12E0581B0BEA&t_=1463646958&p_=23219&v_=40080001&d_=ios&osv_=9.3.1&version=0&a_=lol%20HTTP/1.1";
        VolleySingle.addRequest(urls, new Response.Listener<MoreTopicDetailsBean>() {
            @Override
            public void onResponse(MoreTopicDetailsBean response) {
                moreTopicDetailsAdapter.setMoreTopicDetailsBean(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, MoreTopicDetailsBean.class);

        Picasso.with(this).load(imageUrl).into(topImage);
        listView.setAdapter(moreTopicDetailsAdapter);

    }
}
