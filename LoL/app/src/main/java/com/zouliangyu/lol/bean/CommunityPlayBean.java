package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/21.
 */
public class CommunityPlayBean {

    /**
     * data : [{"id":"707238","role_id":"107","map":"经典模式-召唤师峡谷","userid":"14612486","title":"好吧","equips":"14036,13114,13143,13062,14039,12999,","good":"0","comment":"0","hot":"0","content_md5":"5cf6c0b49aecf3d993416bf612d6d12a","json":"file/lol/user_plays/5c/5cf6c0b49aecf3d993416bf612d6d12a","season":"8","created":1463817988,"area":"班德尔城","summoner":"卟能离失丶","zdl":"10261","nickname":"卟能离去","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/5c/5cf6c0b49aecf3d993416bf612d6d12a"},{"id":"707237","role_id":"3","map":"经典模式-召唤师峡谷","userid":"22949262","title":"绕后就爆炸","equips":"14019,13061,13064,13065,14040,13146,","good":"0","comment":"0","hot":"0","content_md5":"8da71657687fbfd26af09ddfd9f72385","json":"file/lol/user_plays/8d/8da71657687fbfd26af09ddfd9f72385","season":"8","created":1463817925,"area":"扭曲丛林","summoner":"陆四逆k哈哈","zdl":"2835","nickname":"司机带带我","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/1f/57246a5622949262s.crop_image","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/8d/8da71657687fbfd26af09ddfd9f72385"},{"id":"707236","role_id":"58","map":"经典模式-召唤师峡谷","userid":"16365142","title":"我爱的,主q辅e","equips":"13017,13155,14127,13147,13079,13010,","good":"1","comment":"0","hot":"10","content_md5":"b99dd020c7c7c7156c3e3fe1a4d89f21","json":"file/lol/user_plays/b9/b99dd020c7c7c7156c3e3fe1a4d89f21","season":"8","created":1463817901,"area":"黑色玫瑰","summoner":"丿南宫魇海","zdl":"16098","nickname":"我爱邱灿","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/b9/b99dd020c7c7c7156c3e3fe1a4d89f21"},{"id":"707235","role_id":"126","map":"经典模式-召唤师峡谷","userid":"18885985","title":"666","equips":"13075,13075,13075,13075,13075,13075,","good":"0","comment":"0","hot":"0","content_md5":"7a7ae844e01de95aa858833c7cea3c40","json":"file/lol/user_plays/7a/7a7ae844e01de95aa858833c7cea3c40","season":"8","created":1463817566,"area":"水晶之痕","summoner":"ZX小白狼","zdl":"4096","nickname":"小白杨TOT","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/7a/7a7ae844e01de95aa858833c7cea3c40"},{"id":"707234","role_id":"126","map":"经典模式-召唤师峡谷","userid":"18885985","title":"6666","equips":"13114,14041,13062,13021,12999,13012,","good":"0","comment":"0","hot":"0","content_md5":"f5c4268d5743ed9940ebbab1ab5327e3","json":"file/lol/user_plays/f5/f5c4268d5743ed9940ebbab1ab5327e3","season":"8","created":1463817562,"area":"水晶之痕","summoner":"ZX小白狼","zdl":"4096","nickname":"小白杨TOT","avatar":"http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg","file_url":"http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/f5/f5c4268d5743ed9940ebbab1ab5327e3"}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 707238
     * role_id : 107
     * map : 经典模式-召唤师峡谷
     * userid : 14612486
     * title : 好吧
     * equips : 14036,13114,13143,13062,14039,12999,
     * good : 0
     * comment : 0
     * hot : 0
     * content_md5 : 5cf6c0b49aecf3d993416bf612d6d12a
     * json : file/lol/user_plays/5c/5cf6c0b49aecf3d993416bf612d6d12a
     * season : 8
     * created : 1463817988
     * area : 班德尔城
     * summoner : 卟能离失丶
     * zdl : 10261
     * nickname : 卟能离去
     * avatar : http://avatar.zhangyoubao.com/pic/user/avatar/defaults.jpg
     * file_url : http://anzo-file.oss-cn-qingdao.aliyuncs.com/file/lol/user_plays/5c/5cf6c0b49aecf3d993416bf612d6d12a
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
        private String role_id;
        private String map;
        private String userid;
        private String title;
        private String equips;
        private String good;
        private String comment;
        private String hot;
        private String content_md5;
        private String json;
        private String season;
        private int created;
        private String area;
        private String summoner;
        private String zdl;
        private String nickname;
        private String avatar;
        private String file_url;

        public String getId() {
            return id;
        }

        public void setId(String id) {
            this.id = id;
        }

        public String getRole_id() {
            return role_id;
        }

        public void setRole_id(String role_id) {
            this.role_id = role_id;
        }

        public String getMap() {
            return map;
        }

        public void setMap(String map) {
            this.map = map;
        }

        public String getUserid() {
            return userid;
        }

        public void setUserid(String userid) {
            this.userid = userid;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getEquips() {
            return equips;
        }

        public void setEquips(String equips) {
            this.equips = equips;
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

        public String getHot() {
            return hot;
        }

        public void setHot(String hot) {
            this.hot = hot;
        }

        public String getContent_md5() {
            return content_md5;
        }

        public void setContent_md5(String content_md5) {
            this.content_md5 = content_md5;
        }

        public String getJson() {
            return json;
        }

        public void setJson(String json) {
            this.json = json;
        }

        public String getSeason() {
            return season;
        }

        public void setSeason(String season) {
            this.season = season;
        }

        public int getCreated() {
            return created;
        }

        public void setCreated(int created) {
            this.created = created;
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

        public String getFile_url() {
            return file_url;
        }

        public void setFile_url(String file_url) {
            this.file_url = file_url;
        }
    }
}
