package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
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
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

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
    // 加入数据库的
    private String ids;
    private long idd;
    private String title;
    private String desc;
    private String times;
    private ArticleDao articleDao;
    private String url;
<<<<<<< HEAD
    // 菜单
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private PopupWindow popupWindow;
    private ImageView collectIv; // 收藏
    private boolean isCollect = false;
    private TextView cancelTv; // 取消
    private LinearLayout refresh; // 刷新
<<<<<<< HEAD
    private LinearLayout share; // 分享
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068

    @Override
    protected int getLayout() {
        return R.layout.aty_information_newest_details;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.webview);
<<<<<<< HEAD
        // 标题栏
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        rightTv = (ImageView) findViewById(R.id.title_right_iv);

        exitIv.setOnClickListener(this);
        rightTv.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        articleDao = GreendaoSingle.getInstance().getArticleDao();

        // 设置标题栏
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
<<<<<<< HEAD
        // webview设置支持Javascript
        // JavaScript一种直译式脚本语言
        // 广泛用于客户端的脚本语言，最早是在HTML（标准通用标记语言下的一个应用）网页上使用，
        // 用来给HTML网页增加动态功能。
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        webView.getSettings().setJavaScriptEnabled(true);
        // 不阻塞图片
        webView.getSettings().setBlockNetworkImage(false);

        // 菜单
        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.article_popup, null);
        collectIv = (ImageView) view.findViewById(R.id.collect_iv);
        cancelTv = (TextView) view.findViewById(R.id.cancel_tv);
        refresh = (LinearLayout) view.findViewById(R.id.refresh);
<<<<<<< HEAD
        share = (LinearLayout) view.findViewById(R.id.share);
        share.setOnClickListener(this);
        collectIv.setOnClickListener(this);
        cancelTv.setOnClickListener(this);
        refresh.setOnClickListener(this);


=======
        collectIv.setOnClickListener(this);
        cancelTv.setOnClickListener(this);
        refresh.setOnClickListener(this);
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068


        // 遍历数据库, 是否已收藏
        List<Article> articles = articleDao.queryBuilder().list();
        if (articles.size() > 0) {
            for (Article article : articles) {
                if (article.getId().toString().equals(ids.toString())) {
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
                    popupWindow.showAsDropDown(rightTv);

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
                    article.setId(idd);
                    article.setTitle(title);
                    article.setDesc(desc);
                    article.setTime(times);
                    article.setUrl(url);
                    articleDao.insert(article);
                    isCollect = true;

                } else {
                    collectIv.setImageResource(R.mipmap.global_fav_d);
                    articleDao.deleteByKey(idd);
                    isCollect = false;
                }

                break;
            // 取消
            case R.id.cancel_tv:
                popupWindow.dismiss();
                break;
            case R.id.refresh:
<<<<<<< HEAD

=======
                url = "http://lol.zhangyoubao.com/mobiles/item/" + ids + "?user_id=&token=&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438755282&p_=18191&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol&size=middle";
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                // 用于加载URL对应的网页
                webView.loadUrl(url);
                webView.getSettings().setJavaScriptEnabled(true);
                // 不阻塞图片
                webView.getSettings().setBlockNetworkImage(false);
                popupWindow.dismiss();
                break;
<<<<<<< HEAD
            case R.id.share:
                showShare();
                popupWindow.dismiss();
                break;
=======
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068

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
        oks.setTitleUrl(url);
        // text是分享文本，所有平台都需要这个字段
        oks.setText("我是分享文本");
        // imagePath是图片的本地路径，Linked-In以外的平台都支持此参数
        // oks.setImagePath("/sdcard/test.jpg");//确保SDcard下面存在此张图片
        // url仅在微信（包括好友和朋友圈）中使用
        oks.setUrl(url);
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
