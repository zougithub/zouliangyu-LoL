package com.zouliangyu.lol.bean;

/**
 * Created by zouliangyu on 16/5/11.
 */
public class NewsBean {
    private String title;
    private String desc;

    public NewsBean() {
    }

    public NewsBean(String title, String desc) {
        this.title = title;
        this.desc = desc;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }
}
