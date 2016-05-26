package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.greendao.Article;
import com.zouliangyu.lol.greendao.ArticleDao;
import com.zouliangyu.lol.greendao.GreendaoSingle;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/12.
 * 资讯 轮播图下 数据详情页面
 */
public class InformationItemDetailsAty extends BaseActivity implements View.OnClickListener {
    private WebView webView;
    private ImageView exitIv;
    private TextView titleTv;
    private ImageView rightTv;
    private PopupWindow popupWindow;
    private LinearLayout collect;
    private TextView cancelTv;
    private String title;
    private String desc;
    private String times;
    private ArticleDao articleDao;
    private String url;


    @Override
    protected int getLayout() {
        return R.layout.aty_information_newest_details;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.webview);
        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        rightTv = (ImageView) findViewById(R.id.title_right_iv);
        exitIv.setOnClickListener(this);
        rightTv.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        articleDao = GreendaoSingle.getInstance().getArticleDao();
//        articleDao.deleteAll();



        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("掌游宝");
        titleTv.setTextColor(Color.WHITE);
        rightTv.setImageResource(R.mipmap.global_btn_more_d);


        Intent intent = getIntent();
        String ids = intent.getStringExtra("ids");

        title = intent.getStringExtra("title");
        desc = intent.getStringExtra("desc");
        times = intent.getStringExtra("times");

        url = "http://lol.zhangyoubao.com/mobiles/item/" + ids + "?user_id=&token=&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438755282&p_=18191&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol&size=middle";
        // 用于加载URL对应的网页
        webView.loadUrl(url);

        webView.getSettings().setJavaScriptEnabled(true);

        // 不阻塞图片
        webView.getSettings().setBlockNetworkImage(false);


        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(this).inflate(R.layout.article_popup, null);
        collect = (LinearLayout) view.findViewById(R.id.collect);
        cancelTv = (TextView) view.findViewById(R.id.cancel_tv);
        cancelTv.setOnClickListener(this);

        collect.setOnClickListener(this);

        popupWindow.setContentView(view);


    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left_iv:
                finish();
                break;
            case R.id.title_right_iv:
                if (!popupWindow.isShowing()) {
                    popupWindow.showAsDropDown(rightTv);
                } else {
                    popupWindow.dismiss();
                }
                break;
            case R.id.collect:
//                boolean collect = false;
//
//                if (collect = true){
//
//                }

                Article article = new Article();
                article.setTitle(title);
                article.setDesc(desc);
                article.setTime(times);
                article.setUrl(url);
                articleDao.insert(article);

                break;
            case R.id.cancel_tv:
                popupWindow.dismiss();
                break;
        }
    }

}
