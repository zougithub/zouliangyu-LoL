package com.zouliangyu.lol.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;

import java.net.PasswordAuthentication;
import java.util.HashMap;
import java.util.Map;

import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.onekeyshare.OnekeyShareThemeImpl;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;

/**
 * Created by zouliangyu on 16/5/24.
 * 登录界面
 */
public class LoginActivity extends BaseActivity implements View.OnClickListener {
    private ImageView exitIv; // 退出
    private EditText passwordEt; // 输入密码
    private ImageView eyeIv; // 隐藏显示密码

    private boolean isDisplay; // boolean 是否显示密码


    @Override
    protected int getLayout() {
        return R.layout.activity_login;
    }

    @Override
    protected void initView() {
        ShareSDK.initSDK(this);

        // 初始化
        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        exitIv.setOnClickListener(this);
        findViewById(R.id.wechat_iv).setOnClickListener(this);
        findViewById(R.id.qq_iv).setOnClickListener(this);
        findViewById(R.id.weibo_iv).setOnClickListener(this);

        passwordEt = (EditText) findViewById(R.id.password_et);
        eyeIv = (ImageView) findViewById(R.id.eye_iv);
        eyeIv.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        exitIv.setImageResource(R.mipmap.global_back_d);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left_iv:
                finish();
                break;
            // 显示或隐藏密码
            case R.id.eye_iv:
                if (!isDisplay) {
                    // 隐藏密码
                    passwordEt.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                } else {
                    // 显示密码
                    passwordEt.setTransformationMethod(PasswordTransformationMethod.getInstance());
                }
                isDisplay = !isDisplay;
                // 使用postInvalidate可以直接在线程中更新界面
                passwordEt.postInvalidate();
                break;
            case R.id.wechat_iv:

                break;
            // 登录QQ
            case R.id.qq_iv:
                final Platform qq = ShareSDK.getPlatform(QQ.NAME);
                qq.SSOSetting(false);  //设置false表示使用SSO授权方式

                qq.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {
                    }
                });
                qq.authorize();
//                qq.showUser(null);
//                finish();
                break;
            case R.id.weibo_iv:
                final Platform weibo = ShareSDK.getPlatform(SinaWeibo.NAME);
                weibo.SSOSetting(false);  //设置false表示使用SSO授权方式
                weibo.setPlatformActionListener(new PlatformActionListener() {
                    @Override
                    public void onComplete(Platform platform, int i, HashMap<String, Object> hashMap) {
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                    }

                    @Override
                    public void onError(Platform platform, int i, Throwable throwable) {
                    }

                    @Override
                    public void onCancel(Platform platform, int i) {
                    }
                }); // 设置分享事件回调
                weibo.authorize();
                break;
        }
    }


}
