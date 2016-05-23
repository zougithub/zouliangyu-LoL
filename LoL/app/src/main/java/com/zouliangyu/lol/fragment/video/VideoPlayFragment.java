package com.zouliangyu.lol.fragment.video;

import android.content.Intent;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.VideoDetailsAty;
import com.zouliangyu.lol.adapter.VideoPlayAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.base.GsonRequest;
import com.zouliangyu.lol.bean.VideoBean;

/**
 * Created by zouliangyu on 16/5/10.
 *
 * 视频的tab
 */
public class VideoPlayFragment extends BaseFragment implements VideoPlayAdapter.MyItemClickListener {
    private RecyclerView recyclerView;
    private VideoPlayAdapter videoPlayAdapter;
    private VideoBean videoBean;


    // data下的 娱乐 解说 赛事 的位置
    private int pos;

    public VideoPlayFragment(int pos) {
        this.pos = pos;
    }


    @Override
    public int initLayout() {
        return R.layout.fragment_video_play;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.video_play_rl);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 3));

//        recyclerView.setItemAnimator(new DefaultItemAnimator());
    }

    @Override
    public void initData() {
        videoPlayAdapter = new VideoPlayAdapter(getContext(), pos);


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        // 获取视频三个页面的数据
        GsonRequest<VideoBean> gsonRequest = new GsonRequest<>(Request.Method.GET, "http://lol.zhangyoubao.com/apis/rest/CatalogsService/all?cattype=video&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438755336&p_=18353&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<VideoBean>() {
            @Override
            public void onResponse(VideoBean response) {
                videoBean = response;
                videoPlayAdapter.setVideoBean(response);
                Log.d("VideoPlayFragment", response.getData().get(pos).getCatword_id().get(0).getName());
//                videoDetailsAty.setVideoBean(response);
            }
        }, VideoBean.class);
        requestQueue.add(gsonRequest);

        recyclerView.setAdapter(videoPlayAdapter);

        videoPlayAdapter.setOnItemClickListener(this);



    }


    @Override
    public void onItemClickListener(View view, int position) {
        Toast.makeText(mContext, "videoBean.getData().get(position):" + videoBean.getData().get(0).getCatword_id().get(position).getName(), Toast.LENGTH_SHORT).show();
        Log.d("VideoPlayFragment", "videoBean.getData().get(0).getCatword_id():" + videoBean.getData().get(0).getId());


        String ids = videoBean.getData().get(pos).getCatword_id().get(position).getId();
        String name = videoBean.getData().get(pos).getCatword_id().get(position).getName();
        String desc = videoBean.getData().get(pos).getCatword_id().get(position).getDesc();
        String img = videoBean.getData().get(pos).getCatword_id().get(position).getPic_url();


        Intent intent = new Intent(getContext(), VideoDetailsAty.class);
        intent.putExtra("ids", ids);
        intent.putExtra("name", name);
        intent.putExtra("desc", desc);
        intent.putExtra("img", img);


        intent.putExtra("pos",pos);
        intent.putExtra("position", position);


        Log.d("VideoPlayFragment", "position:" + position);

        startActivity(intent);

    }
}
