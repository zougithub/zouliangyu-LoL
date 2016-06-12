package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.os.CountDownTimer;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;
import cn.jpush.android.api.JPushInterface;

/**
 * Created by zouliangyu on 16/5/10.
 * 欢迎页
 */
public class WelcomeActivity extends BaseActivity {
    private ImageView welcomeIv; // 右上角
    private TextView timeTv;

    CountDownTimer time; // 倒计时

    @Override
    protected int getLayout() {
        return R.layout.activity_welcome;
    }

    @Override
    protected void initView() {
        welcomeIv = (ImageView) findViewById(R.id.welcome_iv);
        timeTv = (TextView) findViewById(R.id.welcome_time_tv);
    }

    @Override
    protected void initData() {
        timeTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                time.cancel();
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
                // 由左向右滑入效果
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
            }
        });

        // 倒计时
        time = new CountDownTimer(5000, 1000) {
            @Override
            public void onTick(long millisUntilFinished) {
                timeTv.setText(millisUntilFinished / 1000 + "s");
            }

            @Override
            public void onFinish() {
                timeTv.setText("跳转");
                startActivity(new Intent(WelcomeActivity.this, MainActivity.class));
                finish();
                // 切换动画
                // 必须在startActivity()或者finish()之后调用
                overridePendingTransition(R.anim.activity_in, R.anim.activity_out);
            }
        }.start();

    }

    @Override
    protected void onResume() {
        super.onResume();
        JPushInterface.onResume(this);
    }

    @Override
    protected void onPause() {
        super.onPause();
        time.cancel();
        JPushInterface.onPause(this);
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        time.start();
    }
}
