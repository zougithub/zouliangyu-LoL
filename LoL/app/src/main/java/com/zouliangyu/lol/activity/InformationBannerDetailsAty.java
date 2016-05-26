package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;

/**
 * Created by zouliangyu on 16/5/17.
 * 轮播图详情页
 */
public class InformationBannerDetailsAty extends BaseActivity implements View.OnClickListener {
    private WebView webView;
    private ImageView exitIv;
    private TextView titleTv;
    private ImageView rightIv;
    private PopupWindow popupWindow;
    private TextView cancelTv;

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
        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("掌游宝");
        titleTv.setTextColor(Color.WHITE);
        rightIv.setImageResource(R.mipmap.global_btn_more_d);

        Intent intent = getIntent();
        String ids = intent.getStringExtra("ids");
        String url = "http://lol.zhangyoubao.com/mobiles/item/" + ids + "?user_id=&token=&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438745222&p_=18011&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol&size=middle";
        Log.d("InformationBannerDetail", url);
        webView.loadUrl(url);

        webView.getSettings().setJavaScriptEnabled(true);
        // 不阻塞图片
        webView.getSettings().setBlockNetworkImage(false);

        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.MATCH_PARENT);
        View view = LayoutInflater.from(this).inflate(R.layout.article_popup, null);
        cancelTv = (TextView) view.findViewById(R.id.cancel_tv);
        cancelTv.setOnClickListener(this);
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
                    popupWindow.showAsDropDown(rightIv);
                } else {
                    popupWindow.dismiss();
                }
                break;
            case R.id.cancel_tv:
                popupWindow.dismiss();
                break;
        }
    }
}
