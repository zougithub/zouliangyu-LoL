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
import com.zouliangyu.lol.adapter.MoreTopicDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreTopicDetailsBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/21.
 * 精彩专栏  详情
 */
public class MoreTopicDetailsActivity extends BaseActivity {
    private PullToRefreshListView pullToRefreshListView;
    private MoreTopicDetailsAdapter moreTopicDetailsAdapter;
    // 最上面图片
    private ImageView topImage;
<<<<<<< HEAD
    // 标题
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private ImageView leftTv;
    private TextView titleTv;

    private MoreTopicDetailsBean moreTopicDetailsBean;
    private String urls;
    private String ids;

    @Override
    protected int getLayout() {
        return R.layout.activity_more_topic_details;
    }

    @Override
    protected void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.topic_details_listview);
        topImage = (ImageView) findViewById(R.id.topic_details_image);
        // 初始化
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
<<<<<<< HEAD
        // 设置上拉下拉事件
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        // 设置标题栏
=======
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        titleTv.setText("精彩专栏");
        titleTv.setTextColor(Color.WHITE);
        leftTv.setImageResource(R.mipmap.global_back_d);

        moreTopicDetailsAdapter = new MoreTopicDetailsAdapter(this);
        Intent intent = getIntent();
        ids = intent.getStringExtra("ids");
<<<<<<< HEAD
        // 设置最上面图片
        String imageUrl = intent.getStringExtra("imageUrl");
        Picasso.with(this).load(imageUrl).placeholder(R.mipmap.photo_default)
                .error(R.mipmap.photo_default).into(topImage);
        urls = "http://lol.zhangyoubao.com/apis/rest/TopicsService/items?topicid=" + ids + "&page=1&i_=600BEB19-A58C-436C-9E3C-12E0581B0BEA&t_=1463646958&p_=23219&v_=40080001&d_=ios&osv_=9.3.1&version=0&a_=lol%20HTTP/1.1";
        // 获取数据
=======
        String imageUrl = intent.getStringExtra("imageUrl");
        urls = "http://lol.zhangyoubao.com/apis/rest/TopicsService/items?topicid=" + ids + "&page=1&i_=600BEB19-A58C-436C-9E3C-12E0581B0BEA&t_=1463646958&p_=23219&v_=40080001&d_=ios&osv_=9.3.1&version=0&a_=lol%20HTTP/1.1";
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        VolleySingle.addRequest(urls, new Response.Listener<MoreTopicDetailsBean>() {
            @Override
            public void onResponse(MoreTopicDetailsBean response) {
                moreTopicDetailsBean = response;
                moreTopicDetailsAdapter.setMoreTopicDetailsBean(moreTopicDetailsBean);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, MoreTopicDetailsBean.class);


<<<<<<< HEAD
        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ids = moreTopicDetailsBean.getData().get(position - 1).getId();
                String title = moreTopicDetailsBean.getData().get(position - 1).getTitle();
                String desc = moreTopicDetailsBean.getData().get(position - 1).getDesc();
                int time = moreTopicDetailsBean.getData().get(position - 1).getPublished();
=======
        Picasso.with(this).load(imageUrl).placeholder(R.mipmap.photo_default).error(R.mipmap.photo_default).into(topImage);


        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String ids = moreTopicDetailsBean.getData().get(position).getId();
                String title = moreTopicDetailsBean.getData().get(position).getTitle();
                String desc = moreTopicDetailsBean.getData().get(position).getDesc();
                int time = moreTopicDetailsBean.getData().get(position).getPublished();
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                Date date = new Date(time);
                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                String times = simpleDateFormat.format(date);

                Intent intent = new Intent(MoreTopicDetailsActivity.this, InformationItemDetailsAty.class);
                intent.putExtra("ids", ids);
                intent.putExtra("title", title);
                intent.putExtra("desc", desc);
                intent.putExtra("times", times);
                startActivity(intent);
            }
        });

        // 上拉加载, 下拉刷新
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                VolleySingle.addRequest(urls, new Response.Listener<MoreTopicDetailsBean>() {
                    @Override
                    public void onResponse(MoreTopicDetailsBean response) {
                        moreTopicDetailsBean = response;
                        moreTopicDetailsAdapter.setMoreTopicDetailsBean(moreTopicDetailsBean);
<<<<<<< HEAD
                        // 刷新成功后停止
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                        pullToRefreshListView.onRefreshComplete();
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, MoreTopicDetailsBean.class);
            }

            // 上拉
            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                VolleySingle.addRequest(urls, new Response.Listener<MoreTopicDetailsBean>() {
                    @Override
                    public void onResponse(MoreTopicDetailsBean response) {
                        moreTopicDetailsBean.getData().addAll(response.getData());
                        moreTopicDetailsAdapter.setMoreTopicDetailsBean(moreTopicDetailsBean);
                        pullToRefreshListView.onRefreshComplete();

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, MoreTopicDetailsBean.class);
            }
        });

        pullToRefreshListView.setAdapter(moreTopicDetailsAdapter);
    }
}
