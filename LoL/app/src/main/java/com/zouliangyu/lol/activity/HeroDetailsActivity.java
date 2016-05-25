package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.MyApplication;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroImgBean;
import com.zouliangyu.lol.bean.AllHeroIntroduceBean;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/24.
 */
public class HeroDetailsActivity extends BaseActivity implements View.OnClickListener {
    private TextView likeOne;
    private TextView likeTwo;
    private TextView hateOne;
    private TextView hateTwo;
    private TextView useWay;
    private TextView answerWay;
    private TextView descriptionTv;

    private ImageView imageView;
    private TextView codeTv;
    private TextView nameTv;
    private TextView typeTv;

    private ImageView leftIv;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_hero_details;
    }

    @Override
    protected void initView() {
        likeOne = (TextView) findViewById(R.id.friend_one);
        likeTwo = (TextView) findViewById(R.id.friend_two);
        hateOne = (TextView) findViewById(R.id.hate_one);
        hateTwo = (TextView) findViewById(R.id.hate_two);
        useWay = (TextView) findViewById(R.id.use_way);
        answerWay = (TextView) findViewById(R.id.answer_way);
        descriptionTv = (TextView) findViewById(R.id.description_tv);


        imageView = (ImageView) findViewById(R.id.aty_hero_item_details_head);
        codeTv = (TextView) findViewById(R.id.aty_hero_item_details_code);
        nameTv = (TextView) findViewById(R.id.aty_hero_item_details_name);
        typeTv = (TextView) findViewById(R.id.aty_hero_item_details_type);

        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        leftIv.setOnClickListener(this);

    }

    @Override
    protected void initData() {

        leftIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("英雄介绍");
        titleTv.setTextColor(Color.WHITE);

        Intent intent = getIntent();
        String enName = intent.getStringExtra("enName");

        String dataUrls = "http://lolbox.duowan.com/phone/apiHeroDetail.php?OSType=iOS9.3.1&heroName=" + enName + "&v=180%20HTTP/1.1";
        VolleySingle.addRequest(dataUrls, new Response.Listener<AllHeroIntroduceBean>() {
            @Override
            public void onResponse(AllHeroIntroduceBean response) {

                likeOne.setText(response.getLike().get(0).getDes());
                likeTwo.setText(response.getLike().get(1).getDes());
                hateOne.setText(response.getHate().get(0).getDes());
                hateTwo.setText(response.getHate().get(1).getDes());
                useWay.setText(response.getTips());
                answerWay.setText(response.getOpponentTips());
                descriptionTv.setText(response.getDescription());

                codeTv.setText(response.getDisplayName());
                nameTv.setText(response.getTitle());
                typeTv.setText(response.getTags());
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, AllHeroIntroduceBean.class);


        String imgUrls = "http://box.dwstatic.com/apiHeroSkin.php?hero=" + enName + "&v=180&OSType=iOS9.3.1&versionName=3.0.1%20HTTP/1.1";
        VolleySingle.addRequest(imgUrls, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                Gson gson = new Gson();
                List<AllHeroImgBean> allHeroImgBeans = gson.fromJson(response,
                        new TypeToken<ArrayList<AllHeroImgBean>>() {
                        }.getType());
                Picasso.with(MyApplication.context).load(allHeroImgBeans.get(0).getSmallImg())
                        .placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        });


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left_iv:
                finish();
                break;
        }
    }
}
