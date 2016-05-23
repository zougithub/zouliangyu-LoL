package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/13.
 *
 * 轮播图数据类
 */
public class BannerBean {

    /**
     * data : [{"id":"65631","title":"5月13日免费英雄更换公告","desc":"5月13日免费英雄更换公告","goto_target":"item","goto_param":{"itemid":"65610","title":"5月13日免费英雄更换公告","desc":"5月13日免费英雄更换公告"},"platform":"1","pic_ad_url":"http://avatar.anzogame.com/pic_v1/lol/news/20160512/picad65631h5733f9d2.jpg"},{"id":"65506","title":"国服5月10日更新至6.9版本","desc":"国服5月10日更新至6.9版本","goto_target":"item","goto_param":{"itemid":"65502","title":"国服5月10日更新至6.9版本","desc":"国服5月10日更新至6.9版本"},"platform":"1","pic_ad_url":"http://avatar.anzogame.com/pic_v1/lol/news/20160509/picad65506h573031f7.jpg"},{"id":"65250","title":"官方季中冠军赛活动","desc":"官方季中冠军赛活动","goto_target":"item","goto_param":{"itemid":"65288","title":"官方季中冠军赛活动","desc":"官方季中冠军赛活动"},"platform":"1","pic_ad_url":"http://avatar.anzogame.com/pic_v1/lol/news/20160504/picad65250h5729a7ea.jpg"}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 65631
     * title : 5月13日免费英雄更换公告
     * desc : 5月13日免费英雄更换公告
     * goto_target : item
     * goto_param : {"itemid":"65610","title":"5月13日免费英雄更换公告","desc":"5月13日免费英雄更换公告"}
     * platform : 1
     * pic_ad_url : http://avatar.anzogame.com/pic_v1/lol/news/20160512/picad65631h5733f9d2.jpg
     */

    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public int getApi() {
        return api;
    }

    public void setApi(int api) {
        this.api = api;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        private String id;
        private String title;
        private String desc;
        private String goto_target;
        /**
         * itemid : 65610
         * title : 5月13日免费英雄更换公告
         * desc : 5月13日免费英雄更换公告
         */

        private GotoParamBean goto_param;
        private String platform;
        private String pic_ad_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
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

        public String getGoto_target() {
            return goto_target;
        }

        public void setGoto_target(String goto_target) {
            this.goto_target = goto_target;
        }

        public GotoParamBean getGoto_param() {
            return goto_param;
        }

        public void setGoto_param(GotoParamBean goto_param) {
            this.goto_param = goto_param;
        }

        public String getPlatform() {
            return platform;
        }

        public void setPlatform(String platform) {
            this.platform = platform;
        }

        public String getPic_ad_url() {
            return pic_ad_url;
        }

        public void setPic_ad_url(String pic_ad_url) {
            this.pic_ad_url = pic_ad_url;
        }

        public static class GotoParamBean {
            private String itemid;
            private String title;
            private String desc;

            public String getItemid() {
                return itemid;
            }

            public void setItemid(String itemid) {
                this.itemid = itemid;
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
    }
}
