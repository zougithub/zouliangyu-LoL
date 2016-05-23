package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/21.
 */
public class MoreTopicDetailsBean {

    /**
     * data : [{"id":"65947","title":"520高校总决赛开赛 雪碧现场爽快赠饮","desc":"《英雄联盟》准备了LOL主题雪碧现场赠饮，为高校学子在初夏时节带来清凉。","published":1463712986,"video_url":"","created":"2016-05-20 11:01:51"},{"id":"65888","title":"领票指南：第四届全国高校联赛总决赛","desc":"外场嘉年华也将一如既往的为玩家提供丰富多彩的现场活动","published":1463624065,"video_url":"","created":"2016-05-18 18:48:03"},{"id":"65886","title":"高校总决赛解说公布 神秘战队嘉宾将到场","desc":"LPL春季赛中担任解说的CoLiN、泽元以及致幻都将担起现场解说的大梁。","published":1463567891,"video_url":"","created":"2016-05-18 18:42:03"},{"id":"65887","title":"LOL第四届高校联赛总决赛赛程公布","desc":"总决赛的详细战队名单及赛程也已经全部发布","published":1463481474,"video_url":"","created":"2016-05-18 18:43:47"}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 65947
     * title : 520高校总决赛开赛 雪碧现场爽快赠饮
     * desc : 《英雄联盟》准备了LOL主题雪碧现场赠饮，为高校学子在初夏时节带来清凉。
     * published : 1463712986
     * video_url :
     * created : 2016-05-20 11:01:51
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
        private int published;
        private String video_url;
        private String created;

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

        public int getPublished() {
            return published;
        }

        public void setPublished(int published) {
            this.published = published;
        }

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }
    }
}
