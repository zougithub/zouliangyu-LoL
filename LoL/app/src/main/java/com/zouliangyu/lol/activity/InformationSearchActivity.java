package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.adapter.InformationSearchAdapter;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.base.VolleySingle;
import com.zouliangyu.lol.bean.SearchBean;

/**
 * Created by zouliangyu on 16/5/24.
 * 搜索栏
 */
public class InformationSearchActivity extends BaseActivity implements View.OnClickListener {
    private ListView listView;
    // 标题
    private ImageView exitIv;
    private TextView titleTv;
    // 搜索框
    private Button searchBtn;
    private EditText input;
    private ImageView imageView;

    private InformationSearchAdapter informationSearchAdapter;
    private String text;


    @Override
    protected int getLayout() {
        return R.layout.activity_information_search;
    }

    @Override
    protected void initView() {
        listView = (ListView) findViewById(R.id.search_lv);
        // 初始化标题
        exitIv = (ImageView) findViewById(R.id.title_left_iv);
        exitIv.setOnClickListener(this);
        titleTv = (TextView) findViewById(R.id.title_tv);
        // 输入的内容
        input = (EditText) findViewById(R.id.search_et);
        // EditText内容改变监听
        input.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                if (input.getText().toString().length() > 0) {
                    imageView.setVisibility(View.VISIBLE);
                } else {
                    imageView.setVisibility(View.INVISIBLE);
                }

            }

            @Override
            public void afterTextChanged(Editable s) {
            }
        });

        // 搜索
        searchBtn = (Button) findViewById(R.id.search_btn);
        searchBtn.setOnClickListener(this);
        // 输入内容后显示的删除
        imageView = (ImageView) findViewById(R.id.del_iv);
        imageView.setOnClickListener(this);
    }

    @Override
    protected void initData() {
        // 设置标题栏
        exitIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("搜索");
        titleTv.setTextColor(Color.WHITE);

        informationSearchAdapter = new InformationSearchAdapter(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.title_left_iv:
                finish();
                break;
            case R.id.search_btn:
                // 德玛西亚 亚索
                text = input.getText().toString();
                if (text.isEmpty()) {
                    Toast.makeText(this, "关键字不能为空", Toast.LENGTH_SHORT).show();
                } else {
                    String url = "http://lol.zhangyoubao.com/apis/rest/SearchService/item?keyword=" + text + "&page=1&i_=600BEB19-A58C-436C-9E3C-12E0581B0BEA&t_=1465213148&p_=11789&v_=40080102&d_=ios&osv_=9.3.1&version=0&a_=lol%20HTTP/1.1";
                    VolleySingle.addRequest(url, new Response.Listener<SearchBean>() {
                        @Override
                        public void onResponse(SearchBean response) {
                            informationSearchAdapter.setSearchBean(response);
                            listView.setAdapter(informationSearchAdapter);
                            input.setText("");
                            imageView.setVisibility(View.INVISIBLE);
                        }
                    }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                        }
                    }, SearchBean.class);
                }

                break;
            case R.id.del_iv:
                input.setText("");
                imageView.setVisibility(View.INVISIBLE);
                break;

        }
    }
}
