package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.TextView;
import android.widget.VideoView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.GsonRequest;
import com.zouliangyu.lol.bean.VideoDetailsItemDetailsBean;

/**
 * Created by zouliangyu on 16/5/18.
 */
public class VideoDetailsItemDetailsAty extends BaseActivity implements View.OnClickListener {

    private VideoView videoView;

    private VideoDetailsItemDetailsBean videoDetailsItemDetailsBean;

    private MediaController mediaController;


    private ImageView titleLeft;
    private TextView titleTv;
    private ImageView titleRight;
    private TextView title;

    @Override
    protected int getLayout() {
        return R.layout.aty_video_details_item_details;

//        this.setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
    }

    @Override
    protected void initView() {
        videoView = (VideoView) findViewById(R.id.videoview);
        titleLeft = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        titleRight = (ImageView) findViewById(R.id.title_right_iv);
        title = (TextView) findViewById(R.id.details_title_tv);

        titleLeft.setOnClickListener(this);
        titleRight.setOnClickListener(this);


    }

    @Override
    protected void initData() {
        Intent intent = getIntent();
        String ids = intent.getStringExtra("ids");

        // http://lol.zhangyoubao.com/apis/rest/ItemsService/videoInfo?itemid=65821&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438761089&p_=5612&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol
        String urls = "http://lol.zhangyoubao.com/apis/rest/ItemsService/videoInfo?itemid=" + ids + "&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438761089&p_=5612&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol";
        Log.d("11111111111", urls);


        mediaController = new MediaController(this);

        RequestQueue requestQueue = Volley.newRequestQueue(VideoDetailsItemDetailsAty.this);
        GsonRequest<VideoDetailsItemDetailsBean> gsonRequest = new GsonRequest<>(Request.Method.GET, urls,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("jiji", "jiji");
                    }
                }, new Response.Listener<VideoDetailsItemDetailsBean>() {
            @Override
            public void onResponse(VideoDetailsItemDetailsBean response) {
                videoDetailsItemDetailsBean = response;
                Log.d("123456", response.getData().getId());


                Log.d("VideoDetailsItemDetails", videoDetailsItemDetailsBean.getData().getId() + "");
                Log.d("VideoDetailsItemDetails", videoDetailsItemDetailsBean.getData().getFrom_url());
                Uri uri = Uri.parse(videoDetailsItemDetailsBean.getData().getSd_url());

                videoView.setMediaController(mediaController);

                videoView.setVideoURI(uri);
                videoView.requestFocus();
                Log.d("123", videoDetailsItemDetailsBean.getData().getTitle());


                titleLeft.setImageResource(R.mipmap.global_back_d);
                titleTv.setText("掌游宝");
                titleRight.setImageResource(R.mipmap.global_btn_more_d);
                title.setText(videoDetailsItemDetailsBean.getData().getTitle());

            }
        }, VideoDetailsItemDetailsBean.class);
        requestQueue.add(gsonRequest);


    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left_iv:
                finish();
                break;
            case R.id.title_right_iv:
                break;
        }

    }


//    @Override
//    protected void onStart() {
//
//        videoView.setVideoURI(uri);
//        videoView.start();
//        super.onStart();
//    }
//
//    @Override
//    protected void onPause() {
//        mPositionWhenPaused = videoView.getCurrentPosition();
//        videoView.stopPlayback();
//
//        super.onPause();
//    }
//
//    @Override
//    protected void onResume() {
//        if (mPositionWhenPaused >= 0) {
//            videoView.seekTo(mPositionWhenPaused);
//            mPositionWhenPaused = -1;
//        }
//        super.onResume();
//    }
//
//    public boolean onError(MediaPlayer player, int arg1, int arg2) {
//        return false;
//    }
//
//    public void onCompletion(MediaPlayer mp) {
//        this.finish();
//    }
}
