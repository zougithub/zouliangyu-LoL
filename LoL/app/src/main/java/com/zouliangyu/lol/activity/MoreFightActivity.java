package com.zouliangyu.lol.activity;

import android.webkit.WebView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;

/**
 * Created by zouliangyu on 16/5/23.
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
        webView.loadUrl("http://lol.duowan.com/zdl/");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);

    }
}
