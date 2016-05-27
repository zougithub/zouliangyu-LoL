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
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.InformationBannerDetailsAty;
import com.zouliangyu.lol.activity.InformationItemDetailsAty;
import com.zouliangyu.lol.adapter.InformationAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.adapter.InformationBannerPagerAdapter;
import com.zouliangyu.lol.base.GsonRequest;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.AllHeroBean;
import com.zouliangyu.lol.bean.BannerBean;
import com.zouliangyu.lol.bean.InformationNewestBean;
import com.zouliangyu.lol.util.SwipeRefreshLoadingLayout;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import it.sephiroth.android.library.picasso.Picasso;

/**
 * Created by zouliangyu on 16/5/9.
 * 资讯  最新界面
 */
public class InformationNewestFragment extends BaseFragment {
    private ViewPager mViewPager; // 轮播图
    private List<ImageView> mList;  // 图片集合
    private LinearLayout mLinearLayout; // 轮播图下面圆圈
    int i = 1;

    private ListView listView;
    private PullToRefreshListView pullToRefreshListView;

    private InformationBannerPagerAdapter informationBannerPagerAdapter; // 轮播图的
    private BannerListener bannerListener;

    // 圆圈标志位
    private int pointIndex = 0;
    // 线程标志
    private boolean isStop = false;


    private InformationAdapter informationAdapter; // 轮播图下面数据适配器
    private InformationNewestBean informationNewestBean;
    private String[] urls;

    private String id; // information里四个Fragment轮播图下面的数据网址

    public InformationNewestFragment(String id) {
        this.id = id;
    }

    private BannerBean bannerBean;

    @Override
    public int initLayout() {
        return R.layout.fragment_information_newest;
    }

    @Override
    public void initView() {
        pullToRefreshListView = bindView(R.id.information_newest_lv);
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH); // 设置上拉下拉事件
        //pullToRefreshListView = (PullToRefreshListView) getView().findViewById(R.id.information_newest_lv);

    }

    @Override
    public void initData() {
        listView = pullToRefreshListView.getRefreshableView();
        // 头布局,轮播图
        View headerView = getLayoutInflater(null).inflate(R.layout.banner, null);
        mViewPager = (ViewPager) headerView.findViewById(R.id.viewpager);
        mLinearLayout = (LinearLayout) headerView.findViewById(R.id.points);
        listView.addHeaderView(headerView);
        informationAdapter = new InformationAdapter(getContext());


        // 轮播图下面的数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/ItemsService/lists?cattype=news&catid=" + id + "&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438745347&p_=18386&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol",
                new Response.Listener<InformationNewestBean>() {
                    @Override
                    public void onResponse(InformationNewestBean response) {
                        informationNewestBean = response;
                        informationAdapter.setInformationNewestBeanList(response);
                        // 轮播图下数据 每行的监听
                        pullToRefreshListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
                            @Override
                            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                                String ids = informationNewestBean.getData().get(position - 2).getId();
                                String title = informationNewestBean.getData().get(position - 2).getTitle();
                                String desc = informationNewestBean.getData().get(position - 2).getDesc();
                                int time = informationNewestBean.getData().get(position - 2).getPublished();

                                Intent intent = new Intent(getContext(), InformationItemDetailsAty.class);
                                intent.putExtra("ids", ids);
                                intent.putExtra("title", title);
                                intent.putExtra("desc", desc);
                                Date date = new Date(time);
                                SimpleDateFormat simpleDateFormat = new SimpleDateFormat("HH:mm:ss");
                                String times = simpleDateFormat.format(date);

                                intent.putExtra("times", times);


                                startActivity(intent);
                            }
                        });


                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, InformationNewestBean.class);


        // 获取轮播图图片
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/ItemsService/ads?&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438744725&p_=16520&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol",
                new Response.Listener<BannerBean>() {
                    @Override
                    public void onResponse(BannerBean response) {
                        bannerBean = response;
                        addBanner(bannerBean);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, BannerBean.class);


        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/ItemsService/lists?cattype=news&catid=" + id + "&page=1&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438745347&p_=18386&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol",
                        new Response.Listener<InformationNewestBean>() {
                            @Override
                            public void onResponse(InformationNewestBean response) {
                                informationAdapter.setInformationNewestBeanList(response);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, InformationNewestBean.class);

                pullToRefreshListView.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pullToRefreshListView.onRefreshComplete();
                    }
                }, 1000);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                i++;
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/ItemsService/lists?cattype=news&catid=" + id + "&page=" + i + "&i_=EAC1B788-00BC-454A-A9B9-460852CFC011&t_=1438745347&p_=18386&v_=40050303&d_=ios&osv_=8.3&version=0&a_=lol",
                        new Response.Listener<InformationNewestBean>() {
                            @Override
                            public void onResponse(InformationNewestBean response) {
                                informationNewestBean.getData().addAll(response.getData());
                                informationAdapter.setInformationNewestBeanList(informationNewestBean);
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, InformationNewestBean.class);
            }
        });
        pullToRefreshListView.setAdapter(informationAdapter);


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


        // 图片的网址
        urls = new String[]{bannerBean.getData().get(0).getPic_ad_url(),
                bannerBean.getData().get(1).getPic_ad_url(),
                bannerBean.getData().get(2).getPic_ad_url()};


        for (int i = 0; i < urls.length; i++) {
            // 设置轮播图
            final ImageView imageView = new ImageView(mContext);
            imageView.setLayoutParams(new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                    LinearLayout.LayoutParams.MATCH_PARENT));
            Picasso.with(getContext()).load(urls[i]).
                    placeholder(R.mipmap.ic_launcher).error(R.mipmap.ic_launcher).into(imageView);
            imageView.setScaleType(ImageView.ScaleType.FIT_XY);
            mList.add(imageView);

            // 轮播图的监听
            imageView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    Intent intent1 = new Intent(getContext(), InformationBannerDetailsAty.class);
                    // 轮播图的id传到 详情页
                    String[] ids = {bannerBean.getData().get(0).getGoto_param().getItemid(),
                            bannerBean.getData().get(1).getGoto_param().getItemid(),
                            bannerBean.getData().get(2).getGoto_param().getItemid()};

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
