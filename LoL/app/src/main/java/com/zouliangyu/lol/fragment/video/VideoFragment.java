package com.zouliangyu.lol.fragment.video;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.VideoPagerAdapter;
import com.zouliangyu.lol.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouliangyu on 16/5/9.
 */
public class VideoFragment extends BaseFragment{
    private TabLayout videoTab;
    private ViewPager videoVp;
    private VideoPagerAdapter videoPagerAdapter;
    @Override
    public int initLayout() {
        return R.layout.fragment_video;
    }

    @Override
    public void initView() {
        videoTab = (TabLayout) getView().findViewById(R.id.video_tab);
        videoVp = (ViewPager) getView().findViewById(R.id.video_vp);

    }

    @Override
    public void initData() {
        FragmentManager manager = getChildFragmentManager();
        videoPagerAdapter = new VideoPagerAdapter(manager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new VideoPlayFragment(0));
        fragments.add(new VideoPlayFragment(1));
        fragments.add(new VideoPlayFragment(2));
        videoPagerAdapter.setFragments(fragments);

        videoVp.setAdapter(videoPagerAdapter);
        videoTab.setupWithViewPager(videoVp);
        videoTab.setTabTextColors(Color.rgb(198, 204, 225), Color.rgb(98, 118, 184));
        videoTab.setSelectedTabIndicatorColor(Color.rgb(98,118,184));

    }
}
