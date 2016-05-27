package com.zouliangyu.lol.fragment.community;

import android.content.Intent;
import android.view.View;
import android.widget.LinearLayout;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.CommunityFriendDetailsAty;
import com.zouliangyu.lol.activity.CommunityPlayDetailsAty;
import com.zouliangyu.lol.activity.CommunityShowDetailsAty;
import com.zouliangyu.lol.base.BaseFragment;

/**
 * Created by zouliangyu on 16/5/9.
 * <p>
 * 社区界面
 */
public class CommunityFragment extends BaseFragment implements View.OnClickListener {
    private LinearLayout contentOne;
    private LinearLayout contentTwo;
    private LinearLayout contentThree;

    @Override
    public int initLayout() {
        return R.layout.fragment_community;
    }

    @Override
    public void initView() {
        contentOne = (LinearLayout) getView().findViewById(R.id.community_content_one);
        contentTwo = (LinearLayout) getView().findViewById(R.id.community_content_two);
        contentThree = (LinearLayout) getView().findViewById(R.id.community_content_three);
        contentOne.setOnClickListener(this);
        contentTwo.setOnClickListener(this);
        contentThree.setOnClickListener(this);

    }

    @Override
    public void initData() {

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.community_content_one:
                Intent intent = new Intent(getContext(), CommunityShowDetailsAty.class);
                startActivity(intent);
                break;
            case R.id.community_content_two:
                Intent intent1 = new Intent(getContext(), CommunityPlayDetailsAty.class);
                startActivity(intent1);
                break;
            case R.id.community_content_three:
                // 跳到找战友界面
                Intent intentFriend = new Intent(getContext(), CommunityFriendDetailsAty.class);
                startActivity(intentFriend);
                break;


        }
    }
}
