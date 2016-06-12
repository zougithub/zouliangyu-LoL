package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.CommunityPlayDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.CommunityPlayBean;

/**
 * Created by zouliangyu on 16/5/16.
 * 社区 晒玩法 详情
 */
public class CommunityPlayDetailsAty extends BaseActivity {
    private PullToRefreshListView pullToRefreshListView;
    private CommunityPlayDetailsAdapter communityPlayDetailsAdapter;
<<<<<<< HEAD
    // 标题
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private TextView titleTv;
    private ImageView leftIv;
    // 拼接网址, 加载
    int i = 1;
    private CommunityPlayBean communityPlayBean;

    @Override
    protected int getLayout() {
        return R.layout.aty_community_play_details;
    }

    @Override
    protected void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.community_play_details_lv);
        // 设置上拉下拉事件
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);
<<<<<<< HEAD
        // 初始化标题
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
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
        // 设置标题栏
        titleTv.setText("晒玩法");
        titleTv.setTextColor(Color.WHITE);
        leftIv.setImageResource(R.mipmap.global_back_d);


        communityPlayDetailsAdapter = new CommunityPlayDetailsAdapter(this);
        // 获取数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/PlaysService/userPlayList?order_kind=0&role_id=0&season=8&page=1&i_=869765028748315&t_=1463625582052&p_=8501&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<CommunityPlayBean>() {
                    @Override
                    public void onResponse(CommunityPlayBean response) {
                        communityPlayBean = response;
                        communityPlayDetailsAdapter.setCommunityPlayBean(communityPlayBean);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, CommunityPlayBean.class);

        // 上拉加载, 下拉刷新
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            // 下拉
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/PlaysService/userPlayList?order_kind=0&role_id=0&season=8&page=1&i_=869765028748315&t_=1463625582052&p_=8501&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityPlayBean>() {
                            @Override
                            public void onResponse(CommunityPlayBean response) {
                                communityPlayDetailsAdapter.setCommunityPlayBean(response);
                                // 上拉完成, 停止加载
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityPlayBean.class);
            }

            @Override
            // 上拉
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                i++;
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/PlaysService/userPlayList?order_kind=0&role_id=0&season=8&page=" + i + "&i_=869765028748315&t_=1463625582052&p_=8501&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityPlayBean>() {
                            @Override
                            public void onResponse(CommunityPlayBean response) {
                                communityPlayBean.getData().addAll(response.getData());
                                communityPlayDetailsAdapter.setCommunityPlayBean(communityPlayBean);
                                // 停止加载
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityPlayBean.class);
            }
        });

        pullToRefreshListView.setAdapter(communityPlayDetailsAdapter);

    }

}
