package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.MediaController;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.VideoDetailsItemDetailsBean;
import com.zouliangyu.lol.greendao.Article;
import com.zouliangyu.lol.greendao.ArticleDao;
import com.zouliangyu.lol.greendao.GreendaoSingle;
import java.util.List;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by zouliangyu on 16/5/18.
 * 视频Item详情页面  内的视频的详情
 */
public class VideoDetailsItemDetailsAty extends BaseActivity implements View.OnClickListener {

    private VideoView videoView;
    private VideoDetailsItemDetailsBean videoDetailsItemDetailsBean;
    private MediaController mediaController;

<<<<<<< HEAD
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    // 标题
    private ImageView titleLeft;
    private TextView titleTv;
    private ImageView titleRight;
    private TextView title; // 视频上面的文字
<<<<<<< HEAD
    // 菜单
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private PopupWindow popupWindow;
    private ImageView collectIv;
    private LinearLayout refresh;
    private TextView cancelTv;
<<<<<<< HEAD
    // 加入数据库的
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private String ids;
    private String titles;
    private String desc;
    private String times;
    private String urls;
    private ArticleDao articleDao;

    private boolean isCollect = false;
    private String videoUrl;

    @Override
    protected int getLayout() {
        return R.layout.aty_video_details_item_details;
    }

    @Override
    protected void initView() {
        videoView = (VideoView) findViewById(R.id.videoview);
<<<<<<< HEAD
        // 初始化标题栏
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
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
        // 要播放的视频
        videoUrl = intent.getStringExtra("videoUrl");

        urls = "http://lol.zhangyoubao.com/apis/rest/ItemsService/videoInfo?itemid=" + ids + "&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438761089&p_=5612&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol";
<<<<<<< HEAD
        // 一个包含媒体播放器(MediaPlayer)控件的视图
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        mediaController = new MediaController(this);
        // 获取数据
        VolleySingle.addRequest(urls, new Response.Listener<VideoDetailsItemDetailsBean>() {
            @Override
            public void onResponse(VideoDetailsItemDetailsBean response) {
                videoDetailsItemDetailsBean = response;
<<<<<<< HEAD
=======

                Uri uri = Uri.parse(videoDetailsItemDetailsBean.getData().getSd_url());

                videoView.setMediaController(mediaController);

                videoView.setVideoURI(uri);
                videoView.requestFocus();

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                titleLeft.setImageResource(R.mipmap.global_back_d);
                titleTv.setText("掌游宝");
                titleRight.setImageResource(R.mipmap.global_btn_more_d);
                title.setText(videoDetailsItemDetailsBean.getData().getTitle());

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, VideoDetailsItemDetailsBean.class);

        // 播放视频
        Uri uri = Uri.parse(videoUrl);
        videoView.setMediaController(mediaController);
        videoView.setVideoURI(uri);
        videoView.requestFocus();


        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.article_popup, null);
        collectIv = (ImageView) view.findViewById(R.id.collect_iv);
<<<<<<< HEAD
        view.findViewById(R.id.share).setOnClickListener(this);
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        refresh = (LinearLayout) view.findViewById(R.id.refresh);
        cancelTv = (TextView) view.findViewById(R.id.cancel_tv);

        collectIv.setOnClickListener(this);
        refresh.setOnClickListener(this);
        cancelTv.setOnClickListener(this);


<<<<<<< HEAD
        // 数据库中文章的集合
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
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
        // 点击其他区域popup消失
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setOutsideTouchable(true);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left_iv:
                finish();
                break;
            // 菜单
            case R.id.title_right_iv:
                if (!popupWindow.isShowing()) {
                    popupWindow.showAsDropDown(titleRight);

                    // 设置背景颜色变暗
                    WindowManager.LayoutParams lp = getWindow().getAttributes();
                    lp.alpha = 0.5f;
                    getWindow().setAttributes(lp);
                    popupWindow.setOnDismissListener(new PopupWindow.OnDismissListener() {
                        @Override
                        public void onDismiss() {
                            WindowManager.LayoutParams lp = getWindow().getAttributes();
                            lp.alpha = 1f;
                            getWindow().setAttributes(lp);
                        }
                    });
                } else {
                    popupWindow.dismiss();
                }
                break;
            // 收藏
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
<<<<<<< HEAD
=======

                break;
            case R.id.refresh:
                VolleySingle.addRequest(urls, new Response.Listener<VideoDetailsItemDetailsBean>() {
                    @Override
                    public void onResponse(VideoDetailsItemDetailsBean response) {
                        videoDetailsItemDetailsBean = response;

                        Uri uri = Uri.parse(videoDetailsItemDetailsBean.getData().getSd_url());

                        videoView.setMediaController(mediaController);

                        videoView.setVideoURI(uri);
                        videoView.requestFocus();

                        titleLeft.setImageResource(R.mipmap.global_back_d);
                        titleTv.setText("掌游宝");
                        titleRight.setImageResource(R.mipmap.global_btn_more_d);
                        title.setText(videoDetailsItemDetailsBean.getData().getTitle());

                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, VideoDetailsItemDetailsBean.class);
                popupWindow.dismiss();
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                break;
            // 刷新
            case R.id.refresh:
                VolleySingle.addRequest(urls, new Response.Listener<VideoDetailsItemDetailsBean>() {
                    @Override
                    public void onResponse(VideoDetailsItemDetailsBean response) {
                        videoDetailsItemDetailsBean = response;

                        titleLeft.setImageResource(R.mipmap.global_back_d);
                        titleTv.setText("掌游宝");
                        titleRight.setImageResource(R.mipmap.global_btn_more_d);
                        title.setText(videoDetailsItemDetailsBean.getData().getTitle());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, VideoDetailsItemDetailsBean.class);
                popupWindow.dismiss();
                // 播放视频
                Uri uri = Uri.parse(videoUrl);
                videoView.setMediaController(mediaController);
                videoView.setVideoURI(uri);
                videoView.requestFocus();
                break;
            // 取消
            case R.id.cancel_tv:
                popupWindow.dismiss();
                break;
            // 分享
            case R.id.share:
                showShare();
                popupWindow.dismiss();
                break;
        }

    }


    private void showShare() {
        ShareSDK.initSDK(this);
        OnekeyShare oks = new OnekeyShare();
        //关闭sso授权
        oks.disableSSOWhenAuthorize();

        // 分享时Notification的图标和文字  2.5.9以后的版本不调用此方法
        //oks.setNotification(R.drawable.ic_launcher, getString(R.string.app_name));
        // title标题，印象笔记、邮箱、信息、微信、人人网和QQ空间使用
        oks.setTitle(getString(R.string.share));
        // titleUrl是标题的网络链接，仅在人人网和QQ空间使用
        oks.setTitleUrl(videoUrl);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        // oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl("http://sharesdk.cn");
        // comment是我对这条分享的评论，仅在人人网和QQ空间使用
        oks.setComment("我是测试评论文本");
        // site是分享此内容的网站名称，仅在QQ空间使用
        oks.setSite(getString(R.string.app_name));
        // siteUrl是分享此内容的网站地址，仅在QQ空间使用
        oks.setSiteUrl("http://sharesdk.cn");

        // 启动分享GUI
        oks.show(this);
    }


}
