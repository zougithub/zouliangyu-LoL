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
import com.zouliangyu.lol.adapter.MoreNovelDetailsItemDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreNovelItemDetailsBean;

import java.text.SimpleDateFormat;
import java.util.Date;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/20.
 * 更多 小说 详情 item界面
 */
public class MoreNovelDetailsItemDetailsAty extends BaseActivity {
    private PullToRefreshListView pullToRefreshListView;
    private MoreNovelDetailsItemDetailsAdapter moreNovelDetailsItemDetailsAdapter;

    // 标题栏
    private ImageView exitIv;
    private TextView title;
    // 小说简介
    private ImageView imageView;
    private TextView nameTv;
    private TextView descTv;

    private MoreNovelItemDetailsBean moreNovelItemDetailsBean;
    private String ids;
    int i = 1;

    @Override
    protected int getLayout() {
        return R.layout.aty_more_novel_details_item_details;
    }

    @Override
    protected void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.novel_details_item_details_listview);
        // 设置上拉下拉事件
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        title = (TextView) findViewById(R.id.title_tv);
<<<<<<< HEAD
        // 小说介绍
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        imageView = (ImageView) findViewById(R.id.novel_item_iv);
        nameTv = (TextView) findViewById(R.id.novel_item_title);
        descTv = (TextView) findViewById(R.id.novel_item_desc);
        exitIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        ids = intent.getStringExtra("ids");
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        String imageUrl = intent.getStringExtra("imageUrl");
<<<<<<< HEAD
        // 设置标题
        title.setText(name);
        title.setTextColor(Color.WHITE);
        exitIv.setImageResource(R.mipmap.global_back_d);
        // 小说介绍
=======

        title.setText(name);
        title.setTextColor(Color.WHITE);
        exitIv.setImageResource(R.mipmap.global_back_d);

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        Picasso.with(this).load(imageUrl).placeholder(R.mipmap.photo_default).error(R.mipmap.photo_default)
                .into(imageView);
        nameTv.setText(name);
        descTv.setText(desc);
<<<<<<< HEAD
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068

        moreNovelDetailsItemDetailsAdapter = new MoreNovelDetailsItemDetailsAdapter(this);
        // 获取数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/ItemsService/novels?catid=10195&catwordid=" + ids + "&page=1&i_=869765028748315&t_=1463627448626&p_=28223&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<MoreNovelItemDetailsBean>() {
                    @Override
                    public void onResponse(MoreNovelItemDetailsBean response) {
                        moreNovelItemDetailsBean = response;
                        moreNovelDetailsItemDetailsAdapter.setMoreNovelItemDetailsBean(moreNovelItemDetailsBean);
                        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(MoreNovelDetailsItemDetailsAty.this, InformationItemDetailsAty.class);
                                String ids = moreNovelItemDetailsBean.getData().get(position - 1).getItem_id();
                                String title = moreNovelItemDetailsBean.getData().get(position - 1).getTitle();
                                String desc = moreNovelItemDetailsBean.getData().get(position - 1).getDesc();
                                int time = moreNovelItemDetailsBean.getData().get(position - 1).getPublished();
                                Date date = new Date(time);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                                String times = simpleDateFormat.format(date);
                                intent.putExtra("ids", ids);
                                intent.putExtra("title", title);
                                intent.putExtra("desc", desc);
                                intent.putExtra("times", times);
                                startActivity(intent);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, MoreNovelItemDetailsBean.class);

<<<<<<< HEAD
=======
        // 获取数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/ItemsService/novels?catid=10195&catwordid=" + ids + "&page=1&i_=869765028748315&t_=1463627448626&p_=28223&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<MoreNovelItemDetailsBean>() {
                    @Override
                    public void onResponse(MoreNovelItemDetailsBean response) {
                        moreNovelItemDetailsBean = response;
                        moreNovelDetailsItemDetailsAdapter.setMoreNovelItemDetailsBean(moreNovelItemDetailsBean);
                        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(MoreNovelDetailsItemDetailsAty.this, InformationItemDetailsAty.class);
                                String ids = moreNovelItemDetailsBean.getData().get(position - 1).getItem_id();
                                String title = moreNovelItemDetailsBean.getData().get(position - 1).getTitle();
                                String desc = moreNovelItemDetailsBean.getData().get(position - 1).getDesc();
                                int time = moreNovelItemDetailsBean.getData().get(position - 1).getPublished();
                                Date date = new Date(time);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                                String times = simpleDateFormat.format(date);
                                intent.putExtra("ids", ids);
                                intent.putExtra("title", title);
                                intent.putExtra("desc", desc);
                                intent.putExtra("times", times);
                                startActivity(intent);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, MoreNovelItemDetailsBean.class);

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068

        // 上拉加载, 下拉刷新
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            // 下拉
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {

                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/ItemsService/novels?catid=10195&catwordid=" + ids + "&page=1&i_=869765028748315&t_=1463627448626&p_=28223&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<MoreNovelItemDetailsBean>() {
                            @Override
                            public void onResponse(MoreNovelItemDetailsBean response) {
                                moreNovelItemDetailsBean = response;
                                moreNovelDetailsItemDetailsAdapter.setMoreNovelItemDetailsBean(moreNovelItemDetailsBean);
<<<<<<< HEAD
                                // 下拉完成 , 调用此方法, 停止刷新
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                                pullToRefreshListView.onRefreshComplete();

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, MoreNovelItemDetailsBean.class);
            }

            @Override
            // 上拉
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                i++;
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/ItemsService/novels?catid=10195&catwordid=" + ids + "&page=" + i + "&i_=869765028748315&t_=1463627448626&p_=28223&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<MoreNovelItemDetailsBean>() {
                            @Override
                            public void onResponse(MoreNovelItemDetailsBean response) {
                                moreNovelItemDetailsBean.getData().addAll(response.getData());
                                moreNovelDetailsItemDetailsAdapter.setMoreNovelItemDetailsBean(moreNovelItemDetailsBean);
                                // 上拉完成,调用此方法,停止刷新
                                pullToRefreshListView.onRefreshComplete();

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, MoreNovelItemDetailsBean.class);
            }
        });

        pullToRefreshListView.setAdapter(moreNovelDetailsItemDetailsAdapter);


    }
}
