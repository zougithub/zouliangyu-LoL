package com.zouliangyu.lol.fragment.video;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseFragment;

/**
 * Created by zouliangyu on 16/5/10.
 */
public class VideoCommentatorFragment extends BaseFragment {
    private RecyclerView recyclerView;

    @Override
    public int initLayout() {
        return R.layout.fragment_video_play;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.video_play_rl);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

    }

    @Override
    public void initData() {

    }
}
