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
import com.zouliangyu.lol.adapter.MoreTopicAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreTopicBean;

/**
 * Created by zouliangyu on 16/5/20.
 * 更多 精彩专栏
 */
public class MoreTopicActivity extends BaseActivity {
    private PullToRefreshListView pullToRefreshListView;
    private MoreTopicAdapter moreTopicAdapter;
    private MoreTopicBean moreTopicBean;

    // 标题栏
    private ImageView leftIv;
    private TextView titleTv;

    int i = 1;

    @Override
    protected int getLayout() {
        return R.layout.activity_more_topic;
    }

    @Override
    protected void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.more_topic_listview);
        // 设置上拉下拉事件
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        leftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }


    @Override
    protected void initData() {

        titleTv.setText("专栏列表");
        titleTv.setTextColor(Color.WHITE);
        leftIv.setImageResource(R.mipmap.global_back_d);

        moreTopicAdapter = new MoreTopicAdapter(this);

        // 获取 数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/TopicsService/all?page=1&i_=869765028748315&t_=1463627159120&p_=29705&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<MoreTopicBean>() {
                    @Override
                    public void onResponse(MoreTopicBean response) {
                        moreTopicBean = response;
                        moreTopicAdapter.setMoreTopicBean(moreTopicBean);

                        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                Intent intent = new Intent(MoreTopicActivity.this, MoreTopicDetailsActivity.class);
                                String ids = moreTopicBean.getData().get(position - 1).getId();
                                String imageUrl = moreTopicBean.getData().get(position - 1).getPic_url();
                                intent.putExtra("imageUrl", imageUrl);
                                intent.putExtra("ids", ids);
                                startActivity(intent);
                            }
                        });
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, MoreTopicBean.class);


        // 下拉刷新, 上拉加载
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/TopicsService/all?page=1&i_=869765028748315&t_=1463627159120&p_=29705&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<MoreTopicBean>() {
                            @Override
                            public void onResponse(MoreTopicBean response) {
                                moreTopicAdapter.setMoreTopicBean(response);
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        }, MoreTopicBean.class);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                i++;
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/TopicsService/all?page=" + i + "&i_=869765028748315&t_=1463627159120&p_=29705&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<MoreTopicBean>() {
                            @Override
                            public void onResponse(MoreTopicBean response) {
                                moreTopicBean.getData().addAll(response.getData());
                                moreTopicAdapter.setMoreTopicBean(moreTopicBean);
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {
                            }
                        }, MoreTopicBean.class);

            }
        });
        pullToRefreshListView.setAdapter(moreTopicAdapter);


    }
}
