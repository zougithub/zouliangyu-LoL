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
 */
public class InformationFragment extends BaseFragment {
    private TabLayout informationTab;
    private ViewPager informationVp;
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
        fragments.add(new InformationNewestFragment());
        fragments.add(new InformationNewsFragment());
        fragments.add(new InformationMatchFragment());
        fragments.add(new InformationPlayFragment());

        informationPagerAdapter.setFragments(fragments);
        informationVp.setAdapter(informationPagerAdapter);
        informationTab.setupWithViewPager(informationVp);

        informationTab.setTabTextColors(Color.rgb(198, 204, 225), Color.rgb(98, 118, 184));
        informationTab.setSelectedTabIndicatorColor(Color.rgb(98,118,184));
    }
}
