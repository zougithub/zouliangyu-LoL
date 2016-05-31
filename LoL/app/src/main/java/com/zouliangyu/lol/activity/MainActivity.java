package com.zouliangyu.lol.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.fragment.community.CommunityFragment;
import com.zouliangyu.lol.fragment.hero.HeroFragment;
import com.zouliangyu.lol.fragment.information.InformationFragment;
import com.zouliangyu.lol.fragment.more.MoreFragment;
import com.zouliangyu.lol.fragment.video.VideoFragment;
import com.zouliangyu.lol.util.ExampleUtil;

import cn.jpush.android.api.JPushInterface;

/**
 * 邹良禹
 * LoL掌游宝
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private String[] titles = {"新闻资讯", "视频", "英雄搜索", "社区", "更多"};
    private TextView titleTv;
    private ImageView rightIv;

    private Button loginBtn;
    private ImageView loginIv;


    public static boolean isForeground = false;

    private int[] ids = {R.id.main_information_rb, R.id.main_video_rb,
            R.id.main_hero_rb, R.id.main_community_rb, R.id.main_more_rb};


    private DrawerLayout drawerLayout;
    private ImageView leftIv;

    private TextView myCollectTv;


    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        for (int i = 0; i < ids.length; i++) {
            findViewById(ids[i]).setOnClickListener(this);
        }

        titleTv = (TextView) findViewById(R.id.title_tv);
        rightIv = (ImageView) findViewById(R.id.title_right_iv);

        loginBtn = (Button) findViewById(R.id.slidingMenu_login_btn);
        loginBtn.setOnClickListener(this);
        loginIv = (ImageView) findViewById(R.id.slidingMenu_login_iv);
        loginIv.setOnClickListener(this);

        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        leftIv.setOnClickListener(this);

        myCollectTv = (TextView) findViewById(R.id.my_collect_tv);
        myCollectTv.setOnClickListener(this);


    }

    @Override
    protected void initData() {

        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_replace, new InformationFragment());

        titleTv.setText(titles[0]);
        titleTv.setTextColor(Color.WHITE);
        rightIv.setImageResource(R.mipmap.information_search);

        rightIv.setOnClickListener(this);
        transaction.commit();



        registerMessageReceiver();  // used for receive msg
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.main_information_rb:
                transaction.replace(R.id.main_replace, new InformationFragment());
                titleTv.setText(titles[0]);
                rightIv.setImageResource(R.mipmap.information_search);
                rightIv.setVisibility(View.VISIBLE);
                break;
            case R.id.main_video_rb:
                transaction.replace(R.id.main_replace, new VideoFragment());
                titleTv.setText(titles[1]);
                rightIv.setVisibility(View.GONE);
                break;
            case R.id.main_hero_rb:
                transaction.replace(R.id.main_replace, new HeroFragment());
                titleTv.setText(titles[2]);
                rightIv.setVisibility(View.GONE);
                break;
            case R.id.main_community_rb:
                transaction.replace(R.id.main_replace, new CommunityFragment());
                titleTv.setText(titles[3]);
                rightIv.setVisibility(View.GONE);
                break;
            case R.id.main_more_rb:
                transaction.replace(R.id.main_replace, new MoreFragment());
                titleTv.setText(titles[4]);
                rightIv.setVisibility(View.GONE);
                break;
            case R.id.slidingMenu_login_btn: // 登录按钮
                Intent intent = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intent);
                break;
            case R.id.title_right_iv:// 搜索
                Intent intentSearch = new Intent(MainActivity.this, InformationSearchActivity.class);
                startActivity(intentSearch);
                break;
            case R.id.title_left_iv:
                drawerLayout.openDrawer(Gravity.LEFT); // 从左打开
                break;
            case R.id.my_collect_tv: // 我的收藏
                Intent intentCollect = new Intent(this, MyCollectActivity.class);
                startActivity(intentCollect);
                break;
            case R.id.slidingMenu_login_iv: // 登录脑袋
                Intent intentLoginIv = new Intent(MainActivity.this, LoginActivity.class);
                startActivity(intentLoginIv);
                break;
        }
        transaction.commit();

    }


    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
    private void init(){
        JPushInterface.init(getApplicationContext());
    }


    @Override
    protected void onResume() {
        isForeground = true;
        super.onResume();
    }


    @Override
    protected void onPause() {
        isForeground = false;
        super.onPause();
    }


    @Override
    protected void onDestroy() {
        unregisterReceiver(mMessageReceiver);
        super.onDestroy();
    }


    //for receive customer msg from jpush server
    private MessageReceiver mMessageReceiver;
    public static final String MESSAGE_RECEIVED_ACTION = "com.example.jpushdemo.MESSAGE_RECEIVED_ACTION";
    public static final String KEY_TITLE = "title";
    public static final String KEY_MESSAGE = "message";
    public static final String KEY_EXTRAS = "extras";

    public void registerMessageReceiver() {
        mMessageReceiver = new MessageReceiver();
        IntentFilter filter = new IntentFilter();
        filter.setPriority(IntentFilter.SYSTEM_HIGH_PRIORITY);
        filter.addAction(MESSAGE_RECEIVED_ACTION);
        registerReceiver(mMessageReceiver, filter);
    }

    public class MessageReceiver extends BroadcastReceiver {

        @Override
        public void onReceive(Context context, Intent intent) {
            if (MESSAGE_RECEIVED_ACTION.equals(intent.getAction())) {
                String messge = intent.getStringExtra(KEY_MESSAGE);
                String extras = intent.getStringExtra(KEY_EXTRAS);
                StringBuilder showMsg = new StringBuilder();
                showMsg.append(KEY_MESSAGE + " : " + messge + "\n");
                if (!ExampleUtil.isEmpty(extras)) {
                    showMsg.append(KEY_EXTRAS + " : " + extras + "\n");
                }

            }
        }
    }


}
