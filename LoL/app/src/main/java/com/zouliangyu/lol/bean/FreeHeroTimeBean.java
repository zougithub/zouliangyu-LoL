package com.zouliangyu.lol.bean;


import java.util.List;

/**
 * Created by zouliangyu on 16/6/2.
 * 周免发布时间,数据类
 */
public class FreeHeroTimeBean {


    /**
     * currenttitle : 本期周免
     * currentdate : 5/27-6/3
     * currentperiod : [{"id":"9"},{"id":"114"},{"id":"70"},{"id":"45"},{"id":"22"},{"id":"111"},{"id":"97"},{"id":"129"},{"id":"28"},{"id":"85"},{"id":"69"},{"id":"35"},{"id":"95"}]
     */

    private DataBean data;
    /**
     * data : {"currenttitle":"本期周免","currentdate":"5/27-6/3","currentperiod":[{"id":"9"},{"id":"114"},{"id":"70"},{"id":"45"},{"id":"22"},{"id":"111"},{"id":"97"},{"id":"129"},{"id":"28"},{"id":"85"},{"id":"69"},{"id":"35"},{"id":"95"}]}
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;

    public DataBean getData() {
        return data;
    }

    public void setData(DataBean data) {
        this.data = data;
    }

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

    public static class DataBean {
        private String currenttitle;
        private String currentdate;
        /**
         * id : 9
         */

        private List<CurrentperiodBean> currentperiod;

        public String getCurrenttitle() {
            return currenttitle;
        }

        public void setCurrenttitle(String currenttitle) {
            this.currenttitle = currenttitle;
        }

        public String getCurrentdate() {
            return currentdate;
        }

        public void setCurrentdate(String currentdate) {
            this.currentdate = currentdate;
        }

        public List<CurrentperiodBean> getCurrentperiod() {
            return currentperiod;
        }

        public void setCurrentperiod(List<CurrentperiodBean> currentperiod) {
            this.currentperiod = currentperiod;
        }

        public static class CurrentperiodBean {
            private String id;

            public String getId() {
                return id;
            }

            public void setId(String id) {
                this.id = id;
            }
        }
    }
}
