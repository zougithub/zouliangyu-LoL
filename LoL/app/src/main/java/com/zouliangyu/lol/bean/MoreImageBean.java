package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/19.
 *
 * 更多  壁纸数据类
 */
public class MoreImageBean {

    /**
     * data : [{"id":"33","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/1/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/1/thumb.jpg"},{"id":"34","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/10/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/10/thumb.jpg"},{"id":"35","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/11/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/11/thumb.jpg"},{"id":"36","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/12/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/12/thumb.jpg"},{"id":"37","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/13/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/13/thumb.jpg"},{"id":"38","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/14/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/14/thumb.jpg"},{"id":"39","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/15/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/15/thumb.jpg"},{"id":"40","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/16/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/16/thumb.jpg"},{"id":"41","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/17/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/17/thumb.jpg"},{"id":"42","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/18/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/18/thumb.jpg"},{"id":"43","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/19/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/19/thumb.jpg"},{"id":"44","role_id":"0","pic_url":"http://pic.woqugame.com/lol/paper/0/2/480.jpg","pic_thumb_url":"http://pic.woqugame.com/lol/paper/0/2/thumb.jpg"}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 33
     * role_id : 0
     * pic_url : http://pic.woqugame.com/lol/paper/0/1/480.jpg
     * pic_thumb_url : http://pic.woqugame.com/lol/paper/0/1/thumb.jpg
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
        private String pic_url;
        private String pic_thumb_url;

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

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }

        public String getPic_thumb_url() {
            return pic_thumb_url;
        }

        public void setPic_thumb_url(String pic_thumb_url) {
            this.pic_thumb_url = pic_thumb_url;
        }
    }
}
