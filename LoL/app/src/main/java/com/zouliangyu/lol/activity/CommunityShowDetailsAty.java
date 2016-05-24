package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.CommunityShowDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.CommunityShowBean;

/**
 * Created by zouliangyu on 16/5/19.
 * 社区  真人秀 详情
 */
public class CommunityShowDetailsAty extends BaseActivity implements View.OnClickListener {
    private TextView titleTv;
    private ImageView leftIv;
    private RadioButton areaRb;
    private RadioButton newestRb;
    private RadioButton sexRb;

    private RecyclerView recyclerView;

    private CommunityShowDetailsAdapter communityShowDetailsAdapter;

    private PopupWindow popupWindow;
    private PopupWindow popupWindowTwo;
    private PopupWindow popupWindowThree;

    private LinearLayout publish;

    @Override
    protected int getLayout() {
        return R.layout.aty_community_show_details;
    }

    @Override
    protected void initView() {
        recyclerView = (RecyclerView) findViewById(R.id.community_show_rv);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        titleTv = (TextView) findViewById(R.id.title_tv);
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        leftIv.setOnClickListener(this);

        areaRb = (RadioButton) findViewById(R.id.show_area_rb);
        newestRb = (RadioButton) findViewById(R.id.show_newest_rb);
        sexRb = (RadioButton) findViewById(R.id.show_sex_rb);
        areaRb.setOnClickListener(this);
        newestRb.setOnClickListener(this);
        sexRb.setOnClickListener(this);

        publish = (LinearLayout) findViewById(R.id.show_publish);
        publish.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        titleTv.setText("真人秀");
        titleTv.setTextColor(Color.WHITE);
        leftIv.setImageResource(R.mipmap.global_back_d);


        communityShowDetailsAdapter = new CommunityShowDetailsAdapter(this);

        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<CommunityShowBean>() {
                    @Override
                    public void onResponse(CommunityShowBean response) {
                        communityShowDetailsAdapter.setCommunityShowBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, CommunityShowBean.class);
        recyclerView.setAdapter(communityShowDetailsAdapter);


        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.community_show_area_popup, null);
        popupWindow.setContentView(view);

        popupWindowTwo = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View newestView = LayoutInflater.from(this).inflate(R.layout.community_show_newest_popup, null);
        popupWindowTwo.setContentView(newestView);

        popupWindowThree = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View sexView = LayoutInflater.from(this).inflate(R.layout.community_show_sex_popup, null);
        popupWindowThree.setContentView(sexView);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left_iv:
                finish();
                break;
            case R.id.show_area_rb:
                if (!popupWindow.isShowing()) {
                    popupWindow.showAsDropDown(areaRb);

                    popupWindowTwo.dismiss();
                    popupWindowThree.dismiss();

                } else {
                    popupWindow.dismiss();
                }
                break;
            case R.id.show_newest_rb:
                if (!popupWindowTwo.isShowing()) {
                    popupWindowTwo.showAsDropDown(newestRb);

                    popupWindow.dismiss();
                    popupWindowThree.dismiss();
                } else {
                    popupWindowTwo.dismiss();
                }
                break;
            case R.id.show_sex_rb:
                if (!popupWindowThree.isShowing()) {
                    popupWindowThree.showAsDropDown(sexRb);

                    popupWindow.dismiss();
                    popupWindowTwo.dismiss();

                } else {
                    popupWindowThree.dismiss();
                }
                break;
            case R.id.show_publish:
                Intent intent = new Intent(CommunityShowDetailsAty.this, WelcomeActivity.class);
                startActivity(intent);
                break;

        }
    }
}
