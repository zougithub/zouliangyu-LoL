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
    private ListView listView;
    private MoreTopicAdapter moreTopicAdapter;
    private MoreTopicBean moreTopicBean;
    private ImageView leftIv;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_more_topic;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.more_topic_listview);
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
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/TopicsService/all?page=1&i_=869765028748315&t_=1463627159120&p_=29705&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<MoreTopicBean>() {
                    @Override
                    public void onResponse(MoreTopicBean response) {
                        moreTopicBean = response;
                        moreTopicAdapter.setMoreTopicBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, MoreTopicBean.class);
        listView.setAdapter(moreTopicAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MoreTopicActivity.this, MoreTopicDetailsActivity.class);
                String ids = moreTopicBean.getData().get(position).getId();
                String imageUrl = moreTopicBean.getData().get(position).getPic_url();
                intent.putExtra("imageUrl", imageUrl);
                intent.putExtra("ids", ids);
                startActivity(intent);
            }
        });

    }
}
