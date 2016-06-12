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
import com.zouliangyu.lol.adapter.MoreNovelAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreNovelBean;

/**
 * Created by zouliangyu on 16/5/20.
 * 小说界面
 */
public class MoreNovelActivity extends BaseActivity {
    private ListView listView;
    private MoreNovelAdapter moreNovelAdapter;
<<<<<<< HEAD
    // 标题
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private ImageView leftIv;
    private TextView titleTv;
    private MoreNovelBean moreNovelBean;

    @Override
    protected int getLayout() {
        return R.layout.activity_more_novel;
    }

    @Override
    protected void initView() {
        // 初始化
        listView = (ListView) findViewById(R.id.novel_listview);
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
        // 标题
        leftIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("小说列表");
        titleTv.setTextColor(Color.WHITE);


        moreNovelAdapter = new MoreNovelAdapter(this);
        // 获取数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/CatalogsService/all?cattype=novel&i_=869765028748315&t_=1463627391195&p_=5930&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<MoreNovelBean>() {
                    @Override
                    public void onResponse(MoreNovelBean response) {
                        moreNovelBean = response;
                        moreNovelAdapter.setMoreNovelBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, MoreNovelBean.class);
        listView.setAdapter(moreNovelAdapter);
        // 设置item点击
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MoreNovelActivity.this, MoreNovelDetailsItemDetailsAty.class);
                String ids = moreNovelBean.getData().get(0).getCatword_id().get(position).getId();
                String name = moreNovelBean.getData().get(0).getCatword_id().get(position).getName();
                String desc = moreNovelBean.getData().get(0).getCatword_id().get(position).getDesc();
                String imageUrl = moreNovelBean.getData().get(0).getCatword_id().get(position).getPic_url();
                intent.putExtra("ids", ids);
                intent.putExtra("name", name);
                intent.putExtra("desc", desc);
                intent.putExtra("imageUrl", imageUrl);
                startActivity(intent);
            }
        });

    }
}
