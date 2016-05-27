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
import android.widget.Toast;

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

    // 标题栏
    private ImageView exitIv;
    private TextView titleTv;
    private ImageView rightTv;

    private PopupWindow popupWindow;


    private TextView cancelTv;

    // 加入数据库的
    private String ids;
    private long idd;
    private String title;
    private String desc;
    private String times;
    private ArticleDao articleDao;
    private String url;


    private ImageView collectIv;
    private boolean isCollect = false;


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

        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("掌游宝");
        titleTv.setTextColor(Color.WHITE);
        rightTv.setImageResource(R.mipmap.global_btn_more_d);


        Intent intent = getIntent();
        ids = intent.getStringExtra("ids");
        idd = Long.parseLong(ids);
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
        collectIv = (ImageView) view.findViewById(R.id.collect_iv);
        collectIv.setOnClickListener(this);
        cancelTv = (TextView) view.findViewById(R.id.cancel_tv);
        cancelTv.setOnClickListener(this);


        // 遍历数据库, 是否已收藏
        List<Article> articles = articleDao.queryBuilder().list();
        Log.d("InformationItemDetailsA", "articles.size():" + articles.size());
        if (articles.size() > 0) {
            for (Article article1 : articles) {
                Log.d("InformationItemDetailsA", "article1.getId():" + article1.getId());
                Log.d("InformationItemDetailsA", ids);
                if (article1.getId().toString().equals(ids.toString())) {
                    collectIv.setImageResource(R.mipmap.global_fav_p);
                    isCollect = true;
                }
            }

        }

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
            case R.id.collect_iv:
                Article article = new Article();
                if (isCollect == false) {
                    collectIv.setImageResource(R.mipmap.global_fav_p);
                    article.setId(idd);
                    article.setTitle(title);
                    article.setDesc(desc);
                    article.setTime(times);
                    article.setUrl(url);
                    articleDao.insert(article);
                    Toast.makeText(this, "1111", Toast.LENGTH_SHORT).show();
                    isCollect = true;


                } else {
                    collectIv.setImageResource(R.mipmap.global_fav_d);
                    Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
                    articleDao.deleteByKey(idd);
                    isCollect = false;


                }

                break;
            case R.id.cancel_tv:
                popupWindow.dismiss();
                break;
        }
    }

}
