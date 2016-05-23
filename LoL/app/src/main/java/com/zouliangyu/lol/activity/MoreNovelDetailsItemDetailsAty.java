package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.widget.ListView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.MoreNovelDetailsItemDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreNovelItemDetailsBean;

/**
 * Created by zouliangyu on 16/5/20.
 * <p/>
 * 更多 小说 详情 item界面
 */
public class MoreNovelDetailsItemDetailsAty extends BaseActivity {
    private ListView listView;
    private MoreNovelDetailsItemDetailsAdapter moreNovelDetailsItemDetailsAdapter;

    @Override
    protected int getLayout() {
        return R.layout.aty_more_novel_details_item_details;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.novel_details_item_details_listview);

    }

    @Override
    protected void initData() {

        moreNovelDetailsItemDetailsAdapter = new MoreNovelDetailsItemDetailsAdapter(this);

        Intent intent = getIntent();
        String ids = intent.getStringExtra("ids");
        String url = "http://lol.zhangyoubao.com/apis/rest/ItemsService/novels?catid=10195&catwordid=228&page=1&i_=869765028748315&t_=1463627448626&p_=28223&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1";
        String urls = "http://lol.zhangyoubao.com/apis/rest/ItemsService/novels?catid=10195&catwordid=" + ids + "&page=1&i_=869765028748315&t_=1463627448626&p_=28223&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1";
        VolleySingle.addRequest(urls, new Response.Listener<MoreNovelItemDetailsBean>() {
            @Override
            public void onResponse(MoreNovelItemDetailsBean response) {
                moreNovelDetailsItemDetailsAdapter.setMoreNovelItemDetailsBean(response);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, MoreNovelItemDetailsBean.class);
        listView.setAdapter(moreNovelDetailsItemDetailsAdapter);

    }
}
