package com.zouliangyu.lol.activity;

import android.webkit.WebView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;

/**
 * Created by zouliangyu on 16/5/23.
 * 更多 战绩查询
 */
public class MoreFightActivity extends BaseActivity {
    private WebView webView;

    @Override
    protected int getLayout() {
        return R.layout.activity_more_fight;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.fight_webview);

    }

    @Override
    protected void initData() {
        // http://lol.duowan.com/zdl/
        webView.loadUrl("http://www.lolhelper.cn/rank.php");

        // webview设置支持Javascript
        webView.getSettings().setJavaScriptEnabled(true);
        // 不阻塞图片
        webView.getSettings().setBlockNetworkImage(false);
    }
}
