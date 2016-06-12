package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.BitmapDrawable;
import android.util.Log;
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

import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShare;

/**
 * Created by zouliangyu on 16/5/17.
 * 轮播图详情页
 */
public class InformationBannerDetailsAty extends BaseActivity implements View.OnClickListener {
    private WebView webView;
    // 标题栏
    private ImageView exitIv;
    private TextView titleTv;
    private ImageView rightIv;
<<<<<<< HEAD
    // 菜单
=======

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private PopupWindow popupWindow;
    private LinearLayout refresh;
    private TextView cancelTv;
    private LinearLayout refresh;
    private String ids;
    private String url;

    private String ids;
    private String url;

    @Override
    protected int getLayout() {
        return R.layout.aty_information_banner_details;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.information_banner_details_webview);

        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        rightIv = (ImageView) findViewById(R.id.title_right_iv);
        exitIv.setOnClickListener(this);
        rightIv.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        // 设置标题栏
        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("掌游宝");
        titleTv.setTextColor(Color.WHITE);
        rightIv.setImageResource(R.mipmap.global_btn_more_d);

        Intent intent = getIntent();
        ids = intent.getStringExtra("ids");
        url = "http://lol.zhangyoubao.com/mobiles/item/" + ids + "?user_id=&token=&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438745222&p_=18011&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol&size=middle";
        webView.loadUrl(url);
        // 允许JS执行
        webView.getSettings().setJavaScriptEnabled(true);
        // 不阻塞图片  true 是把图片加载放在最后来加载渲染
        webView.getSettings().setBlockNetworkImage(false);

<<<<<<< HEAD

        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.banner_popup, null);
        view.findViewById(R.id.share).setOnClickListener(this);
=======
        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(this).inflate(R.layout.banner_popup, null);
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        refresh = (LinearLayout) view.findViewById(R.id.refresh);
        cancelTv = (TextView) view.findViewById(R.id.cancel_tv);
        refresh.setOnClickListener(this);
        cancelTv.setOnClickListener(this);
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
                    popupWindow.showAsDropDown(rightIv);
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
            case R.id.cancel_tv:
                popupWindow.dismiss();
                break;
<<<<<<< HEAD
            // 刷新
            case R.id.refresh:
                webView.loadUrl(url);
                // 支持JS
=======
            case R.id.refresh:
                webView.loadUrl(url);
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                webView.getSettings().setJavaScriptEnabled(true);
                // 不阻塞图片
                webView.getSettings().setBlockNetworkImage(false);
                popupWindow.dismiss();
                break;
<<<<<<< HEAD
            // 分享
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
        oks.setTitleUrl("http://lol.duowan.com/zdl/");

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
