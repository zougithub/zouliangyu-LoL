package com.zouliangyu.lol.fragment.hero;

import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.View;
import android.widget.RadioButton;

import com.zouliangyu.lol.R;
import com.zouliangyu.lol.base.BaseFragment;

/**
 * Created by zouliangyu on 16/5/10.
 */
public class HeroFreeOrDiscountFragment extends BaseFragment implements View.OnClickListener {
    private RadioButton freeRb;
    private RadioButton discountRb;

    @Override
    public int initLayout() {
        return R.layout.fragment_hero_free_or_discount;
    }

    @Override
    public void initView() {
        freeRb = (RadioButton) getView().findViewById(R.id.hero_free_rb);
        discountRb = (RadioButton) getView().findViewById(R.id.hero_discount_rb);
        freeRb.setOnClickListener(this);
        discountRb.setOnClickListener(this);


        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        transaction.replace(R.id.hero_free_or_discount_replace, new HeroFreeFragment());
        transaction.commit();

    }

    @Override
    public void initData() {


    }

    @Override
    public void onClick(View v) {
        FragmentManager manager = getChildFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (v.getId()) {
            case R.id.hero_free_rb:
                transaction.replace(R.id.hero_free_or_discount_replace, new HeroFreeFragment());
                break;
            case R.id.hero_discount_rb:
                transaction.replace(R.id.hero_free_or_discount_replace, new HeroDiscountFragment());
                break;
        }
        transaction.commit();
    }
}
