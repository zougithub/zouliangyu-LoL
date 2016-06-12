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
import com.zouliangyu.lol.greendao.GreendaoSingle;
import com.zouliangyu.lol.greendao.Hero;
import com.zouliangyu.lol.greendao.HeroDao;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/24.
 * 英雄  资料界面
 */
public class HeroDetailsActivity extends BaseActivity implements View.OnClickListener {
    // 英雄介绍
    private TextView likeOne;
    private TextView likeTwo;
    private TextView hateOne;
    private TextView hateTwo;
    private TextView useWay;
    private TextView answerWay;
    private TextView descriptionTv;

    private ImageView imageView; // 头像
    private TextView codeTv; // 代号
    private TextView nameTv; // 名字
    private TextView typeTv; // 英雄类型

    private ImageView leftIv;
    private TextView titleTv;
    private ImageView collectIv;// 收藏
    private boolean isCollect; // 是否收藏
    private String enName; // 名字
    private String dataUrls; // 根据名字拼接的网址
    private String imgUrls; // 图片集合的网址
<<<<<<< HEAD
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private AllHeroIntroduceBean allHeroIntroduceBean;
    private String code; // 代号 例如:深渊巨口

    private HeroDao heroDao;
    private String id; // 每个英雄资料界面的id

    @Override
    protected int getLayout() {
        return R.layout.activity_hero_details;
    }

    @Override
    protected void initView() {
        // 英雄介绍
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
<<<<<<< HEAD
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        // 标题
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        leftIv.setOnClickListener(this);
        // 收藏
        collectIv = (ImageView) findViewById(R.id.collect_hero_iv);
        collectIv.setOnClickListener(this);

        // 收藏
        collectIv = (ImageView) findViewById(R.id.collect_hero_iv);
        collectIv.setOnClickListener(this);

    }

    @Override
    protected void initData() {
        heroDao = GreendaoSingle.getInstance().getHeroDao();
<<<<<<< HEAD
        // 标题栏
=======


>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        leftIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("英雄介绍");
        titleTv.setTextColor(Color.WHITE);

        Intent intent = getIntent();
        // 得到名字, 例如:Ekko, 根据名字拼接网址
        enName = intent.getStringExtra("enName");
        // 获取英雄资料界面的数据
        dataUrls = "http://lolbox.duowan.com/phone/apiHeroDetail.php?OSType=iOS9.3.1&heroName=" + enName + "&v=180%20HTTP/1.1";
        VolleySingle.addRequest(dataUrls, new Response.Listener<AllHeroIntroduceBean>() {
            @Override
            public void onResponse(AllHeroIntroduceBean response) {
                allHeroIntroduceBean = response;
                if (!allHeroIntroduceBean.getLike().isEmpty() && !allHeroIntroduceBean.getHate().isEmpty()) {
                    likeOne.setText(allHeroIntroduceBean.getLike().get(0).getDes());
                    likeTwo.setText(allHeroIntroduceBean.getLike().get(1).getDes());
                    hateOne.setText(allHeroIntroduceBean.getHate().get(0).getDes());
                    hateTwo.setText(allHeroIntroduceBean.getHate().get(1).getDes());
                } else {
                    likeOne.setText("无");
                    likeTwo.setText("无");
                    hateOne.setText("无");
                    hateTwo.setText("无");
                }
                useWay.setText(allHeroIntroduceBean.getTips());
                answerWay.setText(allHeroIntroduceBean.getOpponentTips());
                descriptionTv.setText(allHeroIntroduceBean.getDescription());

                codeTv.setText(allHeroIntroduceBean.getDisplayName());
                nameTv.setText(allHeroIntroduceBean.getTitle());
                typeTv.setText(allHeroIntroduceBean.getTags());

                code = allHeroIntroduceBean.getDisplayName();
                id = allHeroIntroduceBean.getId();


                // 查询数据库
                List<Hero> heros = heroDao.queryBuilder().list();
                if (heros.size() > 0) {
                    // 遍历数据
                    for (Hero hero : heros) {
                        // 如果数据库中有
                        if (hero.getId().toString().equals(id)) {
                            collectIv.setImageResource(R.mipmap.hero_fav);
                            isCollect = true;
                        }
                    }
                }
<<<<<<< HEAD
=======
                useWay.setText(allHeroIntroduceBean.getTips());
                answerWay.setText(allHeroIntroduceBean.getOpponentTips());
                descriptionTv.setText(allHeroIntroduceBean.getDescription());


                codeTv.setText(allHeroIntroduceBean.getDisplayName());
                nameTv.setText(allHeroIntroduceBean.getTitle());
                typeTv.setText(allHeroIntroduceBean.getTags());


                code = allHeroIntroduceBean.getDisplayName();
                id = allHeroIntroduceBean.getId();


                // 查询数据库
                List<Hero> heros = heroDao.queryBuilder().list();
                if (heros.size() > 0) {
                    // 遍历数据
                    for (Hero hero : heros) {
                        // 如果数据库中有
                        if (hero.getId().toString().equals(id)) {
                            collectIv.setImageResource(R.mipmap.hero_fav);
                            isCollect = true;
                        }
                    }
                }
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
            }
        }, AllHeroIntroduceBean.class);


        // 获取图片
        imgUrls = "http://box.dwstatic.com/apiHeroSkin.php?hero=" + enName + "&v=180&OSType=iOS9.3.1&versionName=3.0.1%20HTTP/1.1";
        VolleySingle.addRequest(imgUrls, new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {
                // 数组
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
<<<<<<< HEAD
            // 收藏
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
            case R.id.collect_hero_iv:
                Hero hero = new Hero();
                if (isCollect == false) {
                    collectIv.setImageResource(R.mipmap.hero_fav);
                    hero.setId(Long.valueOf(id));
                    hero.setImageUrl(imgUrls);
                    hero.setCode(code);
                    hero.setEnName(enName);
                    heroDao.insert(hero);
                    isCollect = true;
                } else {
                    collectIv.setImageResource(R.mipmap.hero_defav);
                    heroDao.deleteByKey(Long.valueOf(id));
                    isCollect = false;
                }
                break;
        }
    }
}
