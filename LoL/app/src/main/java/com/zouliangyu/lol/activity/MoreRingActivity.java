package com.zouliangyu.lol.activity;

import android.media.MediaPlayer;
import android.net.Uri;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.MoreRingAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreRingBean;

/**
 * Created by zouliangyu on 16/5/20.
 * 铃声
 */
public class MoreRingActivity extends BaseActivity {
    private ListView listView;
    private MoreRingAdapter moreRingAdapter;
    private MoreRingBean moreRingBean = new MoreRingBean();

    private MediaPlayer mediaPlayer;
    private String url;
    private ImageView leftIv;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_more_ring;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.ring_listview);
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        leftIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void initData() {
        titleTv.setText("铃声");

        leftIv.setImageResource(R.mipmap.global_back_d);

        moreRingAdapter = new MoreRingAdapter(this);

        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/AroundService/ring?page=1&i_=869765028748315&t_=1463627310419&p_=3602&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&",
                new Response.Listener<MoreRingBean>() {
                    @Override
                    public void onResponse(MoreRingBean response) {
                        moreRingBean = response;
                        moreRingAdapter.setMoreRingBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, MoreRingBean.class);

        listView.setAdapter(moreRingAdapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                MoreRingAdapter.ViewHolder holder = (MoreRingAdapter.ViewHolder) view.getTag();

                url = moreRingBean.getData().get(position).getPath_url();
                Log.d("MoreRingActivity", url);
                mediaPlayer = MediaPlayer.create(MoreRingActivity.this, Uri.parse(url));

            }
        });


    }
}
