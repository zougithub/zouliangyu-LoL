package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/23.
 */
public class MyHeroBean {

    /**
     * myHeroes : [{"enName":"Ekko","cnName":"艾克","title":"时间刺客","tags":"assassin","rating":"5,3,7,8","location":"中单","price":"6300,4500","presentTimes":"6"},{"enName":"Lux","cnName":"拉克丝","title":"光辉女郎","tags":"mage","rating":"2,4,9,5","location":"中单,辅助","price":"3150,2500","presentTimes":"6"},{"enName":"Ezreal","cnName":"伊泽瑞尔","title":"探险家","tags":"marksman","rating":"7,2,6,7","location":"中单,ADC","price":"4800,3000","presentTimes":"5"},{"enName":"Vayne","cnName":"薇恩","title":"暗夜猎手","tags":"marksman","rating":"10,1,1,8","location":"ADC","price":"4800,3000","presentTimes":"4"},{"enName":"Pantheon","cnName":"潘森","title":"战争之王","tags":"fighter","rating":"9,4,3,4","location":"上单,中单,打野","price":"3150,1500","presentTimes":"3"},{"enName":"Graves","cnName":"格雷福斯","title":"法外狂徒","tags":"marksman","rating":"8,5,3,3","location":"ADC","price":"6300,4500","presentTimes":"3"},{"enName":"Sejuani","cnName":"瑟庄妮","title":"凛冬之怒","tags":"tank","rating":"5,7,6,4","location":"打野","price":"4800,3500","presentTimes":"2"},{"enName":"Jax","cnName":"贾克斯","title":"武器大师","tags":"fighter","rating":"7,5,7,5","location":"上单,打野","price":"3150,2500","presentTimes":"2"},{"enName":"Malphite","cnName":"墨菲特","title":"熔岩巨兽","tags":"tank","rating":"5,9,7,2","location":"上单,打野","price":"1350,1000","presentTimes":"2"},{"enName":"MasterYi","cnName":"易","title":"无极剑圣","tags":"assassin","rating":"10,4,2,4","location":"上单,中单,打野","price":"450,1000","presentTimes":"2"},{"enName":"Annie","cnName":"安妮","title":"黑暗之女","tags":"mage,female","rating":"2,3,10,6","location":"中单,辅助","price":"4800,2000","presentTimes":""},{"enName":"Olaf","cnName":"奥拉夫","title":"狂战士","tags":"fighter","rating":"9,5,3,3","location":"上单,打野","price":"3150,1500","presentTimes":""},{"enName":"Jayce","cnName":"杰斯","title":"未来守护者","tags":"fighter","rating":"8,4,3,7","location":"上单,中单","price":"6300,4500","presentTimes":""},{"enName":"Darius","cnName":"德莱厄斯","title":"诺克萨斯之手","tags":"fighter","rating":"9,5,1,2","location":"上单","price":"6300,4500","presentTimes":""},{"enName":"Khazix","cnName":"卡兹克","title":"虚空掠夺者","tags":"assassin","rating":"9,4,3,6","location":"上单,中单,打野","price":"6300,4500","presentTimes":""},{"enName":"Hecarim","cnName":"赫卡里姆","title":"战争之影","tags":"fighter","rating":"8,6,4,6","location":"打野","price":"6300,4500","presentTimes":""},{"enName":"Diana","cnName":"黛安娜","title":"皎月女神","tags":"fighter","rating":"7,6,8,4","location":"上单,中单","price":"6300,4500","presentTimes":""},{"enName":"Alistar","cnName":"阿利斯塔","title":"牛头酋长","tags":"tank","rating":"6,9,5,7","location":"上单,辅助","price":"1350,2000","presentTimes":""},{"enName":"Yasuo","cnName":"亚索","title":"疾风剑豪","tags":"fighter","rating":"8,4,4,10","location":"上单,中单","price":"6300,4500","presentTimes":""},{"enName":"Kalista","cnName":"卡莉丝塔","title":"复仇之矛","tags":"marksman","rating":"8,2,4,7","location":"ADC","price":"6300,4500","presentTimes":""},{"enName":"RekSai","cnName":"雷克塞","title":"虚空遁地兽","tags":"fighter","rating":"8,5,2,3","location":"打野","price":"6300,4500","presentTimes":""},{"enName":"Ryze","cnName":"瑞兹","title":"流浪法师","tags":"mage","rating":"2,2,10,7","location":"上单,中单","price":"450,1000","presentTimes":""},{"enName":"Zed","cnName":"劫","title":"影流之主","tags":"assassin","rating":"9,2,1,7","location":"上单,中单,打野","price":"6300,4500","presentTimes":""},{"enName":"Lucian","cnName":"卢锡安","title":"圣枪游侠","tags":"marksman","rating":"8,5,3,6","location":"ADC","price":"6300,4500","presentTimes":""},{"enName":"Vi","cnName":"蔚","title":"皮城执法官","tags":"fighter","rating":"8,5,3,4","location":"上单,打野","price":"6300,4500","presentTimes":""},{"enName":"Sion","cnName":"赛恩","title":"亡灵战神","tags":"tank","rating":"5,9,3,5","location":"上单,中单","price":"1350,2000","presentTimes":""},{"enName":"Sivir","cnName":"希维尔","title":"战争女神","tags":"marksman","rating":"9,3,1,4","location":"ADC","price":"450,1000","presentTimes":""},{"enName":"Teemo","cnName":"提莫","title":"迅捷斥候","tags":"marksman","rating":"5,3,7,6","location":"上单,辅助","price":"6300,3500","presentTimes":""},{"enName":"Soraka","cnName":"索拉卡","title":"众星之子","tags":"support","rating":"2,5,7,3","location":"上单,中单,辅助","price":"450,1000","presentTimes":""},{"enName":"Warwick","cnName":"沃里克","title":"嗜血猎手","tags":"fighter","rating":"7,4,4,3","location":"上单,打野","price":"3150,2500","presentTimes":""},{"enName":"Tristana","cnName":"崔丝塔娜","title":"麦林炮手","tags":"marksman","rating":"9,3,5,4","location":"中单,ADC","price":"1350,1000","presentTimes":""},{"enName":"MissFortune","cnName":"厄运小姐","title":"赏金猎人","tags":"marksman","rating":"8,2,5,1","location":"ADC","price":"3150,2500","presentTimes":""},{"enName":"Nunu","cnName":"努努","title":"雪人骑士","tags":"support","rating":"4,6,7,4","location":"上单,打野,辅助","price":"450,1000","presentTimes":""},{"enName":"Tryndamere","cnName":"泰达米尔","title":"蛮族之王","tags":"fighter","rating":"10,5,2,5","location":"上单,打野","price":"4800,3500","presentTimes":""},{"enName":"Ashe","cnName":"艾希","title":"寒冰射手","tags":"marksman,female ","rating":"7,3,2,4","location":"ADC","price":"450,1000","presentTimes":""},{"enName":"Aatrox","cnName":"亚托克斯","title":"暗裔剑魔","tags":"fighter","rating":"8,4,3,4","location":"上单,打野","price":"6300,4500","presentTimes":""},{"enName":"Morgana","cnName":"莫甘娜","title":"堕落天使","tags":"mage","rating":"1,6,8,1","location":"中单,辅助","price":"1350,2000","presentTimes":""},{"enName":"Singed","cnName":"辛吉德","title":"炼金术士","tags":"tank","rating":"4,8,7,5","location":"上单","price":"1350,2000","presentTimes":""},{"enName":"Zilean","cnName":"基兰","title":"时光守护者","tags":"support","rating":"2,5,8,6","location":"中单,辅助","price":"450,1000","presentTimes":""},{"enName":"Twitch","cnName":"图奇","title":"瘟疫之源","tags":"marksman","rating":"9,2,3,6","location":"打野,ADC","price":"4800,3000","presentTimes":""},{"enName":"TwistedFate","cnName":"崔斯特","title":"卡牌大师","tags":"mage","rating":"6,2,6,9","location":"中单,辅助","price":"4800,3000","presentTimes":""},{"enName":"Evelynn","cnName":"伊芙琳","title":"寡妇制造者","tags":"assassin","rating":"4,2,7,10","location":"中单,打野","price":"1350,2000","presentTimes":""},{"enName":"Azir","cnName":"阿兹尔","title":"沙漠皇帝","tags":"mage","rating":"6,3,8,9","location":"上单,中单","price":"6300,4500","presentTimes":""},{"enName":"Chogath","cnName":"科加斯","title":"虚空恐惧","tags":"tank","rating":"3,7,7,5","location":"上单,打野","price":"3150,1500","presentTimes":""},{"enName":"Anivia","cnName":"艾尼维亚","title":"冰晶凤凰","tags":"mage","rating":"1,4,10,10","location":"中单","price":"4800,3500","presentTimes":""},{"enName":"Amumu","cnName":"阿木木","title":"殇之木乃伊","tags":"tank","rating":"2,6,8,3","location":"中单,打野","price":"1350,2000","presentTimes":""},{"enName":"Kassadin","cnName":"卡萨丁","title":"虚空行者","tags":"assassin","rating":"3,5,8,8","location":"中单","price":"3150,2500","presentTimes":""},{"enName":"Irelia","cnName":"艾瑞莉娅","title":"刀锋意志","tags":"fighter","rating":"7,4,5,5","location":"上单","price":"6300,4000","presentTimes":""},{"enName":"XinZhao","cnName":"赵信","title":"德邦总管","tags":"fighter","rating":"8,6,3,2","location":"上单,打野","price":"3150,2500","presentTimes":""},{"enName":"DrMundo","cnName":"蒙多医生","title":"祖安狂人","tags":"fighter","rating":"5,7,6,5","location":"上单,打野","price":"1350,2000","presentTimes":""},{"enName":"Sona","cnName":"娑娜","title":"琴瑟仙女","tags":"support","rating":"5,2,8,4","location":"辅助","price":"3150,2500","presentTimes":""},{"enName":"Corki","cnName":"库奇","title":"英勇投弹手","tags":"marksman","rating":"8,3,6,6","location":"中单,ADC","price":"6300,3500","presentTimes":""},{"enName":"Gangplank","cnName":"普朗克","title":"海洋之灾","tags":"fighter","rating":"7,6,4,9","location":"上单,打野","price":"3150,2500","presentTimes":""},{"enName":"Taric","cnName":"塔里克","title":"瓦洛兰之盾","tags":"support","rating":"4,8,5,3","location":"打野,辅助","price":"3150,1500","presentTimes":""},{"enName":"Veigar","cnName":"维迦","title":"邪恶小法师","tags":"mage","rating":"2,2,10,7","location":"中单","price":"1350,1000","presentTimes":""},{"enName":"Caitlyn","cnName":"凯特琳","title":"皮城女警","tags":"marksman","rating":"8,2,2,6","location":"ADC","price":"6300,3000","presentTimes":""},{"enName":"Swain","cnName":"斯维因","title":"策士统领","tags":"mage","rating":"2,6,9,8","location":"中单","price":"4800,3000","presentTimes":""},{"enName":"Trundle","cnName":"特朗德尔","title":"巨魔之王","tags":"fighter","rating":"7,6,2,5","location":"上单,打野","price":"3150,3000","presentTimes":""},{"enName":"Katarina","cnName":"卡特琳娜","title":"不祥之刃","tags":"assassin","rating":"4,3,9,8","location":"中单","price":"3150,2500","presentTimes":""},{"enName":"Blitzcrank","cnName":"布里茨","title":"蒸汽机器人","tags":"tank","rating":"4,8,5,4","location":"上单,辅助","price":"3150,2500","presentTimes":""},{"enName":"JarvanIV","cnName":"嘉文四世","title":"德玛西亚皇子","tags":"tank","rating":"6,8,3,5","location":"上单,打野","price":"4800,3000","presentTimes":""},{"enName":"Renekton","cnName":"雷克顿","title":"荒漠屠夫","tags":"fighter","rating":"8,5,2,3","location":"上单","price":"4800,3000","presentTimes":""},{"enName":"Maokai","cnName":"茂凯","title":"扭曲树精","tags":"tank","rating":"3,8,6,3","location":"打野","price":"4800,3000","presentTimes":""},{"enName":"Brand","cnName":"布兰德","title":"复仇焰魂","tags":"mage","rating":"2,2,9,4","location":"中单","price":"4800,2000","presentTimes":""},{"enName":"MonkeyKing","cnName":"孙悟空","title":"齐天大圣","tags":"fighter","rating":"8,5,2,3","location":"上单,打野","price":"6300,4500","presentTimes":""},{"enName":"Leblanc","cnName":"乐芙兰","title":"诡术妖姬","tags":"assassin","rating":"1,4,10,9","location":"中单,辅助","price":"4800,2500","presentTimes":""},{"enName":"Orianna","cnName":"奥莉安娜","title":"发条魔灵","tags":"mage","rating":"4,3,9,7","location":"中单","price":"6300,3000","presentTimes":""},{"enName":"Elise","cnName":"伊莉丝","title":"蜘蛛女皇","tags":"mage","rating":"6,5,7,9","location":"上单,打野","price":"6300,3000","presentTimes":""},{"enName":"Rumble","cnName":"兰博","title":"机械公敌","tags":"fighter","rating":"3,6,8,10","location":"上单","price":"4800,3000","presentTimes":""},{"enName":"Cassiopeia","cnName":"卡西奥佩娅","title":"魔蛇之拥","tags":"mage","rating":"2,3,9,10","location":"中单","price":"6300,2500","presentTimes":""},{"enName":"LeeSin","cnName":"李青","title":"盲僧","tags":"fighter","rating":"8,5,3,6","location":"上单,打野","price":"4800,3000","presentTimes":""},{"enName":"Nidalee","cnName":"奈德丽","title":"狂野女猎手","tags":"assassin","rating":"5,4,7,8","location":"上单,中单,辅助","price":"6300,3500","presentTimes":""},{"enName":"Udyr","cnName":"乌迪尔","title":"兽灵行者","tags":"fighter","rating":"8,7,4,7","location":"上单,打野","price":"3150,2500","presentTimes":""},{"enName":"Poppy","cnName":"波比","title":"圣锤之毅","tags":"tank","rating":"6,7,2,6","location":"上单,打野","price":"450,1000","presentTimes":""},{"enName":"Gragas","cnName":"古拉加斯","title":"酒桶","tags":"fighter","rating":"4,7,6,5","location":"上单,中单,打野","price":"3150,2000","presentTimes":""},{"enName":"Vladimir","cnName":"弗拉基米尔","title":"猩红收割者","tags":"mage","rating":"2,6,8,7","location":"上单,中单","price":"3150,2500","presentTimes":""},{"enName":"Skarner","cnName":"斯卡纳","title":"水晶先锋","tags":"fighter","rating":"7,6,5,5","location":"打野","price":"4800,3000","presentTimes":""},{"enName":"Nasus","cnName":"内瑟斯","title":"沙漠死神","tags":"fighter","rating":"7,5,6,6","location":"上单,打野","price":"3150,2500","presentTimes":""},{"enName":"Kennen","cnName":"凯南","title":"狂暴之心","tags":"mage","rating":"6,4,7,4","location":"上单,中单","price":"6300,3500","presentTimes":""},{"enName":"Akali","cnName":"阿卡丽","title":"暗影之拳","tags":"assassin","rating":"5,3,8,7","location":"上单,中单","price":"3150,2500","presentTimes":""},{"enName":"Garen","cnName":"盖伦","title":"德玛西亚之力","tags":"fighter","rating":"7,7,1,5","location":"上单","price":"3150,1000","presentTimes":""},{"enName":"Yorick","cnName":"约里克","title":"掘墓者","tags":"fighter","rating":"6,6,6,4","location":"上单,打野","price":"3150,2500","presentTimes":""},{"enName":"Mordekaiser","cnName":"莫德凯撒","title":"铁铠冥魂","tags":"fighter","rating":"4,6,7,4","location":"中单","price":"3150,2000","presentTimes":""},{"enName":"FiddleSticks","cnName":"费德提克","title":"末日使者","tags":"mage","rating":"2,3,9,9","location":"中单,打野,辅助","price":"1350,2000","presentTimes":""},{"enName":"Riven","cnName":"锐雯","title":"放逐之刃","tags":"fighter","rating":"8,5,1,8","location":"上单,中单,打野","price":"6300,4500","presentTimes":""},{"enName":"Leona","cnName":"蕾欧娜","title":"曙光女神","tags":"tank","rating":"4,8,3,4","location":"辅助","price":"4800,3000","presentTimes":""},{"enName":"Talon","cnName":"泰隆","title":"刀锋之影","tags":"assassin","rating":"9,3,1,7","location":"上单,中单,打野","price":"6300,4500","presentTimes":""},{"enName":"Shyvana","cnName":"希瓦娜","title":"龙血武姬","tags":"fighter","rating":"8,6,3,4","location":"上单,打野","price":"6300,4500","presentTimes":""},{"enName":"Ahri","cnName":"阿狸","title":"九尾妖狐","tags":"mage","rating":"3,4,8,5","location":"中单","price":"6300,3500","presentTimes":""},{"enName":"Xerath","cnName":"泽拉斯","title":"远古巫灵","tags":"mage","rating":"1,3,10,8","location":"中单","price":"4800,2500","presentTimes":""},{"enName":"Shen","cnName":"慎","title":"暮光之眼","tags":"tank,melee","rating":"3,9,3,4","location":"上单,打野","price":"3150,2500","presentTimes":""},{"enName":"Kayle","cnName":"凯尔","title":"审判天使","tags":"fighter","rating":"6,6,7,7","location":"上单,中单,打野","price":"450,1000","presentTimes":""},{"enName":"Rengar","cnName":"雷恩加尔","title":"傲之追猎者","tags":"assassin","rating":"7,4,2,8","location":"上单,打野","price":"6300,4500","presentTimes":""},{"enName":"Fizz","cnName":"菲兹","title":"潮汐海灵","tags":"assassin","rating":"6,4,7,6","location":"中单","price":"6300,4500","presentTimes":""},{"enName":"Draven","cnName":"德莱文","title":"荣耀行刑官","tags":"marksman","rating":"9,3,1,8","location":"ADC","price":"6300,4500","presentTimes":""},{"enName":"Fiora","cnName":"菲奥娜","title":"无双剑姬","tags":"fighter","rating":"10,4,2,3","location":"上单,打野","price":"6300,4500","presentTimes":""}]
     * serverName : 德玛西亚
     */

