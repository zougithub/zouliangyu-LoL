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
        fragments.add(new InformationNewestFragment("http://lol.zhangyoubao.com/apis/rest/ItemsService/lists?cattype=news&catid=10178&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438745347&p_=18386&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol"));
        fragments.add(new InformationNewestFragment("http://lol.zhangyoubao.com/apis/rest/ItemsService/lists?cattype=news&catid=10000&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438746202&p_=20951&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol"));
        fragments.add(new InformationNewestFragment("http://lol.zhangyoubao.com/apis/rest/ItemsService/lists?cattype=news&catid=10006&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438754522&p_=15911&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol"));
        fragments.add(new InformationNewestFragment("http://lol.zhangyoubao.com/apis/rest/ItemsService/lists?cattype=news&catid=10179&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438755014&p_=17387&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol"));

        informationPagerAdapter.setFragments(fragments);

        informationVp.setAdapter(informationPagerAdapter);
        informationVp.setCurrentItem(3);
        informationVp.setCurrentItem(0);
        informationTab.setupWithViewPager(informationVp);

        informationTab.setTabTextColors(Color.rgb(198, 204, 225), Color.rgb(98, 118, 184));
        informationTab.setSelectedTabIndicatorColor(Color.rgb(98, 118, 184));


    }
}
