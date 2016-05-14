package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.view.View;
import android.widget.ListView;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.VideoPlayNewestDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.GsonRequest;
import com.zouliangyu.lol.bean.VideoPlayNewestDetailsBean;

/**
 * Created by zouliangyu on 16/5/14.
 */
public class VideoDetailsAty extends BaseActivity {

    private ListView listView;
    private VideoPlayNewestDetailsAdapter videoPlayNewestDetailsAdapter;

    @Override
    protected int getLayout() {
        return R.layout.aty_video_details;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.video_details_lv);

    }

    @Override
    protected void initData() {

        View headerView = getLayoutInflater().inflate(R.layout.video_details_header, null);
        listView.addHeaderView(headerView);


        Intent intent = getIntent();
        String ids = intent.getStringExtra("ids");
        String url = "http://lol.zhangyoubao.com/apis/rest/ItemsService/videos?catwordid=" + ids + "&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438760575&p_=4070&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol";


        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        GsonRequest<VideoPlayNewestDetailsBean> gsonRequest = new GsonRequest<>(Request.Method.GET, url
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<VideoPlayNewestDetailsBean>() {
            @Override
            public void onResponse(VideoPlayNewestDetailsBean response) {
                videoPlayNewestDetailsAdapter.setVideoPlayNewestDetailsBeans(response);
            }
        }, VideoPlayNewestDetailsBean.class);

        requestQueue.add(gsonRequest);


        videoPlayNewestDetailsAdapter = new VideoPlayNewestDetailsAdapter(this);
        listView.setAdapter(videoPlayNewestDetailsAdapter);


    }
}
