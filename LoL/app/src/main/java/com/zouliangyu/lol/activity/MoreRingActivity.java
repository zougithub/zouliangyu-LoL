package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
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
import com.zouliangyu.lol.adapter.MoreRingAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreRingBean;

/**
 * Created by zouliangyu on 16/5/20.
 * 铃声
 */
public class MoreRingActivity extends BaseActivity {
    private PullToRefreshListView pullToRefreshListView;
    private MoreRingAdapter moreRingAdapter;
    private MoreRingBean moreRingBean;

    private MediaPlayer mediaPlayer;
    private String url;
    private ImageView leftIv;
    private TextView titleTv;


    @Override
    protected int getLayout() {
        return R.layout.activity_more_ring;
    }

    @Override
    protected void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.ring_listview);
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
        titleTv.setText("铃声");
        titleTv.setTextColor(Color.WHITE);
        leftIv.setImageResource(R.mipmap.global_back_d);


        moreRingAdapter = new MoreRingAdapter(this);
        // 获取数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/AroundService/ring?page=1&i_=869765028748315&t_=1463627310419&p_=3602&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&",
                new Response.Listener<MoreRingBean>() {
                    @Override
                    public void onResponse(MoreRingBean response) {
                        moreRingBean = response;
                        moreRingAdapter.setMoreRingBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, MoreRingBean.class);


        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MoreRingAdapter.ViewHolder holder = (MoreRingAdapter.ViewHolder) view.getTag();

                url = moreRingBean.getData().get(position - 1).getPath_url();
                Log.d("MoreRingActivity", url);
                mediaPlayer = MediaPlayer.create(MoreRingActivity.this, Uri.parse(url));

            }
        });


        // 上拉加载, 下拉刷新
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            // 下拉
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/AroundService/ring?page=1&i_=869765028748315&t_=1463627310419&p_=3602&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&",
                        new Response.Listener<MoreRingBean>() {
                            @Override
                            public void onResponse(MoreRingBean response) {
                                moreRingAdapter.setMoreRingBean(response);
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, MoreRingBean.class);
            }

            @Override
            // 上拉
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {

                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/AroundService/ring?page=2&i_=869765028748315&t_=1463627310419&p_=3602&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&",
                        new Response.Listener<MoreRingBean>() {
                            @Override
                            public void onResponse(MoreRingBean response) {
                                moreRingBean.getData().addAll(response.getData());
                                moreRingAdapter.setMoreRingBean(moreRingBean);
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, MoreRingBean.class);
            }
        });

        pullToRefreshListView.setAdapter(moreRingAdapter);
    }
}
