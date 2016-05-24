package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/23.
 */
public class AllHeroBean {

    /**
     * enName : AurelionSol
     * cnName : 奥瑞利安·索尔
     * title : 铸星龙王
     * tags : mage
     * rating : 2,3,8,7
     * location : 中单
     * price : 6300,4500
     */

    private List<AllBean> all;
    /**
     * enName : Swain
     * cnName : 斯维因
     * title : 策士统领
     * tags : mage
     * rating : 2,6,9,8
     * location : 中单
     * price : 4800,3000
     */

    private List<FreeBean> free;
    private List<?> mostUsed;

    public List<AllBean> getAll() {
        return all;
    }

    public void setAll(List<AllBean> all) {
        this.all = all;
    }

    public List<FreeBean> getFree() {
        return free;
    }

    public void setFree(List<FreeBean> free) {
        this.free = free;
    }

    public List<?> getMostUsed() {
        return mostUsed;
    }

    public void setMostUsed(List<?> mostUsed) {
        this.mostUsed = mostUsed;
    }

    public static class AllBean {
        private String enName;
        private String cnName;
        private String title;
        private String tags;
        private String rating;
        private String location;
        private String price;

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public String getCnName() {
            return cnName;
        }

        public void setCnName(String cnName) {
            this.cnName = cnName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }

    public static class FreeBean {
        private String enName;
        private String cnName;
        private String title;
        private String tags;
        private String rating;
        private String location;
        private String price;

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public String getCnName() {
            return cnName;
        }

        public void setCnName(String cnName) {
            this.cnName = cnName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }
    }
}
