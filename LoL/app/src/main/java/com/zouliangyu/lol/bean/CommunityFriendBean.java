package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/21.
 */
public class CommunityFriendBean {

    /**
     * data : [{"id":"461427","user_id":"18284389","sex":"1","city":"苏州市","slogan":"可以自己带线的来一起双排，妹子也可以","field":"中单 打野 ADC","enable_voice":"1","good_at":"盲僧，劫，卡兹克，小鱼人，奥巴马","area":"巨龙之巢","summoner":"依旧还是爱","zdl":"9222","tier":"3","rank":"2","good":"0","comment":"0","created":"2016-05-21 17:00:37","nickname":"倾心男爵","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/5c/573744d118284389.crop_image"},{"id":"461426","user_id":"23371384","sex":"1","city":"泰州市","slogan":"只要你有意识我可以带你上王者","field":"上单 中单 打野 ADC 辅助","enable_voice":"1","good_at":"瞎子","area":"暗影岛","summoner":"凹凸曼不打小恢灰","zdl":"7962","tier":"4","rank":"4","good":"0","comment":"0","created":"2016-05-21 16:47:27","nickname":"凹凸曼不打小恢灰","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/53/57401f5623371384.crop_image"},{"id":"461425","user_id":"15561014","sex":"1","city":"佳木斯市","slogan":"擅长打野 上单，只要辅助可以一般ADC都是暴力的，白银5求好撸友","field":"上单 中单 打野 ADC","enable_voice":"0","good_at":"德莱文","area":"恕瑞玛","summoner":"哎爽123456","zdl":"5668","tier":"4","rank":"4","good":"1","comment":"0","created":"2016-05-21 16:46:00","nickname":"随意Fa1r","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/default.jpg"},{"id":"461424","user_id":"23056190","sex":"1","city":"西安市","slogan":"还是喜欢玩潘森","field":"辅助","enable_voice":"2","good_at":"石头人","area":"守望之海","summoner":"呵呵哈哈ss","zdl":"0","tier":"255","rank":"255","good":"0","comment":"0","created":"2016-05-21 16:37:36","nickname":"poloHOHO","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/b9/5729ddb223056190.crop_image"},{"id":"461423","user_id":"17895057","sex":"1","city":null,"slogan":"沈阳 奥体中心 融顺小区 劳保超市","field":null,"enable_voice":"0","good_at":null,"area":"恕瑞玛","summoner":"逆血狂杀","zdl":"10017","tier":"3","rank":"1","good":"0","comment":"0","created":"2016-05-21 16:29:53","nickname":"清风x5你","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/default.jpg"},{"id":"461422","user_id":"15308532","sex":"2","city":null,"slogan":"求带","field":"上单 中单","enable_voice":"1","good_at":"剑圣 皎月 艾克","area":"黑色玫瑰","summoner":"独爱你f","zdl":"7142","tier":"5","rank":"3","good":"0","comment":"0","created":"2016-05-21 16:23:45","nickname":"你是我的男神吗","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/default.jpg"},{"id":"461421","user_id":"23415695","sex":"2","city":"阿勒泰地区","slogan":"需要战友","field":"辅助","enable_voice":"0","good_at":"璐璐","area":"艾欧尼亚","summoner":"黑色玫瑰","zdl":"2102","tier":"255","rank":"255","good":"0","comment":"0","created":"2016-05-21 16:20:58","nickname":"LOSER499","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/3f/57401a5623415695.crop_image"},{"id":"461420","user_id":"15806283","sex":"1","city":null,"slogan":"招几个战友","field":null,"enable_voice":"0","good_at":null,"area":"影流","summoner":"首席执行官林峰","zdl":"0","tier":"255","rank":"255","good":"0","comment":"0","created":"2016-05-21 16:14:33","nickname":"为了爱情伤了自己","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/default.jpg"},{"id":"461419","user_id":"9205939","sex":"1","city":"甘孜藏族自治州","slogan":"环保部","field":null,"enable_voice":"1","good_at":"亚索 盲僧","area":"艾欧尼亚","summoner":"需要保护的人","zdl":"13144","tier":"0","rank":"0","good":"0","comment":"0","created":"2016-05-21 16:13:26","nickname":"曹锋文哦","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/default.jpg"},{"id":"461418","user_id":"23082177","sex":"1","city":null,"slogan":"找个漂亮的妹子，带我一起打","field":null,"enable_voice":"0","good_at":null,"area":"征服之海","summoner":"和氪金矿","zdl":"3052","tier":"255","rank":"255","good":"0","comment":"0","created":"2016-05-21 16:08:35","nickname":"GG孩21","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/df/5740182323082177.crop_image"}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 461427
     * user_id : 18284389
     * sex : 1
     * city : 苏州市
     * slogan : 可以自己带线的来一起双排，妹子也可以
     * field : 中单 打野 ADC
     * enable_voice : 1
     * good_at : 盲僧，劫，卡兹克，小鱼人，奥巴马
     * area : 巨龙之巢
     * summoner : 依旧还是爱
     * zdl : 9222
     * tier : 3
     * rank : 2
     * good : 0
     * comment : 0
     * created : 2016-05-21 17:00:37
     * nickname : 倾心男爵
     * avatar : http://avatar.zhangyoubao.com/pic/user/avatar/5c/573744d118284389.crop_image
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
        private String user_id;
        private String sex;
        private String city;
        private String slogan;
        private String field;
        private String enable_voice;
        private String good_at;
        private String area;
        private String summoner;
        private String zdl;
        private String tier;
        private String rank;
        private String good;
        private String comment;
        private String created;
        private String nickname;
        private String avatar;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getUser_id() {
            return user_id;
        }

        public void setUser_id(String user_id) {
            this.user_id = user_id;
        }

        public String getSex() {
            return sex;
        }

        public void setSex(String sex) {
            this.sex = sex;
        }

        public String getCity() {
            return city;
        }

        public void setCity(String city) {
            this.city = city;
        }

        public String getSlogan() {
            return slogan;
        }

        public void setSlogan(String slogan) {
            this.slogan = slogan;
        }

        public String getField() {
            return field;
        }

        public void setField(String field) {
            this.field = field;
        }

        public String getEnable_voice() {
            return enable_voice;
        }

        public void setEnable_voice(String enable_voice) {
            this.enable_voice = enable_voice;
        }

        public String getGood_at() {
            return good_at;
        }

        public void setGood_at(String good_at) {
            this.good_at = good_at;
        }

        public String getArea() {
            return area;
        }

        public void setArea(String area) {
            this.area = area;
        }

        public String getSummoner() {
            return summoner;
        }

        public void setSummoner(String summoner) {
            this.summoner = summoner;
        }

        public String getZdl() {
            return zdl;
        }

        public void setZdl(String zdl) {
            this.zdl = zdl;
        }

        public String getTier() {
            return tier;
        }

        public void setTier(String tier) {
            this.tier = tier;
        }

        public String getRank() {
            return rank;
        }

        public void setRank(String rank) {
            this.rank = rank;
        }

        public String getGood() {
            return good;
        }

        public void setGood(String good) {
            this.good = good;
        }

        public String getComment() {
            return comment;
        }

        public void setComment(String comment) {
            this.comment = comment;
        }

        public String getCreated() {
            return created;
        }

        public void setCreated(String created) {
            this.created = created;
        }

        public String getNickname() {
            return nickname;
        }

        public void setNickname(String nickname) {
            this.nickname = nickname;
        }

        public String getAvatar() {
            return avatar;
        }

        public void setAvatar(String avatar) {
            this.avatar = avatar;
        }
    }
}
