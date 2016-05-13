package com.zouliangyu.lol.fragment.information;

import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.InformationNewestAdapter;
import com.zouliangyu.lol.adapter.InformationNewsAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.bean.Bean;
import com.zouliangyu.lol.bean.NewsBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouliangyu on 16/5/9.
 */
public class InformationNewsFragment extends BaseFragment{
    private ListView newsLv;

    @Override
    public int initLayout() {
        return R.layout.fragment_information_news;
    }

    @Override
    public void initView() {
        newsLv = (ListView) getView().findViewById(R.id.information_news_lv);

    }

    @Override
    public void initData() {


    }
}
