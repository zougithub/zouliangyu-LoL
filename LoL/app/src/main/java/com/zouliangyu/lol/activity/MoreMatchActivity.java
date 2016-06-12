package com.zouliangyu.lol.activity;

import android.graphics.Color;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.PopupWindow;
import android.widget.RadioButton;
import android.widget.TextView;
import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseActivity;
import com.zouliangyu.lol.fragment.more.morematch.MatchNewsFragment;
import com.zouliangyu.lol.fragment.more.morematch.MatchResultsFragment;

/**
 * Created by zouliangyu on 16/5/22.
 *
 */
public class MoreMatchActivity extends BaseActivity implements View.OnClickListener {
    private RadioButton matchRb;
    private RadioButton newsRb;
    private ImageView leftIv;
    private TextView titleTv;
    private PopupWindow popupWindow;

    @Override
    protected int getLayout() {
        return R.layout.activity_more_match;
    }

    @Override
    protected void initView() {
        matchRb = (RadioButton) findViewById(R.id.match_results_rb);
        newsRb = (RadioButton) findViewById(R.id.important_news_rb);
        matchRb.setOnClickListener(this);
        newsRb.setOnClickListener(this);
        leftIv = (ImageView) findViewById(R.id.title_left_iv);
        leftIv.setOnClickListener(this);
        titleTv = (TextView) findViewById(R.id.title_tv);
        titleTv.setOnClickListener(this);

    }

    @Override
    protected void initData() {

        leftIv.setImageResource(R.mipmap.global_back_d);
        titleTv.setText("全部比赛");
        titleTv.setTextColor(Color.WHITE);


        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.match_replace, new MatchResultsFragment());
        transaction.commit();


        popupWindow = new PopupWindow(ViewGroup.LayoutParams.MATCH_PARENT, ViewGroup.LayoutParams.WRAP_CONTENT);
        View view = LayoutInflater.from(this).inflate(R.layout.more_match_popup, null);
        popupWindow.setContentView(view);

    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();

        switch (v.getId()) {
            case R.id.match_results_rb:
                transaction.replace(R.id.match_replace, new MatchResultsFragment());
                break;
            case R.id.important_news_rb:
                transaction.replace(R.id.match_replace, new MatchNewsFragment());
                break;
            case R.id.title_left_iv:
                finish();
                break;
            case R.id.title_tv:
                if (!popupWindow.isShowing()){
                    popupWindow.showAsDropDown(titleTv);
                } else {
                    popupWindow.dismiss();
                }
                break;
        }
        transaction.commit();

    }
}
