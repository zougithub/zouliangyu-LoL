package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.handmark.pulltorefresh.library.PullToRefreshBase;
import com.handmark.pulltorefresh.library.PullToRefreshListView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.CommunityShowDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.CommunityShowBean;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by zouliangyu on 16/5/19.
 * 社区  真人秀 详情
 */
public class CommunityShowDetailsAty extends BaseActivity implements View.OnClickListener {
    // 标题
    private TextView titleTv;
    private ImageView leftIv;
    // 全部大区 筛选
    private RadioButton areaRb;

    private PullToRefreshListView pullToRefreshListView;
    private CommunityShowDetailsAdapter communityShowDetailsAdapter;
    // popup 筛选
    private PopupWindow popupWindow;
    private TextView areaAll;
    private TextView areaOne;
    private TextView areaTwo;
    private TextView areaThree;
    private TextView areaFour;
    private TextView areaFive;
    private TextView areaSix;
    // 数据类
    private CommunityShowBean communityShowBean;
    // 存放满足条件的数据的集合
    private List<CommunityShowBean.DataBean> dataBeans;
    int i = 1;

    private View view;

    @Override
    protected int getLayout() {
        return R.layout.aty_community_show_details;
    }

    @Override
    protected void initView() {
        pullToRefreshListView = (PullToRefreshListView) findViewById(R.id.community_show_lv);
        // 标题
        titleTv = (TextView) findViewById(R.id.title_tv);
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        leftIv.setOnClickListener(this);
        // 全部大区
        areaRb = (RadioButton) findViewById(R.id.show_area_rb);
        areaRb.setOnClickListener(this);
    }

    @Override
    protected void initData() {
<<<<<<< HEAD
        // 设置标题栏
        titleTv.setText("真人秀");
        titleTv.setTextColor(Color.WHITE);
        leftIv.setImageResource(R.mipmap.global_back_d);
        // 筛选大区
=======


        titleTv.setText("真人秀");
        titleTv.setTextColor(Color.WHITE);
        leftIv.setImageResource(R.mipmap.global_back_d);

>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
        areaRb.setTextColor(Color.WHITE);

        communityShowDetailsAdapter = new CommunityShowDetailsAdapter(this);

        // 设置上拉下拉事件
        pullToRefreshListView.setMode(PullToRefreshBase.Mode.BOTH);

        // 获取数据
        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<CommunityShowBean>() {
                    @Override
                    public void onResponse(CommunityShowBean response) {
                        communityShowBean = response;
                        dataBeans = new ArrayList<>();
                        for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                            dataBeans.add(dataBean);
                        }
                        communityShowDetailsAdapter.setDataBeans(dataBeans);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, CommunityShowBean.class);


        // 全部大区
        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        view = LayoutInflater.from(this).inflate(R.layout.community_show_area_popup, null);
        areaAll = (TextView) view.findViewById(R.id.area_all);
        areaOne = (TextView) view.findViewById(R.id.area_one);
        areaTwo = (TextView) view.findViewById(R.id.area_two);
        areaThree = (TextView) view.findViewById(R.id.area_three);
        areaFour = (TextView) view.findViewById(R.id.area_four);
        areaFive = (TextView) view.findViewById(R.id.area_five);
        areaSix = (TextView) view.findViewById(R.id.area_six);
        areaAll.setOnClickListener(this);
        areaOne.setOnClickListener(this);
        areaTwo.setOnClickListener(this);
        areaThree.setOnClickListener(this);
        areaFour.setOnClickListener(this);
        areaFive.setOnClickListener(this);
        areaSix.setOnClickListener(this);

<<<<<<< HEAD
        // 上拉加载, 下拉刷新
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
            // 下拉
=======

        // 上拉加载, 下拉刷新
        pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
            @Override
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityShowBean>() {
                            @Override
                            public void onResponse(CommunityShowBean response) {
                                communityShowBean = response;
                                dataBeans = new ArrayList<>();
                                for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
<<<<<<< HEAD
                                    if (areaRb.getText().equals("全部大区")) {
                                        dataBeans.add(dataBean);
                                    }
                                    if (dataBean.getArea().equals(areaRb.getText())) {
                                        dataBeans.add(dataBean);
                                    }
                                    if (dataBean.getArea().equals(areaRb.getText())) {
                                        dataBeans.add(dataBean);
                                    }


                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);
                                // 刷新成功后 ,停止刷新
=======
                                    dataBeans.add(dataBean);
                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);
                                // 刷新成功后 ,停止刷新
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityShowBean.class);
            }

            @Override
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                i++;
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=" + i + "&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityShowBean>() {
                            @Override
                            public void onResponse(CommunityShowBean response) {
//                                communityShowBean = response;
                                communityShowBean.getData().addAll(response.getData());
                                dataBeans = new ArrayList<>();
                                for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                    dataBeans.add(dataBean);
                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);
>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityShowBean.class);
            }
<<<<<<< HEAD

            @Override
            // 上拉
            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                i++;
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=" + i + "&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityShowBean>() {
                            @Override
                            public void onResponse(CommunityShowBean response) {
                                communityShowBean.getData().addAll(response.getData());
                                dataBeans = new ArrayList<>();
                                for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                    if (areaRb.getText().toString().equals("全部大区")) {
                                        dataBeans.add(dataBean);
                                    }
                                    if (dataBean.getArea().equals(areaRb.getText())) {
                                        dataBeans.add(dataBean);
                                    }
                                    if (dataBean.getArea().equals(areaRb.getText())) {
                                        dataBeans.add(dataBean);
                                    }

                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);
                                // 上拉完成, 停止刷新
                                pullToRefreshListView.onRefreshComplete();
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityShowBean.class);
            }
        });
        popupWindow.setContentView(view);

        pullToRefreshListView.setAdapter(communityShowDetailsAdapter);
