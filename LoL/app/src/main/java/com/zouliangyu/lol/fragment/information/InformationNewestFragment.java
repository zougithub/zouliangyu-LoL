package com.zouliangyu.lol.fragment.information;

import android.app.Activity;
import android.content.Intent;
import android.os.SystemClock;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.Volley;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.InformationBannerDetailsAty;
import com.zouliangyu.lol.activity.InformationItemDetailsAty;
import com.zouliangyu.lol.adapter.InformationAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.adapter.InformationBannerPagerAdapter;
import com.zouliangyu.lol.base.GsonRequest;
import com.zouliangyu.lol.bean.BannerBean;
import com.zouliangyu.lol.bean.InformationNewestBean;
import com.zouliangyu.lol.util.SwipeRefreshLoadingLayout;

import java.util.ArrayList;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/9.
 */
public class InformationNewestFragment extends BaseFragment {
    private ViewPager mViewPager;
    private List<ImageView> mList;
    private LinearLayout mLinearLayout;

    private ListView listView;

    // 轮播图片
//    private int[] bannerImages = {R.mipmap.hongxiang1, R.mipmap.hongxiang2,
//            R.mipmap.hongxiang3, R.mipmap.anfeng};

    private InformationBannerPagerAdapter informationBannerPagerAdapter;
    private BannerListener bannerListener;

    // 圆圈标志位
    private int pointIndex = 0;

    // 线程标志
    private boolean isStop = false;

    private InformationAdapter informationAdapter;

    private InformationNewestBean informationNewestBean;
    private String[] urls;

    // information里四个Fragment轮播图下面的数据网址
    private String url;

    public InformationNewestFragment(String url) {
        this.url = url;
    }



    private SwipeRefreshLoadingLayout swipeRefreshLoadingLayout;




    @Override
    public int initLayout() {
        return R.layout.fragment_information_newest;
    }


    @Override
    public void initView() {
        listView = (ListView) getView().findViewById(R.id.information_newest_lv);
        swipeRefreshLoadingLayout = (SwipeRefreshLoadingLayout) getView().findViewById(R.id.refresh);

    }

    @Override
    public void initData() {

        View headerView = getLayoutInflater(null).inflate(R.layout.banner, null);
        mViewPager = (ViewPager) headerView.findViewById(R.id.viewpager);
        mLinearLayout = (LinearLayout) headerView.findViewById(R.id.points);
        listView.addHeaderView(headerView);
        informationAdapter = new InformationAdapter(getContext());


        RequestQueue requestQueue = Volley.newRequestQueue(getContext());
        // 轮播图下面的数据
        GsonRequest<InformationNewestBean> gsonRequest = new GsonRequest<>(Request.Method.GET,
                url,
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, new Response.Listener<InformationNewestBean>() {
            @Override
            public void onResponse(InformationNewestBean response) {

                informationAdapter.setInformationNewestBeanList(response);
                informationNewestBean = response;
                Log.d("InformationNewestFragment", informationNewestBean.getData().get(0).getTitle());
            }
        }, InformationNewestBean.class);
        requestQueue.add(gsonRequest);

        Log.d("InformationNewestFragme", "gsonRequest:" + gsonRequest);


        // 获取轮播图图片
        GsonRequest<BannerBean> gsonRequest1 = new GsonRequest<>(Request.Method.GET,
                "http://lol.zhangyoubao.com/apis/rest/ItemsService/ads?&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438744725&p_=16520&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol",
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                    }
                }, new Response.Listener<BannerBean>() {
            @Override
            public void onResponse(BannerBean response) {

                addBanner(response);


                Log.d("InformationNewestFragme", "bannerBean:" + response.getData().get(0).getTitle());


            }
        }, BannerBean.class);

        requestQueue.add(gsonRequest1);

        Log.d("InformationNewestFragme", "gsonRequest1:" + gsonRequest1);



        listView.setAdapter(informationAdapter);

        swipeRefreshLoadingLayout.setOnRefreshListener(new SwipeRefreshLoadingLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                listView.setAdapter(informationAdapter);
                swipeRefreshLoadingLayout.setRefreshing(false);
            }
        });
        swipeRefreshLoadingLayout.setOnLoadListener(new SwipeRefreshLoadingLayout.OnLoadListener() {
            @Override
            public void onLoad() {
                listView.setAdapter(informationAdapter);
                swipeRefreshLoadingLayout.setLoading(false);
            }
        });




        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.d("InformationNewestFragment", informationNewestBean.getData().get(position - 1).getId());
                String ids = informationNewestBean.getData().get(position - 1).getId();
                Intent intent = new Intent(getContext(), InformationItemDetailsAty.class);
                intent.putExtra("ids", ids);
                startActivity(intent);
            }
        });


        // 开启新线程, 5秒更新一次Banner
        new Thread(new Runnable() {
            @Override
            public void run() {
                Activity aty = (Activity) mContext;
                while (!isStop) {
                    SystemClock.sleep(5000);

                    aty.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            mViewPager.setCurrentItem(mViewPager.getCurrentItem() + 1);
                        }
                    });
                }

            }
        }).start();


    }

    private void addBanner(final BannerBean bannerBean) {

        mList = new ArrayList<>();

        LinearLayout.LayoutParams params;


        String a = bannerBean.getData().get(0).getPic_ad_url();
        String b = bannerBean.getData().get(1).getPic_ad_url();
        String c = bannerBean.getData().get(2).getPic_ad_url();
        String d = bannerBean.getData().get(3).getPic_ad_url();


        urls = new String[]{a, b, c, d};


        for (int i = 0; i < urls.length; i++) {
            // 设置轮播图
            final ImageView imageView = new ImageView(getContext());
            imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));


            Picasso.with(getContext()).load(urls[i]).
                    placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);


