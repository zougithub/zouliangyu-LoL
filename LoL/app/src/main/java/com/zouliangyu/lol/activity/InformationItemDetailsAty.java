package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.webkit.WebView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;

/**
 * Created by zouliangyu on 16/5/12.
 *
 * 资讯 最新界面 轮播图下 数据详情页面
 */
public class InformationItemDetailsAty extends BaseActivity {
    private WebView webView;

    @Override
    protected int getLayout() {
        return R.layout.aty_information_newest_details;
    }

    @Override
    protected void initView() {
        webView = (WebView) findViewById(R.id.webview);

    }

    @Override
    protected void initData() {


        Intent intent = getIntent();
        String ids = intent.getStringExtra("ids");
        String url = "http://lol.zhangyoubao.com/mobiles/item/" + ids + "?user_id=&token=&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438755282&p_=18191&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol&size=middle";
        // 用于加载URL对应的网页
        webView.loadUrl(url);

        webView.getSettings().setJavaScriptEnabled(true);

        // 不阻塞图片
        webView.getSettings().setBlockNetworkImage(false);

    }


}