    private String serverName;
    /**
     * enName : Ekko
     * cnName : 艾克
     * title : 时间刺客
     * tags : assassin
     * rating : 5,3,7,8
     * location : 中单
     * price : 6300,4500
     * presentTimes : 6
     */

    private List<MyHeroesBean> myHeroes;

    public String getServerName() {
        return serverName;
    }

    public void setServerName(String serverName) {
        this.serverName = serverName;
    }

    public List<MyHeroesBean> getMyHeroes() {
        return myHeroes;
    }

    public void setMyHeroes(List<MyHeroesBean> myHeroes) {
        this.myHeroes = myHeroes;
    }

    public static class MyHeroesBean {
        private String enName;
        private String cnName;
        private String title;
        private String tags;
        private String rating;
        private String location;
        private String price;
        private String presentTimes;

        public String getEnName() {
            return enName;
        }

        public void setEnName(String enName) {
            this.enName = enName;
        }

        public String getCnName() {
            return cnName;
        }

        public void setCnName(String cnName) {
            this.cnName = cnName;
        }

        public String getTitle() {
            return title;
        }

        public void setTitle(String title) {
            this.title = title;
        }

        public String getTags() {
            return tags;
        }

        public void setTags(String tags) {
            this.tags = tags;
        }

        public String getRating() {
            return rating;
        }

        public void setRating(String rating) {
            this.rating = rating;
        }

        public String getLocation() {
            return location;
        }

        public void setLocation(String location) {
            this.location = location;
        }

        public String getPrice() {
            return price;
        }

        public void setPrice(String price) {
            this.price = price;
        }

        public String getPresentTimes() {
            return presentTimes;
        }

        public void setPresentTimes(String presentTimes) {
            this.presentTimes = presentTimes;
        }
    }
}
