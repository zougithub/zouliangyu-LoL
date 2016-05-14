package com.zouliangyu.lol.fragment.information;

import android.widget.ListView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseFragment;

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
