package com.zouliangyu.lol.fragment.hero;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.HeroPagerAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouliangyu on 16/5/9.
 * <p>
 * 英雄界面
 */
public class HeroFragment extends BaseFragment {
    private TabLayout heroTab;
    private ViewPager heroVp;
    private HeroPagerAdapter heroPagerAdapter;

    @Override
    public int initLayout() {
        return R.layout.fragment_hero;
    }

    @Override
    public void initView() {
        heroTab = (TabLayout) getView().findViewById(R.id.hero_tab);
        heroVp = (ViewPager) getView().findViewById(R.id.hero_vp);
    }

    @Override
    public void initData() {
        FragmentManager manager = getChildFragmentManager();
        heroPagerAdapter = new HeroPagerAdapter(manager);

        List<Fragment> fragments = new ArrayList<>();
        fragments.add(new HeroFreeOrDiscountFragment());
        fragments.add(new HeroMyHeroFragment());
        fragments.add(new HeroAllHeroFragment());
        heroPagerAdapter.setFragments(fragments);

        heroVp.setAdapter(heroPagerAdapter);

        heroTab.setupWithViewPager(heroVp);
        // 文字的颜色
        heroTab.setTabTextColors(Color.rgb(198, 204, 225), Color.rgb(98, 118, 184));
        // 引导线
        heroTab.setSelectedTabIndicatorColor(Color.rgb(98, 118, 184));

    }
}
