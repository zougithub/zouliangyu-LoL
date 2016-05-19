package com.zouliangyu.lol.base;

import android.app.Application;
import android.content.Context;

/**
 * Created by zouliangyu on 16/5/17.
 * 我们自己的Application
 * <p>
 * 在使用的时候, 需要在清单文件中注册
 */
public class MyApplication extends Application {
    public static Context context;

    // Application创建的原因是因为我们需要一个属于自己的大"环境" (context)
    // 保证自己的app拥有单独的context对象

    // 第一个生命周期中我们队context赋值
    @Override
    public void onCreate() {
        super.onCreate();

        // this代表当前的环境
        context = this;
    }


    // 对外提供一个方法, 这个方法就是让别的类获取自己的context对象
    public static Context getContext() {
        return context;
    }
}
