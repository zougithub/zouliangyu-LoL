package com.zouliangyu.lol.adapter;

import android.support.v4.view.PagerAdapter;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/10.
 *  图片
 *  PagerAdapter 装载普通view的适配器
 */
public class InformationBannerPagerAdapter extends PagerAdapter {
    private List<ImageView> mList;

    public InformationBannerPagerAdapter(List<ImageView> mList) {
        this.mList = mList;
        notifyDataSetChanged();
    }

    // 返回viewpager的页数
    @Override
    public int getCount() {
        // 取超大的数, 实现无限循环效果
        return mList == null ? 0 : Integer.MAX_VALUE;
    }

    // 判断View是否与Object有关联
    @Override
    public boolean isViewFromObject(View view, Object object) {
        return view == object;
    }

<<<<<<< HEAD
    // 增加页卡 返回当前position的新View
=======
    // 加载item
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        try {
            container.addView(mList.get(position % mList.size()));
<<<<<<< HEAD
        } catch (IllegalStateException error) {
=======
        }catch (IllegalStateException error) {
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
            Log.d("InformationBannerPagerA", "没啥事");
        }
        return mList.get(position % mList.size());
    }

<<<<<<< HEAD
    // 删除页卡
=======
    // 销毁item
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView(mList.get(position % mList.size()));
    }
}
