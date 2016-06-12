package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.MoreImageAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreImageBean;

import java.lang.reflect.Method;

/**
 * Created by zouliangyu on 16/5/19.
 * 更多 壁纸 界面
 */
public class MoreImageActivity extends BaseActivity {
    private RecyclerView recyclerView;
    private MoreImageAdapter moreImageAdapter;
    // 标题
    private ImageView leftIv;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_more_image;
    }

    // 初始化
    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.aty_more_image);
        recyclerView.setLayoutManager(new GridLayoutManager(this, 2));
        // 初始化
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
        // 设置标题栏
        leftIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("壁纸");
        titleTv.setTextColor(Color.WHITE);

        moreImageAdapter = new MoreImageAdapter(this);
        // 获取数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/AroundService/paper?size=1440&page=1&i_=869765028748315&t_=1463627358361&p_=27428&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<MoreImageBean>() {
                    @Override
                    public void onResponse(MoreImageBean response) {

                        moreImageAdapter.setMoreImageBeans(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, MoreImageBean.class);
        // 绑定适配器
        recyclerView.setAdapter(moreImageAdapter);

    }


}
