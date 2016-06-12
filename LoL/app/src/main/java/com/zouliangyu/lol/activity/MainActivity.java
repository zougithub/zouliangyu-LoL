package com.zouliangyu.lol.activity;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.widget.DrawerLayout;
import android.util.Log;
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

<<<<<<< HEAD
import org.w3c.dom.Text;

import cn.jpush.android.api.CustomPushNotificationBuilder;
import cn.jpush.android.api.JPushInterface;
import cn.sharesdk.framework.Platform;
import cn.sharesdk.framework.PlatformActionListener;
import cn.sharesdk.framework.ShareSDK;
import cn.sharesdk.sina.weibo.SinaWeibo;
import cn.sharesdk.tencent.qq.QQ;
import it.sephiroth.android.library.picasso.Picasso;
=======
import cn.jpush.android.api.JPushInterface;
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068

/**
 * 邹良禹
 * LoL掌游宝
 */

public class MainActivity extends BaseActivity implements View.OnClickListener {
    private String[] titles = {"新闻资讯", "视频", "英雄搜索", "社区", "更多"};
    // 标题
    private TextView titleTv;
    private ImageView rightIv;
    // 抽屉登录
    private TextView loginBtn;
    private ImageView loginIv;
<<<<<<< HEAD
    public static boolean isForeground = false; // 推送的
    // RadioButton
=======


    public static boolean isForeground = false;

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    private int[] ids = {R.id.main_information_rb, R.id.main_video_rb,
            R.id.main_hero_rb, R.id.main_community_rb, R.id.main_more_rb};
    // 抽屉
    private DrawerLayout drawerLayout;
    // 头像, 点击抽屉出来
    private ImageView leftIv;
    // 我的收藏
    private TextView myCollectTv;
    // 注销
    private TextView exitTv;
    // QQ
    private Platform platform;
    // SinaWeibo
    private Platform platform1;

    @Override
    protected int getLayout() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {

        ShareSDK.initSDK(this);

        for (int i = 0; i < ids.length; i++) {
            findViewById(ids[i]).setOnClickListener(this);
        }
        // 标题
        titleTv = (TextView) findViewById(R.id.title_tv);
        rightIv = (ImageView) findViewById(R.id.title_right_iv);
        // 登录按钮和头像
        loginBtn = (TextView) findViewById(R.id.slidingMenu_login_btn);
        loginBtn.setOnClickListener(this);
        loginIv = (ImageView) findViewById(R.id.slidingMenu_login_iv);
        loginIv.setOnClickListener(this);
        // 抽屉
        drawerLayout = (DrawerLayout) findViewById(R.id.main_drawerlayout);
        // 头像 点击弹出抽屉
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        leftIv.setOnClickListener(this);
        // 我的收藏
        myCollectTv = (TextView) findViewById(R.id.my_collect_tv);
        myCollectTv.setOnClickListener(this);
        // 注销
        exitTv = (TextView) findViewById(R.id.exiting);
        exitTv.setOnClickListener(this);

    }

    @Override
    protected void initData() {

        // 获取QQ里的数据
        platform = ShareSDK.getPlatform(this, QQ.NAME);
        // 获取SinaWeibo里的数据
        platform1 = ShareSDK.getPlatform(this, SinaWeibo.NAME);
        if (platform.isValid()) {
            Picasso.with(this).load(platform.getDb().getUserIcon()).into(loginIv);

            loginBtn.setText(platform.getDb().getUserName());
            exitTv.setVisibility(View.VISIBLE);
        }
        if (platform1.isValid()) {
            Picasso.with(this).load(platform1.getDb().getUserIcon()).into(loginIv);
            loginBtn.setText(platform1.getDb().getUserName());
            exitTv.setVisibility(View.VISIBLE);
        }


        // FragmentManager能够实现管理activity中fragment.通过调用activity的
        // getSupportFragmentManager()获得它的实例
        FragmentManager manager = getSupportFragmentManager();
        // FragmentTransaction对fragment进行替换
        // beginTransaction 开始业务操作
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.main_replace, new InformationFragment());

        titleTv.setText(titles[0]);
        titleTv.setTextColor(Color.WHITE);
        rightIv.setImageResource(R.mipmap.information_search);

        loginBtn.setTextColor(Color.rgb(98, 118, 184));
        myCollectTv.setTextColor(Color.WHITE);

        rightIv.setOnClickListener(this);
        transaction.commit();


<<<<<<< HEAD
        registerMessageReceiver();  // used for receive msg

        // 设置通知栏
        CustomPushNotificationBuilder builder = new
                CustomPushNotificationBuilder(MainActivity.this,
                R.layout.customer_notitfication_layout,
                R.id.icon,
                R.id.title,
                R.id.text);
        // 指定定制的 Notification Layout
        builder.statusBarDrawable = R.mipmap.demo;
        // 指定最顶层状态栏小图标
        builder.layoutIconDrawable = R.mipmap.push;
        // 指定下拉状态栏时显示的通知图标
        JPushInterface.setPushNotificationBuilder(2, builder);

=======

        registerMessageReceiver();  // used for receive msg
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        // 替换fragment  开始业务
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

            case R.id.exiting:
                // 取消授权
                if (platform.isValid()) {
                    platform.removeAccount();
                }
                if (platform1.isValid()) {
                    platform1.removeAccount();
                }


                loginIv.setImageResource(R.mipmap.left_menu_head);
                loginBtn.setText("点击头像登录");
                exitTv.setVisibility(View.INVISIBLE);
                break;
        }
        transaction.commit();

    }


    // 初始化 JPush。如果已经初始化，但没有登录成功，则执行重新登录。
<<<<<<< HEAD
    private void init() {
=======
    private void init(){
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
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
