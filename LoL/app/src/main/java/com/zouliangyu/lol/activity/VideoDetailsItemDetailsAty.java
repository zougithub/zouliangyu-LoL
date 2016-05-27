package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.GsonRequest;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.VideoDetailsItemDetailsBean;
import com.zouliangyu.lol.greendao.Article;
import com.zouliangyu.lol.greendao.ArticleDao;
import com.zouliangyu.lol.greendao.GreendaoSingle;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/18.
 * 视频Item详情页面  内的视频的详情
 */
public class VideoDetailsItemDetailsAty extends BaseActivity implements View.OnClickListener {

    private VideoView videoView;

    private VideoDetailsItemDetailsBean videoDetailsItemDetailsBean;

    private MediaController mediaController;


    private ImageView titleLeft;
    private TextView titleTv;
    private ImageView titleRight;
    private TextView title;
    private PopupWindow popupWindow;

    private ImageView collectIv;
    private TextView cancelTv;
    private String ids;
    private String titles;
    private String desc;
    private String times;
    private String urls;
    private ArticleDao articleDao;


    private boolean isCollect = false;

    @Override
    protected int getLayout() {
        return R.layout.aty_video_details_item_details;

//        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void initView() {
        videoView = (VideoView) findViewById(R.id.videoview);
        titleLeft = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        titleRight = (ImageView) findViewById(R.id.title_right_iv);
        title = (TextView) findViewById(R.id.details_title_tv);

        titleLeft.setOnClickListener(this);
        titleRight.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        articleDao = GreendaoSingle.getInstance().getArticleDao();


        titleTv.setTextColor(Color.WHITE);

        Intent intent = getIntent();
        ids = intent.getStringExtra("ids");
        titles = intent.getStringExtra("titles");
        desc = intent.getStringExtra("desc");
        times = intent.getStringExtra("times");


        // http://lol.zhangyoubao.com/apis/rest/ItemsService/videoInfo?itemid=65821&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438761089&p_=5612&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol
        urls = "http://lol.zhangyoubao.com/apis/rest/ItemsService/videoInfo?itemid=" + ids + "&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438761089&p_=5612&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol";
        Log.d("11111111111", urls);


        mediaController = new MediaController(this);

        VolleySingle.addRequest(urls, new Response.Listener<VideoDetailsItemDetailsBean>() {
            @Override
            public void onResponse(VideoDetailsItemDetailsBean response) {
                videoDetailsItemDetailsBean = response;
                Log.d("123456", response.getData().getId());


                Log.d("VideoDetailsItemDetails", videoDetailsItemDetailsBean.getData().getId() + "");
                Log.d("VideoDetailsItemDetails", videoDetailsItemDetailsBean.getData().getFrom_url());
                Uri uri = Uri.parse(videoDetailsItemDetailsBean.getData().getSd_url());

                videoView.setMediaController(mediaController);

                videoView.setVideoURI(uri);
                videoView.requestFocus();
                Log.d("123", videoDetailsItemDetailsBean.getData().getTitle());


                titleLeft.setImageResource(R.mipmap.global_back_d);
                titleTv.setText("掌游宝");
                titleRight.setImageResource(R.mipmap.global_btn_more_d);
                title.setText(videoDetailsItemDetailsBean.getData().getTitle());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("jiji", "jiji");
            }
        }, VideoDetailsItemDetailsBean.class);


        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(this).inflate(R.layout.article_popup, null);
        collectIv = (ImageView) view.findViewById(R.id.collect_iv);
        cancelTv = (TextView) view.findViewById(R.id.cancel_tv);
        collectIv.setOnClickListener(this);
        cancelTv.setOnClickListener(this);

        List<Article> articles = articleDao.queryBuilder().list();
        if (articles.size() > 0) {
            for (Article article : articles) {
                if (article.getId().toString().equals(ids)) {
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
                    popupWindow.showAsDropDown(titleRight);
                } else {
                    popupWindow.dismiss();
                }
                break;
            case R.id.collect_iv:
                Article article = new Article();
                if (isCollect == false) {
                    collectIv.setImageResource(R.mipmap.global_fav_p);
                    article.setId(Long.valueOf(ids));
                    article.setTitle(titles);
                    article.setDesc(desc);
                    article.setTime(times);
                    article.setUrl(urls);
                    articleDao.insert(article);
                    isCollect = true;
                } else {
                    collectIv.setImageResource(R.mipmap.global_fav_d);
                    Toast.makeText(this, "取消收藏", Toast.LENGTH_SHORT).show();
                    articleDao.deleteByKey(Long.valueOf(ids));
                    isCollect = false;
                }


                break;
            case R.id.cancel_tv:
                finish();
                break;
        }

    }


}