=======
        });
        popupWindow.setContentView(view);
        pullToRefreshListView.setAdapter(communityShowDetailsAdapter);


>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left_iv:
                finish();
                break;
            case R.id.show_area_rb:
                if (!popupWindow.isShowing()) {
                    popupWindow.showAsDropDown(areaRb);
                } else {
                    popupWindow.dismiss();
                }
                break;
            // 全部大区, 重新获取数据
            case R.id.area_all:
                areaRb.setText(areaAll.getText());
                popupWindow.dismiss();
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityShowBean>() {
                            @Override
                            public void onResponse(CommunityShowBean response) {
                                communityShowBean = response;
                                dataBeans = new ArrayList<>();
                                for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                    dataBeans.add(dataBean);
                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityShowBean.class);

                break;
            //  一区
            case R.id.area_one:
                areaRb.setText(areaOne.getText());
                popupWindow.dismiss();
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityShowBean>() {
                            @Override
                            public void onResponse(CommunityShowBean response) {
                                communityShowBean = response;
                                dataBeans = new ArrayList<>();
                                for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                    if (dataBean.getArea().toString().
                                            equals(areaOne.getText().toString())) {
                                        dataBeans.add(dataBean);
                                    }
                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);

                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityShowBean.class);
                break;
            // 祖安
            case R.id.area_two:
                areaRb.setText(areaTwo.getText());
                popupWindow.dismiss();
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityShowBean>() {
                            @Override
                            public void onResponse(CommunityShowBean response) {
                                communityShowBean = response;
                                dataBeans = new ArrayList<>();
                                for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                    if (dataBean.getArea().toString().equals(areaTwo.getText().toString())) {
                                        dataBeans.add(dataBean);
                                    }

                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityShowBean.class);

<<<<<<< HEAD
                break;
            case R.id.area_three:
                areaRb.setText(areaThree.getText());
                popupWindow.dismiss();
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityShowBean>() {
                            @Override
                            public void onResponse(CommunityShowBean response) {
                                communityShowBean = response;
                                dataBeans = new ArrayList<>();
                                for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                    if (dataBean.getArea().toString().equals(areaThree.getText().toString())) {
                                        dataBeans.add(dataBean);
                                    }

                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityShowBean.class);
                break;
            case R.id.area_four:
                areaRb.setText(areaFour.getText());
                popupWindow.dismiss();
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityShowBean>() {
                            @Override
                            public void onResponse(CommunityShowBean response) {
                                communityShowBean = response;
                                dataBeans = new ArrayList<>();
                                for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                    if (dataBean.getArea().toString().equals(areaFour.getText().toString())) {
                                        dataBeans.add(dataBean);
                                    }

                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityShowBean.class);
                break;
            case R.id.area_five:
                areaRb.setText(areaFive.getText());
                popupWindow.dismiss();
                VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                        new Response.Listener<CommunityShowBean>() {
                            @Override
                            public void onResponse(CommunityShowBean response) {
                                communityShowBean = response;
                                dataBeans = new ArrayList<>();
                                for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                    if (dataBean.getArea().toString().equals(areaFive.getText().toString())) {
                                        dataBeans.add(dataBean);
                                    }

                                }
                                communityShowDetailsAdapter.setDataBeans(dataBeans);
                            }
                        }, new Response.ErrorListener() {
                            @Override
                            public void onErrorResponse(VolleyError error) {

                            }
                        }, CommunityShowBean.class);
=======

                // 上拉加载, 下拉刷新
                pullToRefreshListView.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {
                    @Override
                    public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {
                        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=1&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                                new Response.Listener<CommunityShowBean>() {
                                    @Override
                                    public void onResponse(CommunityShowBean response) {
                                        communityShowBean = response;
                                        dataBeans = new ArrayList<>();
                                        for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                            if (dataBean.getArea().equals(areaTwo.getText())) {
                                                dataBeans.add(dataBean);
                                            }

                                        }
                                        communityShowDetailsAdapter.setDataBeans(dataBeans);
                                        // 刷新成功后 ,停止刷新
                                        pullToRefreshListView.onRefreshComplete();
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                }, CommunityShowBean.class);
                    }

                    @Override
                    public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {
                        i++;
                        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/UgcsService/getUserShows?area=&order_kind=0&sex=&page=" + i + "&i_=869765028748315&t_=1463625469422&p_=30611&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                                new Response.Listener<CommunityShowBean>() {
                                    @Override
                                    public void onResponse(CommunityShowBean response) {
                                        communityShowBean = response;
                                        dataBeans = new ArrayList<>();
                                        for (CommunityShowBean.DataBean dataBean : communityShowBean.getData()) {
                                            if (dataBean.getArea().equals(areaTwo.toString())) {
                                                dataBeans.add(dataBean);
                                            }

                                        }
                                        communityShowDetailsAdapter.setDataBeans(dataBeans);
                                        pullToRefreshListView.onRefreshComplete();
                                    }
                                }, new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {

                                    }
                                }, CommunityShowBean.class);
                    }
                });


>>>>>>> 946912944adbc1def3419ef8318c7545267f0068
                break;

        }
    }
}
