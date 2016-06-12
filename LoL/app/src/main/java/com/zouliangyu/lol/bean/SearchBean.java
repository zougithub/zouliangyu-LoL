package com.zouliangyu.lol.bean;


import java.util.List;

/**
 * Created by zouliangyu on 16/6/6.
 */
public class SearchBean {


    /**
     * data : [{"id":"63573","title":"德玛西亚老流氓 会上瘾的小矮子波比攻略","desc":"越塔打团抗塔杀人非常轻松，输出也非常高！","video_url":"","published":1459231200,"pic_url":""},{"id":"60886","title":"小智解说 德玛西亚之翼","desc":"逆风到去偷家!","video_url":"http://k.youku.com/player/getFlvPath/sid/146528669680120c3d327_00/st/mp4/fileid/030020010056A17F91DE1A0552F7D9C7A5E337-EB9D-D7C9-136F-7994B268BDAB?k=47fa68f654867a072412a1d0&hd=1&myp=0&ts=3284&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffRRlJyXxUeYq096WK/I/O2Ro6qMtVWAOiyG6hiDRU5aLhIzwuvQBUW/le6oaSkUn9Koiee/VjpMkQyKQmzXb5+8=&ypremium=1&oip=2340490781&token=1031&sid=146528669680120c3d327&did=1465286696&ev=1&ctype=20&ep=7BzcdVN39KTF7Cy0texQYLJnb1ddwQ7CwXgZPyrpE%2BKt41rqAUlGhcgcpSMtsYLBAJGCM9UxXRWOCGWFrItNdJKsGSIgU%2BL8o24CQyrxsDrDvHN0iRv767yLvHjuq%2Boi","published":1453426207,"pic_url":"http://avatar.anzogame.com/pic_v1/lol/news/20160122/spic60886h56a18e4d.jpg"},{"id":"58358","title":"外服玩家评论德玛西亚杯EDG VS IG","desc":"\u201cClearlove比较低调，不抢风头，也不泡粉丝，职业素养很高。\u201d","video_url":"","published":1448266800,"pic_url":""},{"id":"58343","title":"T-ara德玛西亚杯现场表演 ","desc":"连夜给大家找的福利，小编我就是这么懂你","video_url":"http://video.dispatch.tc.qq.com/t0173prld4a.m701.mp4?vkey=887F9974E4DCA9CBD5B63DB179844B623910FA42E030D1636E0FC05972CAF431EC0F5DBF61026DE428FF1FB00498CAF9B41EF136F9575A93540CDD02A7F6C36F469182E5F77A36F58E5C613BD4916B8529ED4C2A52F429C8&br=29&platform=2&fmt=auto&level=0&sdtfrom=v5010","published":1448250000,"pic_url":"http://avatar.anzogame.com/pic_v1/lol/news/20151124/spic58343h5654331a.jpg"},{"id":"58221","title":"德玛西亚杯总决赛宣传片","desc":"11月21号，战火重燃！","video_url":"http://video.dispatch.tc.qq.com/7083751/r0173b5ookj.mp4?vkey=8DAF836F5DD1AC2F128C68725F07364B0E17D8012A7733515EA4398CF291FD5F4B74015DBB94FF99E5882C06B356609F17ADADF9DA44870DA4BE0C6FF81160B57071A559C443157A798C88B7FF52C8348B29F9F4DB8C5968&br=59&platform=2&fmt=auto&level=0&sdtfrom=v5010","published":1447982136,"pic_url":"http://pic.woqugame.com/lol/news/20151120/spic58221h564e784e.jpg"},{"id":"58146","title":"参与德玛西亚杯竞猜狂欢 赢取皮肤奖励","desc":"\u201c泳池派对 格雷福斯\u201d，\u201c寒冬精灵 璐璐\u201d等限定皮肤尽在活动奖池之中。","video_url":"","published":1447830047,"pic_url":""},{"id":"58079","title":"2015年德玛西亚杯总决赛 赛程公布","desc":"EDG、IG、OMG与Snake四支战队将于11月21、22日两天上演德杯年度总冠军的争夺之战。","video_url":"","published":1447657254,"pic_url":""},{"id":"57706","title":"2015德玛西亚杯年度总决赛售票劲爆开启","desc":"此次年度总决赛暨年度颁奖盛典将于11月21-22日在武汉体育中心体育馆举行","video_url":"","published":1446778119,"pic_url":""},{"id":"57581","title":"2015德玛西亚杯年度颁奖盛典震撼来袭","desc":"比赛将于11月21、22日在武汉举行，届时将有4支战队参赛","video_url":"","published":1446515437,"pic_url":""},{"id":"55121","title":"玩家自制音乐：德玛西亚","desc":"国外玩家是会玩的","video_url":"http://k.youku.com/player/getFlvPath/sid/2465277117530200a55f0_00/st/mp4/fileid/030020010055E342B5F20E02A01538F8C3FA9D-92CC-5A46-7EB9-299B2D5C07E4?k=4b44ac2fe584b5e8261f0da3&hd=1&myp=0&ts=191&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0fffls28FaDnGzCJ1ij29Zu+jLRm1A7glFV5McAdizq5b2Cpor5pMNTI+/YX+64vySuw==&ypremium=1&oip=2340490781&token=6175&sid=2465277117530200a55f0&did=1465277117&ev=1&ctype=20&ep=KDNKp0jmUIY2ONpktvQIMIFa%2BW0qyI1X716fjjUAhUiz9ZdEkRR0%2Fhyiz11xaBTJQfy1%2BD5ZhOfMXO51k4nnVrQNI70%2Buw6ygjaDTiNNdrrocgJDjrGr1ja%2FNwKfkWXa","published":1440992390,"pic_url":"http://pic.woqugame.com/lol/news/20150831/spic55121h55e3c915.jpg"},{"id":"54400","title":"德玛西亚狂想曲","desc":"太有才！","video_url":"http://k.youku.com/player/getFlvPath/sid/546528633952920234dbc_00/st/mp4/fileid/030020010055CC4E8F9C302F0973C839B85B5A-EF7B-CA24-6AF2-9986FA3CF078?k=5d64775144424fa9282b798f&hd=1&myp=0&ts=225&r=/3sLngL0Q6CXymAIiF9JUQQtnOFNJPUClO8A56KJJcT8UB+NRAMQ09zE6rNj4EKMxAvRByWf6hitgv75Fv0ffWCn9b6HkLTUANos9avDa+S4d49JRBkYBcsrqeN8erNi2hEWku+cwJTYumRABWNi0w==&ypremium=1&oip=2340490781&token=3350&sid=546528633952920234dbc&did=1465286339&ev=1&ctype=20&ep=1mU0MnLwQaTowJ5jmNYtCr%2FCrWI0e1v%2BVdQmepqzfCBdNBEN9wnu4JAOdcrlgHMbVmeMOfNUqB33Qoj1gzxjqS4M%2F5rybW%2FAMzVTX5S6BA8u02qHkTBTxoynmiCna8IZ","published":1439456400,"pic_url":"http://pic.woqugame.com/lol/news/20150813/spic54400h55cc53c5.jpg"},{"id":"53133","title":"德玛西亚杯告诉我们的五件事","desc":"EDG依然是中国最强的，而没有UZI的OMG或许会更强","video_url":"","published":1437112800,"pic_url":""},{"id":"52926","title":"北京德杯故事 德玛西亚杯第二日侧写","desc":"电竞精神不分职业，不分年龄","video_url":"","published":1436665547,"pic_url":""},{"id":"52624","title":"2015年德玛西亚杯年度总决赛公告","desc":"掌游宝将同步为大家直播","video_url":"","published":1436163880,"pic_url":""},{"id":"52519","title":"德玛西亚杯WE、EDG队伍深度分析","desc":"冷门缔造者WE、三冠王候选EDG如何德杯再续传奇","video_url":"","published":1435976347,"pic_url":""}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * id : 63573
     * title : 德玛西亚老流氓 会上瘾的小矮子波比攻略
     * desc : 越塔打团抗塔杀人非常轻松，输出也非常高！
     * video_url :
     * published : 1459231200
     * pic_url :
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
        private String video_url;
        private int published;
        private String pic_url;

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

        public String getVideo_url() {
            return video_url;
        }

        public void setVideo_url(String video_url) {
            this.video_url = video_url;
        }

        public int getPublished() {
            return published;
        }

        public void setPublished(int published) {
            this.published = published;
        }

        public String getPic_url() {
            return pic_url;
        }

        public void setPic_url(String pic_url) {
            this.pic_url = pic_url;
        }
    }
}
