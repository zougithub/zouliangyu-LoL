package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.VideoPlayAdapter;
import com.zouliangyu.lol.adapter.VideoPlayNewestDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.GsonRequest;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.VideoBean;
import com.zouliangyu.lol.bean.VideoPlayNewestDetailsBean;
import com.zouliangyu.lol.fragment.video.VideoFragment;
import com.zouliangyu.lol.fragment.video.VideoPlayFragment;

import org.w3c.dom.Text;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/14.
 * 视频的Item详情页
 */
public class VideoDetailsAty extends BaseActivity {
    private TextView titleTv;
    private ImageView exitIv;

    private PullToRefreshListView pullToRefreshListView;
    private VideoPlayNewestDetailsAdapter videoPlayNewestDetailsAdapter;

    private ImageView imageView;
    private TextView nameTv;
    private TextView descTv;

    private int position;
    private int pos;

    private VideoPlayNewestDetailsBean videoPlayNewestDetailsBean = new VideoPlayNewestDetailsBean();
    private String url;
    private String ids;
    int i = 1;


    @Override
    protected int getLayout() {
        return R.layout.aty_video_details;
    }

    @Override
    protected void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.video_details_lv);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        titleTv = (TextView) findViewById(R.id.title_tv);
        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        exitIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void initData() {

        imageView = (ImageView) findViewById(R.id.video_item_details_iv);
        nameTv = (TextView) findViewById(R.id.video_item_details_name);
        descTv = (TextView) findViewById(R.id.video_item_details_desc);


        Intent intent = getIntent();

        ids = intent.getStringExtra("ids");
        pos = intent.getIntExtra("pos", pos);
        position = intent.getIntExtra("position", position);
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        String img = intent.getStringExtra("img");

        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText(name);
        titleTv.setTextColor(Color.WHITE);

        Picasso.with(this).load(img).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(imageView);
        nameTv.setText(name);
        descTv.setText(desc);


        url = "http://lol.zhangyoubao.com/apis/rest/ItemsService/videos?catwordid=" + ids + "&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438760575&p_=4070&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol";


        videoPlayNewestDetailsAdapter = new VideoPlayNewestDetailsAdapter(this);


        // 视频详情页, 获取listview数据
        VolleySingle.addRequest(url, new Response.Listener<VideoPlayNewestDetailsBean>() {
            @Override
            public void onResponse(VideoPlayNewestDetailsBean response) {

                videoPlayNewestDetailsBean = response;
                videoPlayNewestDetailsAdapter.setVideoPlayNewestDetailsBeans(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, VideoPlayNewestDetailsBean.class);


        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                VolleySingle.addRequest(url, new Response.Listener<VideoPlayNewestDetailsBean>() {
                    @Override
                    public void onResponse(VideoPlayNewestDetailsBean response) {
                        videoPlayNewestDetailsAdapter.setVideoPlayNewestDetailsBeans(response);
                        pullToRefreshListView.onRefreshComplete();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, VideoPlayNewestDetailsBean.class);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                i++;
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/ItemsService/videos?catwordid=" + ids + "&page=" + i + "&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438760575&p_=4070&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol",
                        new Response.Listener<VideoPlayNewestDetailsBean>() {
                            @Override
                            public void onResponse(VideoPlayNewestDetailsBean response) {
                                videoPlayNewestDetailsBean.getData().addAll(response.getData());
                                videoPlayNewestDetailsAdapter.setVideoPlayNewestDetailsBeans(videoPlayNewestDetailsBean);
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, VideoPlayNewestDetailsBean.class);
            }
        });

        pullToRefreshListView.setAdapter(videoPlayNewestDetailsAdapter);

        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(VideoDetailsAty.this, VideoDetailsItemDetailsAty.class);
                Log.d("VideoDetailsAty", videoPlayNewestDetailsBean.getData().get(position - 1).getTitle());
                String ids = videoPlayNewestDetailsBean.getData().get(position - 1).getItem_id();
                String titles = videoPlayNewestDetailsBean.getData().get(position - 1).getTitle();
                String desc = videoPlayNewestDetailsBean.getData().get(position- 1).getDesc();
                int time = videoPlayNewestDetailsBean.getData().get(position - 1).getPublished();
                Date date = new Date(time);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                String times = simpleDateFormat.format(date);


                intent.putExtra("ids", ids);
                intent.putExtra("titles", titles);
                intent.putExtra("desc", desc);
                intent.putExtra("times", times);
                startActivity(intent);
                Log.d("VideoDetailsAty", ids);
            }
        });

    }


}
