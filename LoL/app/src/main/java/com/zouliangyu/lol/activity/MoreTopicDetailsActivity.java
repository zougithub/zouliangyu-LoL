package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.widget.ImageView;
import android.widget.ListView;

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
 */
public class MoreTopicDetailsActivity extends BaseActivity {
    private ListView listView;
    private MoreTopicDetailsAdapter moreTopicDetailsAdapter;
    private MoreTopicDetailsBean moreTopicDetailsBean;
    private ImageView topImage;


    @Override
    protected int getLayout() {
        return R.layout.activity_more_topic_details;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.topic_details_listview);
        topImage = (ImageView) findViewById(R.id.topic_details_image);

    }

    @Override
    protected void initData() {

        moreTopicDetailsAdapter = new MoreTopicDetailsAdapter(this);
        Intent intent = getIntent();
        String ids = intent.getStringExtra("ids");
        String imageUrl = intent.getStringExtra("imageUrl");
        String url = "http://lol.zhangyoubao.com/apis/rest/TopicsService/items?topicid=50&page=1&i_=600BEB19-A58C-436C-9E3C-12E0581B0BEA&t_=1463646958&p_=23219&v_=40080001&d_=ios&osv_=9.3.1&version=0&a_=lol%20HTTP/1.1";
        String urls = "http://lol.zhangyoubao.com/apis/rest/TopicsService/items?topicid=" + ids + "&page=1&i_=600BEB19-A58C-436C-9E3C-12E0581B0BEA&t_=1463646958&p_=23219&v_=40080001&d_=ios&osv_=9.3.1&version=0&a_=lol%20HTTP/1.1";
        VolleySingle.addRequest(urls, new Response.Listener<MoreTopicDetailsBean>() {
            @Override
            public void onResponse(MoreTopicDetailsBean response) {
                moreTopicDetailsBean = response;
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
