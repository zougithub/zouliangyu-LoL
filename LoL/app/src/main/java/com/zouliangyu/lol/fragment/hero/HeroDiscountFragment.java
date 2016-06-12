package com.zouliangyu.lol.fragment.hero;

import android.webkit.WebView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseFragment;

/**
 * Created by zouliangyu on 16/5/16.
 * 折扣页面
 */
public class HeroDiscountFragment extends BaseFragment {
    private WebView webView;

    @Override
    public int initLayout() {
        return R.layout.fragment_hero_discount;
    }

    @Override
    public void initView() {
        webView = (WebView) getView().findViewById(R.id.webview);
    }

    @Override
    public void initData() {
        // http://lol.zhangyoubao.com/mobiles/nolayout/66618?dw=320%20HTTP/1.1
        webView.loadUrl("http://lol.zhangyoubao.com/mobiles/nolayout/66618?dw=320%20");
        // 支持JS
        webView.getSettings().setJavaScriptEnabled(true);
        // 不阻塞图片
        webView.getSettings().setBlockNetworkImage(false);

    }
}
