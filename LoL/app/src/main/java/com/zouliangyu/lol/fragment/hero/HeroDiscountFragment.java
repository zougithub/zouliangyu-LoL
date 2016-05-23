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

        webView.loadUrl("http://lol.zhangyoubao.com/mobiles/nolayout/65685");
        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setBlockNetworkImage(false);

    }
}
