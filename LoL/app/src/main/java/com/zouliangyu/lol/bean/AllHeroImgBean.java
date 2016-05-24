package com.zouliangyu.lol.bean;

/**
 * Created by zouliangyu on 16/5/23.
 */
public class AllHeroImgBean {


    /**
     * id : 0
     * name : 铸星龙王奥瑞利安·索尔
     * price : 0
     * smallImg : http://box.dwstatic.com/skin/AurelionSol/AurelionSol_0.jpg
     * bigImg : http://box.dwstatic.com/skin/AurelionSol/AurelionSol_Splash_0.jpg
     */

    private String id;
    private String name;
    private String price;
    private String smallImg;
    private String bigImg;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public String getSmallImg() {
        return smallImg;
    }

    public void setSmallImg(String smallImg) {
        this.smallImg = smallImg;
    }

    public String getBigImg() {
        return bigImg;
    }

    public void setBigImg(String bigImg) {
        this.bigImg = bigImg;
    }
}
