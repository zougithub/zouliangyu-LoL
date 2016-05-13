package com.zouliangyu.lol.fragment.video;

import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.VideoPlayAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.base.GsonRequest;
import com.zouliangyu.lol.bean.VideoBean;

/**
 * Created by zouliangyu on 16/5/10.
 */
public class VideoPlayFragment extends BaseFragment {
    private RecyclerView recyclerView;
    private VideoPlayAdapter videoPlayAdapter;

    @Override
    public int initLayout() {
        return R.layout.fragment_video_play;
    }

    @Override
    public void initView() {
        recyclerView = (RecyclerView) getView().findViewById(R.id.video_play_rl);

        recyclerView.setLayoutManager(new GridLayoutManager(getContext(),3));

    }

    @Override
    public void initData() {
        videoPlayAdapter = new VideoPlayAdapter(getContext());

        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        GsonRequest<VideoBean> gsonRequest = new GsonRequest<>(Request.Method.GET, "http://lol.zhangyoubao.com/apis/rest/CatalogsService/all?cattype=video&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438755336&p_=18353&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, new Response.Listener<VideoBean>() {
            @Override
            public void onResponse(VideoBean response) {
                videoPlayAdapter.setVideoBean(response);
                Log.d("VideoPlayFragment", response.getData().get(0).getCatword_id().get(0).getName());
            }
        }, VideoBean.class);
        requestQueue.add(gsonRequest);



        recyclerView.setAdapter(videoPlayAdapter);
    }

}
