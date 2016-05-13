package com.zouliangyu.lol.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/9.
 */
public class InformationPagerAdapter extends FragmentPagerAdapter {
    private List<Fragment> fragments;
    private String[] titles = {"最新", "新闻", "赛事", "娱乐"};


    public void setFragments(List<Fragment> fragments) {
        this.fragments = fragments;
        notifyDataSetChanged();
    }

    public InformationPagerAdapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        return fragments.get(position);
    }

    @Override
    public int getCount() {
        return fragments == null ? 0 : fragments.size();
    }



    @Override
    public CharSequence getPageTitle(int position) {
        return titles[position];
    }
}
