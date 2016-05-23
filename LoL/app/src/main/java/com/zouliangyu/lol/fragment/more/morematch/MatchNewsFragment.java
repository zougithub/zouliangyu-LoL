package com.zouliangyu.lol.fragment.more.morematch;

import android.widget.ListView;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.MatchNewsAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MoreMatchNewsBean;

/**
 * Created by zouliangyu on 16/5/22.
 */
public class MatchNewsFragment extends BaseFragment {

    private ListView listView;
    private MatchNewsAdapter matchNewsAdapter;
    @Override
    public int initLayout() {
        return R.layout.fragment_match_news;
    }

    @Override
    public void initView() {
        listView = (ListView) getView().findViewById(R.id.more_match_news_listview);

    }

    @Override
    public void initData() {
        matchNewsAdapter = new MatchNewsAdapter(mContext);

        VolleySingle.addRequest("http://lol.zhangyoubao.com/apis/rest/competitions/items?maxid=0&cid=&i_=869765028748315&t_=1463626282349&p_=9392&v_=400801&a_=lol&pkg_=com.anzogame.lol&d_=android&osv_=22&cha=AppChina&u_=&modle_=vivo+Xplay5A&%20HTTP/1.1",
                new Response.Listener<MoreMatchNewsBean>() {
                    @Override
                    public void onResponse(MoreMatchNewsBean response) {
                        matchNewsAdapter.setMoreMatchNewsBean(response);
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, MoreMatchNewsBean.class);

        listView.setAdapter(matchNewsAdapter);

    }
}
