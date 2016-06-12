package com.zouliangyu.lol.fragment.more;

import android.content.Intent;
import android.view.View;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.MoreFightActivity;
import com.zouliangyu.lol.activity.MoreImageActivity;
import com.zouliangyu.lol.activity.MoreNovelActivity;
import com.zouliangyu.lol.activity.MoreRingActivity;
import com.zouliangyu.lol.activity.MoreTopicActivity;
import com.zouliangyu.lol.base.BaseFragment;

/**
 * Created by zouliangyu on 16/5/9.
 * <p/>
 * 更多
 */
public class MoreFragment extends BaseFragment implements View.OnClickListener {
    private int[] ids = {R.id.more_check_tv, R.id.more_novel_tv, R.id.more_ring_tv,
            R.id.more_img_tv, R.id.more_topic_tv};

    @Override
    public int initLayout() {
        return R.layout.fragment_more;
    }

    @Override
    public void initView() {
        // 初始化
        for (int i = 0; i < ids.length; i++) {
            getView().findViewById(ids[i]).setOnClickListener(this);
        }

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.more_check_tv:
                // 跳到查询战斗力界面
                Intent intent = new Intent(mContext, MoreFightActivity.class);
                startActivity(intent);
                break;
            case R.id.more_topic_tv:
                // 跳转精彩专栏详情
                Intent intentTopic = new Intent(mContext, MoreTopicActivity.class);
                startActivity(intentTopic);
                break;
            case R.id.more_novel_tv:
                // 跳转到小说详情
                Intent intentNovel = new Intent(mContext, MoreNovelActivity.class);
                startActivity(intentNovel);
                break;
            case R.id.more_ring_tv:
                // 跳到铃声详情
                Intent intentRing = new Intent(mContext, MoreRingActivity.class);
                startActivity(intentRing);
                break;
            case R.id.more_img_tv:
                // 跳转到壁纸详情
                Intent intentImage = new Intent(mContext, MoreImageActivity.class);
                startActivity(intentImage);
                break;

        }
    }
}
