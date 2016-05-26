package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.MyCollectDetailsAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.greendao.Article;
import com.zouliangyu.lol.greendao.ArticleDao;
import com.zouliangyu.lol.greendao.GreendaoSingle;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/26.
 * 收藏的详情
 */
public class MyCollectDetailsActivity extends BaseActivity {
    private ListView listView;
    private ArticleDao articleDao;
    private MyCollectDetailsAdapter myCollectDetailsAdapter;
    private ImageView exitIv;
    private TextView titleTv;

    @Override
    protected int getLayout() {
        return R.layout.activity_my_collect_details;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.my_collect_lv);
        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        titleTv = (TextView) findViewById(R.id.title_tv);
        exitIv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


    }

    @Override
    protected void initData() {
        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("我收藏的文章");
        titleTv.setTextColor(Color.WHITE);

        myCollectDetailsAdapter = new MyCollectDetailsAdapter(this);
        articleDao = GreendaoSingle.getInstance().getArticleDao();
        List<Article> articles = articleDao.queryBuilder().list();
        myCollectDetailsAdapter.setArticles(articles);


        listView.setAdapter(myCollectDetailsAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

            }
        });


    }
}