//            imageView.setBackgroundResource(bannerImages[i]);


            imageView.setScaleType(ImageView.ScaleType.FIT_XY);

            mList.add(imageView);

            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = imageView.getId();
                    Log.d("InformationNeqqqwestFragme", "id:" + id);
                    Intent intent1 = new Intent(getContext(), InformationBannerDetailsAty.class);
                    String[] ids = {bannerBean.getData().get(0).getGoto_param().getItemid(),
                            bannerBean.getData().get(1).getGoto_param().getItemid(),
                            bannerBean.getData().get(2).getGoto_param().getItemid(),
                            bannerBean.getData().get(3).getGoto_param().getItemid()};

                    Log.d("111111111", bannerBean.getData().get(0).getGoto_param().getItemid());
                    Log.d("111111111", bannerBean.getData().get(1).getGoto_param().getItemid());
                    Log.d("111111111", bannerBean.getData().get(2).getGoto_param().getItemid());
                    Log.d("111111111", bannerBean.getData().get(3).getGoto_param().getItemid());


                    Log.d("InformationNe24345westFragme", "ids:" + ids);
                    intent1.putExtra("ids", ids[pointIndex]);
                    startActivity(intent1);
                }
            });


            // 设置圆圈点
            View view = new View(getContext());

            params = new LinearLayout.LayoutParams(10, 10);
            params.leftMargin = 10;
            view.setBackgroundResource(R.drawable.point_selector);
            view.setLayoutParams(params);
            view.setEnabled(false);
            mLinearLayout.addView(view);
        }


        bannerListener = new BannerListener();
        mViewPager.setOnPageChangeListener(bannerListener);
        // 取中间数来作为起始位置
        int index = (Integer.MAX_VALUE / 2) - (Integer.MAX_VALUE / 2 % mList.size());
        // 用来触发监听器
        mViewPager.setCurrentItem(index);
        mLinearLayout.getChildAt(pointIndex).setEnabled(true);


        informationBannerPagerAdapter = new InformationBannerPagerAdapter(mList);
        mViewPager.setAdapter(informationBannerPagerAdapter);


    }


    class BannerListener implements ViewPager.OnPageChangeListener {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
        }

        @Override
        public void onPageSelected(int position) {
            int newPosition = position % urls.length;
            mLinearLayout.getChildAt(newPosition).setEnabled(true);
            mLinearLayout.getChildAt(pointIndex).setEnabled(false);
            // 更新标志位
            pointIndex = newPosition;
        }

        @Override
        public void onPageScrollStateChanged(int state) {
        }
    }


    @Override
    public void onDestroy() {
        // 关闭定时器
        isStop = true;
        super.onDestroy();
    }
}
