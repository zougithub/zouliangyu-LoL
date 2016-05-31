package com.zouliangyu.lol.fragment.hero;

import android.content.Intent;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.activity.HeroDetailsActivity;
import com.zouliangyu.lol.adapter.MyHeroAdapter;
import com.zouliangyu.lol.base.BaseFragment;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.MyHeroBean;

/**
 * Created by zouliangyu on 16/5/10.
 * <p>
 * 我的英雄界面
 */
public class HeroMyHeroFragment extends BaseFragment {
    private TextView areaTv;
    private ListView listView;
    private MyHeroAdapter myHeroAdapter;

    private MyHeroBean myHeroBean;

    @Override
    public int initLayout() {
        return R.layout.fragment_hero_myhero;
    }

    @Override
    public void initView() {
        areaTv = (TextView) getView().findViewById(R.id.myhero_area_tv);
        listView = (ListView) getView().findViewById(R.id.myhero_listview);

    }

    @Override
    public void initData() {
        myHeroAdapter = new MyHeroAdapter(getContext());

        VolleySingle.addRequest("http://lolbox.duowan.com/phone/apiMyHeroes.php?target=青春如此疯狂禹&OSType=iOS9.3.1&serverName=网通二&v=180%20HTTP/1.1",
                new Response.Listener<MyHeroBean>() {
                    @Override
                    public void onResponse(MyHeroBean response) {
                        myHeroBean = response;
                        myHeroAdapter.setMyHeroBean(response);
                        areaTv.setText(response.getServerName());
                    }
                }, new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {

                    }
                }, MyHeroBean.class);


        listView.setAdapter(myHeroAdapter);

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                String enName = myHeroBean.getMyHeroes().get(position).getEnName();
                Intent intent = new Intent(mContext, HeroDetailsActivity.class);
                intent.putExtra("enName", enName);
                startActivity(intent);
            }
        });

    }
}
