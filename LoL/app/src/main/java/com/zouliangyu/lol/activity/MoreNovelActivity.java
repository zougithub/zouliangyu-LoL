package com.zouliangyu.lol.activity;

import android.content.Intent;
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
 */
public class MoreNovelActivity extends BaseActivity {
    private ListView listView;
    private MoreNovelAdapter moreNovelAdapter;
    private ImageView leftIv;
    private TextView titleTv;

    private MoreNovelBean moreNovelBean;


    @Override
    protected int getLayout() {
        return R.layout.activity_more_novel;
    }

    @Override
    protected void initView() {
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
        leftIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("小说列表");


        moreNovelAdapter = new MoreNovelAdapter(this);
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

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(MoreNovelActivity.this, MoreNovelDetailsItemDetailsAty.class);
                String ids = moreNovelBean.getData().get(0).getCatword_id().get(position).getId();
                intent.putExtra("ids", ids);
                startActivity(intent);
            }
        });

    }
}
