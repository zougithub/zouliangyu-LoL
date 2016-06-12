package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.VideoPlayNewestDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.VideoPlayNewestDetailsBean;
import java.text.SimpleDateFormat;
import java.util.Date;
import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/14.
 * 视频的Item详情页
 */
public class VideoDetailsAty extends BaseActivity {
<<<<<<< HEAD
    // 标题
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private TextView titleTv;
    private ImageView exitIv;

    private PullToRefreshListView pullToRefreshListView;
    private VideoPlayNewestDetailsAdapter videoPlayNewestDetailsAdapter;
    // 上部分
    private ImageView imageView;
    private TextView nameTv;
    private TextView descTv;

//    private int position;
//    private int pos;

    private VideoPlayNewestDetailsBean videoPlayNewestDetailsBean = new VideoPlayNewestDetailsBean();
    private String url; // 拼接的网址
    private String ids; // 拼接网址
    int i = 1; // 加载

    @Override
    protected int getLayout() {
        return R.layout.aty_video_details;
    }

    // 初始化
    @Override
    protected void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.video_details_lv);
        // 设置上拉下拉事件
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        // 标题
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
//        pos = intent.getIntExtra("pos", pos);
//        position = intent.getIntExtra("position", position);
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        String img = intent.getStringExtra("img");
        // 设置标题
        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText(name);
        titleTv.setTextColor(Color.WHITE);
<<<<<<< HEAD
        // 介绍
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        Picasso.with(this).load(img).error(R.mipmap.photo_default).placeholder(R.mipmap.photo_default).into(imageView);
        nameTv.setText(name);
        descTv.setText(desc);

        url = "http://lol.zhangyoubao.com/apis/rest/ItemsService/videos?catwordid=" + ids + "&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438760575&p_=4070&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol";
        videoPlayNewestDetailsAdapter = new VideoPlayNewestDetailsAdapter(this);


        // 视频详情页, 获取listview数据
        VolleySingle.addRequest(url, new Response.Listener<VideoPlayNewestDetailsBean>() {
            @Override
            public void onResponse(VideoPlayNewestDetailsBean response) {

                videoPlayNewestDetailsBean = response;
                videoPlayNewestDetailsAdapter.setVideoPlayNewestDetailsBeans(videoPlayNewestDetailsBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, VideoPlayNewestDetailsBean.class);


        // 上拉加载, 下拉刷新
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                VolleySingle.addRequest(url, new Response.Listener<VideoPlayNewestDetailsBean>() {
                    @Override
                    public void onResponse(VideoPlayNewestDetailsBean response) {
                        videoPlayNewestDetailsAdapter.setVideoPlayNewestDetailsBeans(response);
                        // 下拉完成停止刷新
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
                                // 上拉完成停止刷新
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
                String ids = videoPlayNewestDetailsBean.getData().get(position - 1).getItem_id();
                String titles = videoPlayNewestDetailsBean.getData().get(position - 1).getTitle();
                String desc = videoPlayNewestDetailsBean.getData().get(position - 1).getDesc();
                int time = videoPlayNewestDetailsBean.getData().get(position - 1).getPublished();
                // 把时间转化成我们能看懂的
                Date date = new Date(time);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                String times = simpleDateFormat.format(date);

<<<<<<< HEAD

                String videoUrl = videoPlayNewestDetailsBean.getData().get(position - 1).getVideo_url();
                intent.putExtra("videoUrl", videoUrl);
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                intent.putExtra("ids", ids);
                intent.putExtra("titles", titles);
                intent.putExtra("desc", desc);
                intent.putExtra("times", times);
                startActivity(intent);

            }
        });

    }


}
