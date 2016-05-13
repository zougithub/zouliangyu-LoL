package com.zouliangyu.lol.base;

import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by zouliangyu on 16/5/9.
 */
public abstract class BaseFragment extends Fragment {
    // 创建的Context对象
    protected Context mContext;


    /**
     * context 从依附的Activity 上获取 context 对象
     */
    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        mContext = context;
    }



    /**
     * 初始化视图
     */
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
       return inflater.inflate(initLayout(), container,false);
       // return inflater.from(mContext).inflate(initLayout(), container, false);

    }

    /**
     * 加载组件
     */
    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        initView();
    }

    /**
     * 加载数据
     */
    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initData();
    }





    public abstract int initLayout();

    public abstract void initView();

    public abstract void initData();

    protected <T extends View> T bindView(int id) {
        return (T) getView().findViewById(id);
    }


}
