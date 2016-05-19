package com.zouliangyu.lol.activity;

import android.content.Intent;
import android.graphics.Color;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.VideoPlayAdapter;
import com.zouliangyu.lol.adapter.VideoPlayNewestDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.GsonRequest;
import com.zouliangyu.lol.bean.VideoBean;
import com.zouliangyu.lol.bean.VideoPlayNewestDetailsBean;
import com.zouliangyu.lol.fragment.video.VideoFragment;
import com.zouliangyu.lol.fragment.video.VideoPlayFragment;

import org.w3c.dom.Text;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/14.
 */
public class VideoDetailsAty extends BaseActivity implements View.OnClickListener {
    private TextView titleTv;
    private ImageView exitIv;

    private ListView listView;
    private VideoPlayNewestDetailsAdapter videoPlayNewestDetailsAdapter;

    private ImageView imageView;
    private TextView nameTv;
    private TextView descTv;

    private int position;
    private int pos;

    private VideoPlayNewestDetailsBean videoPlayNewestDetailsBean = new VideoPlayNewestDetailsBean();


    @Override
    protected int getLayout() {
        return R.layout.aty_video_details;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.video_details_lv);

        titleTv = (TextView) findViewById(R.id.video_details_title);
        exitIv = (ImageView) findViewById(R.id.video_details_exit);
        exitIv.setOnClickListener(this);


    }

    @Override
    protected void initData() {


        View headerView = getLayoutInflater().inflate(R.layout.video_details_header, null);
        imageView = (ImageView) headerView.findViewById(R.id.video_item_details_iv);
        nameTv = (TextView) headerView.findViewById(R.id.video_item_details_name);
        descTv = (TextView) headerView.findViewById(R.id.video_item_details_desc);


        listView.addHeaderView(headerView);

        Intent intent = getIntent();

        String ids = intent.getStringExtra("ids");
        pos = intent.getIntExtra("pos", pos);
        position = intent.getIntExtra("position", position);
        String name = intent.getStringExtra("name");
        String desc = intent.getStringExtra("desc");
        String img = intent.getStringExtra("img");

        titleTv.setText(name);
        titleTv.setTextColor(Color.WHITE);

        Picasso.with(this).load(img).error(R.mipmap.ic_launcher).placeholder(R.mipmap.ic_launcher).into(imageView);
        nameTv.setText(name);
        descTv.setText(desc);


        String url = "http://lol.zhangyoubao.com/apis/rest/ItemsService/videos?catwordid=" + ids + "&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438760575&p_=4070&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol";


        final RequestQueue requestQueue = Volley.newRequestQueue(this);
        // 视频详情页, 获取listview数据
        GsonRequest<VideoPlayNewestDetailsBean> gsonRequest = new GsonRequest<>(Request.Method.GET, url
                , new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {

            }
        }, new Response.Listener<VideoPlayNewestDetailsBean>() {
            @Override
            public void onResponse(VideoPlayNewestDetailsBean response) {

                videoPlayNewestDetailsBean = response;
                videoPlayNewestDetailsAdapter.setVideoPlayNewestDetailsBeans(response);


            }
        }, VideoPlayNewestDetailsBean.class);

        requestQueue.add(gsonRequest);

        videoPlayNewestDetailsAdapter = new VideoPlayNewestDetailsAdapter(this);
        listView.setAdapter(videoPlayNewestDetailsAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent intent = new Intent(VideoDetailsAty.this, VideoDetailsItemDetailsAty.class);
                Log.d("VideoDetailsAty", videoPlayNewestDetailsBean.getData().get(position - 1).getTitle());
                String ids = videoPlayNewestDetailsBean.getData().get(position - 1).getItem_id();
                intent.putExtra("ids", ids);
                startActivity(intent);
                Log.d("VideoDetailsAty", ids);
            }
        });

    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.video_details_exit:
                finish();
                break;
        }
    }
}
