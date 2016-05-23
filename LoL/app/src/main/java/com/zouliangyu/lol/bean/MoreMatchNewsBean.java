package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/22.
 */
public class MoreMatchNewsBean {

    /**
     * data : [{"id":"56370","title":"S5总决赛20选手之imp、Faker","desc":"RIOT官方评选的S5二十大选手，今天放出的是第2、1位","pic_url":"","published":1443667902,"live_url":"","max_id":"403"},{"id":"56330","title":"S5总决赛二十大选手KAKAO、GODV ","desc":"RIOT官方评选的S5二十大选手，今天放出的是第4、3位","pic_url":"","published":1443582017,"live_url":"","max_id":"403"},{"id":"56285","title":"S5总决赛20大选手之Pyl、RooKie ","desc":"RIOT官方评选的S5二十大选手，今天放出的是第6、5位","pic_url":"","published":1443492270,"live_url":"","max_id":"403"},{"id":"56242","title":"S5总决赛20大选手YellOwStaR、Deft ","desc":"RIOT官方评选的S5二十大选手，今天放出的是第8、7位","pic_url":"","published":1443406832,"live_url":"","max_id":"403"},{"id":"56217","title":"S5总决赛20大选手之PawN、Clearlove","desc":"RIOT官方评选的S5二十大选手，今天放出的是第10、9位","pic_url":"","published":1443319227,"live_url":"","max_id":"403"},{"id":"56192","title":"S5总决赛20大选手之MaRin、Westdoor","desc":"RIOT官方评选的S5二十大选手，今天放出的是第12、11位","pic_url":"","published":1443232250,"live_url":"","max_id":"403"},{"id":"56155","title":"S5总决赛20大选手之Huni、Ssumday","desc":"Huni的发挥决定了FNC上限","pic_url":"","published":1443148046,"live_url":"","max_id":"403"},{"id":"56113","title":"S5总决赛20大选手之Ziv、Bjergsen","desc":"RIOT官方评选的S5二十大选手，今天放出的是第16、15位","pic_url":"","published":1443067259,"live_url":"","max_id":"403"},{"id":"56073","title":"S5总决赛20大选手之Piccaboo、Aphromoo","desc":"RIOT官方评选的S5二十大选手，今天放出的是第18、17位","pic_url":"","published":1442976914,"live_url":"","max_id":"403"},{"id":"56041","title":"S5总决赛20大选手之Bang、Doublelift ","desc":"RIOT官方评选的S5二十大选手，今天放出的是第19、20位","pic_url":"","published":1442891612,"live_url":"","max_id":"403"},{"id":"56204","title":"RIOT官方分析S5总决赛D组排名","desc":"韦神imp成不确定因素","pic_url":"","published":1443252649,"live_url":"","max_id":"403"},{"id":"56124","title":"RIOT官方分析S5总决赛C组排名","desc":"C组充斥着熟悉，却并不尽友善的面孔，特别是在中路！","pic_url":"","published":1443078484,"live_url":"","max_id":"403"},{"id":"56082","title":"RIOT官方分析S5总决赛B组排名","desc":"IG的状态似乎不太稳定，时好时坏，我们会在小组赛中看到哪个iG呢?","pic_url":"","published":1442988019,"live_url":"","max_id":"403"},{"id":"56071","title":"RIOT官方分析S5总决赛A组排名","desc":"如果Xmithie能够出现在全球总决赛的舞台上，那么我认为CLG将是第二而闪电狼是第三。","pic_url":"","published":1442976023,"live_url":"","max_id":"403"},{"id":"55996","title":"官方S5战队介绍：iG","desc":"永不言败的LPL豪门","pic_url":"http://pic.woqugame.com/lol/news/20150921/spic55996h55ff6748.jpg","published":1442799061,"live_url":"","max_id":"403"}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 56370
     * title : S5总决赛20选手之imp、Faker
     * desc : RIOT官方评选的S5二十大选手，今天放出的是第2、1位
     * pic_url :
     * published : 1443667902
     * live_url :
     * max_id : 403
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
        private String pic_url;
        private int published;
        private String live_url;
        private String max_id;

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

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public int getPublished() {
            return published;
        }

        public void setPublished(int published) {
            this.published = published;
        }

        public String getLive_url() {
            return live_url;
        }

        public void setLive_url(String live_url) {
            this.live_url = live_url;
        }

        public String getMax_id() {
            return max_id;
        }

        public void setMax_id(String max_id) {
            this.max_id = max_id;
        }
    }
}
