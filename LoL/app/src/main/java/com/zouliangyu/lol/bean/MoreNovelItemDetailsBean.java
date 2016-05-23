package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/20.
 *
 * 更多 小说 详情 item界面 数据类
 */
public class MoreNovelItemDetailsBean {

    /**
     * data : [{"item_id":"65890","title":"英雄联盟之不死传说 21","desc":"整整一天，张子豪都在想那个人以前对他说过那些的话，还有那不可一世的嘴脸！","published":1463605200},{"item_id":"65803","title":"英雄联盟之不死传说 19","desc":"张子豪瞥了李泽一眼笑了笑说：\u201c放心吧，我对网恋没兴趣。\u201d","published":1463432400},{"item_id":"65759","title":"英雄联盟之不死传说 18","desc":"张子豪听完李泽的抱怨后，淡淡的回了五个字\u2026\u2026","published":1463346000},{"item_id":"65737","title":"英雄联盟之不死传说 17","desc":"\u201c战绩咋了？\u201d李泽听到柳艺说到这里时，一脸好奇的追问道。","published":1463259600},{"item_id":"65663","title":"英雄联盟之不死传说 15","desc":"老皮摇了摇头，辩解了一句：\u201c泽哥，我不，我不缺钱。。。\u201d","published":1463086800},{"item_id":"65613","title":"英雄联盟之不死传说 14","desc":"可能十个人看到这个问题，会给出十个不同的答案。","published":1463000400},{"item_id":"65564","title":"英雄联盟之不死传说 13","desc":"张子豪这边的五个人在拿到大龙BUFF后，士气高涨，而对面则是精神恍惚，无心恋战","published":1462914000},{"item_id":"65530","title":"英雄联盟之不死传说 12","desc":"谁都没想到，一个辅助蒙多，竟然能当着敌方五个人的面，只用一把菜刀就抢到了大龙","published":1462842000},{"item_id":"65440","title":"英雄联盟之不死传说 10","desc":"张子豪看到小炮补的装备，自然也是明白了他的意思。","published":1462654800},{"item_id":"65398","title":"英雄联盟之不死传说 09","desc":"既然ADC和辅助都不强势怎么办？那就猥琐着打呗。","published":1462568400}]
     * code : 200
     * message : ok
     * api : 1
     */

    private int code;
    private String message;
    private int api;
    /**
     * item_id : 65890
     * title : 英雄联盟之不死传说 21
     * desc : 整整一天，张子豪都在想那个人以前对他说过那些的话，还有那不可一世的嘴脸！
     * published : 1463605200
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
        private String item_id;
        private String title;
        private String desc;
        private int published;

        public String getItem_id() {
            return item_id;
        }

        public void setItem_id(String item_id) {
            this.item_id = item_id;
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
    }
}
