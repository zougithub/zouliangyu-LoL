package com.zouliangyu.lol.bean;

/**
 * Created by zouliangyu on 16/5/16.
 *
 * 英雄假数据
 */
public class HeroFreeFalseData {
    private int topIv;
    private String name;
    private String gold;
    private String coupon;

    public HeroFreeFalseData() {
    }

    public HeroFreeFalseData(int topIv, String name, String gold, String coupon) {
        this.topIv = topIv;
        this.name = name;
        this.gold = gold;
        this.coupon = coupon;
    }

    public int getTopIv() {
        return topIv;
    }

    public void setTopIv(int topIv) {
        this.topIv = topIv;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGold() {
        return gold;
    }

    public void setGold(String gold) {
        this.gold = gold;
    }

    public String getCoupon() {
        return coupon;
    }

    public void setCoupon(String coupon) {
        this.coupon = coupon;
    }
}
