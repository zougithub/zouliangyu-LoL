package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/20.
 */
public class MoreRingBean {

    /**
     * data : [{"id":"1","name":"一血","path_url":"http://file.zhangyoubao.com/lol/ring/0/1.mp3"},{"id":"2","name":"双杀","path_url":"http://file.zhangyoubao.com/lol/ring/0/2.mp3"},{"id":"3","name":"三杀","path_url":"http://file.zhangyoubao.com/lol/ring/0/3.mp3"},{"id":"4","name":"四杀","path_url":"http://file.zhangyoubao.com/lol/ring/0/4.mp3"},{"id":"5","name":"五杀","path_url":"http://file.zhangyoubao.com/lol/ring/0/5.mp3"},{"id":"6","name":"敌军还有30秒到达战场","path_url":"http://file.zhangyoubao.com/lol/ring/0/6.mp3"},{"id":"7","name":"欢迎来到英雄联盟","path_url":"http://file.zhangyoubao.com/lol/ring/0/7.mp3"},{"id":"8","name":"全军出击","path_url":"http://file.zhangyoubao.com/lol/ring/0/8.mp3"},{"id":"9","name":"大杀特杀(三连杀)","path_url":"http://file.zhangyoubao.com/lol/ring/0/9.mp3"},{"id":"10","name":"暴走(四连杀)","path_url":"http://file.zhangyoubao.com/lol/ring/0/10.mp3"},{"id":"11","name":"无人能挡(五连杀)","path_url":"http://file.zhangyoubao.com/lol/ring/0/11.mp3"},{"id":"12","name":"主宰比赛(六连杀)","path_url":"http://file.zhangyoubao.com/lol/ring/0/12.mp3"},{"id":"13","name":"接近神(七连杀)","path_url":"http://file.zhangyoubao.com/lol/ring/0/13.mp3"},{"id":"14","name":"超神(八连杀及以上)","path_url":"http://file.zhangyoubao.com/lol/ring/0/14.mp3"},{"id":"15","name":"团灭","path_url":"http://file.zhangyoubao.com/lol/ring/0/15.mp3"}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 1
     * name : 一血
     * path_url : http://file.zhangyoubao.com/lol/ring/0/1.mp3
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
        private String name;
        private String path_url;

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

        public String getPath_url() {
            return path_url;
        }

        public void setPath_url(String path_url) {
            this.path_url = path_url;
        }
    }
}
