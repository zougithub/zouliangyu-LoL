package com.zouliangyu.lol.fragment.information;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.InformationPagerAdapter;
import com.zouliangyu.lol.base.BaseFragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouliangyu on 16/5/9.
 * <p/>
 * 资讯界面
 */
public class InformationFragment extends BaseFragment {
    private TabLayout informationTab;
    private ViewPager informationVp;
    // 装载Fragment的适配器
    private InformationPagerAdapter informationPagerAdapter;

    @Override
    public int initLayout() {
        return R.layout.fragment_information;
    }

    @Override
    public void initView() {
        informationTab = (TabLayout) getView().findViewById(R.id.information_tab);
        informationVp = (ViewPager) getView().findViewById(R.id.information_vp);

    }

    @Override
    public void initData() {
        FragmentManager manager = getChildFragmentManager();
        informationPagerAdapter = new InformationPagerAdapter(manager);

        List<Fragment> fragments = new ArrayList<>();
        // 10178  10000 10006 10179
        fragments.add(new InformationNewestFragment("10178"));
        fragments.add(new InformationNewestFragment("10000"));
        fragments.add(new InformationNewestFragment("10006"));
        fragments.add(new InformationNewestFragment("10179"));

        informationPagerAdapter.setFragments(fragments);
        informationVp.setAdapter(informationPagerAdapter);

        //tablayout与viewPager的绑定
        informationTab.setupWithViewPager(informationVp);
        // 设置标签选中颜色
        informationTab.setTabTextColors(Color.rgb(198, 204, 225), Color.rgb(98, 118, 184));
        // 下划线
        informationTab.setSelectedTabIndicatorColor(Color.rgb(98, 118, 184));


    }
}
