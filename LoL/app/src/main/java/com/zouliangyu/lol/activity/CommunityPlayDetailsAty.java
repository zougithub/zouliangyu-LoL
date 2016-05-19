package com.zouliangyu.lol.activity;

import android.widget.ListView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;

/**
 * Created by zouliangyu on 16/5/16.
 */
public class CommunityPlayDetailsAty extends BaseActivity {
    private ListView listView;

    @Override
    protected int getLayout() {
        return R.layout.item_community_play_details;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.community_play_details_lv);

    }

    @Override
    protected void initData() {

    }
}
