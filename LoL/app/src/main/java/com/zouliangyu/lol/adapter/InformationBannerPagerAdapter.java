package com.zouliangyu.lol.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/10.
 */
public class InformationBannerPagerAdapter extends PagerAdapter {
    private List<ImageView> mList;

    public InformationBannerPagerAdapter(List<ImageView> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        // 取超大的数, 实现无限循环效果
        return mList == null ? 0 : Integer.MAX_VALUE;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

    // 加载item
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        try {
            container.addView(mList.get(position % mList.size()));
        }catch (IllegalStateException error) {
            Log.d("InformationBannerPagerA", "没啥事");
        }
        return mList.get(position % mList.size());
    }

    // 销毁item
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position % mList.size()));
    }
}
