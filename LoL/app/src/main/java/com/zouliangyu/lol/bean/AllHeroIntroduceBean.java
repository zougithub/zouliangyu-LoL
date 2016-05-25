package com.zouliangyu.lol.bean;

import java.util.List;

/**
 * Created by zouliangyu on 16/5/25.
 */
public class AllHeroIntroduceBean {


    /**
     * id : 245
     * name : Ekko
     * displayName : 时间刺客
     * title : 艾克
     * iconPath : Ekko_Square_0.png
     * portraitPath : Ekko_0.jpg
     * splashPath : Ekko_Splash_0.jpg
     * danceVideoPath : 0245_dance.mp4
     * tags : 刺客
     * description : 艾克是一名来自祖安不良街区的奇才。他可以操纵时间，从而让任何处境都变得对自己有利。通过使用他自己的发明——Z型驱动——他可以对现实的其它分支的可能性进行探索。在不断试验多维或然率的同时，艾克还将他的时间花费在与祖安的其他走失儿童一起撒野上。尽管他酷爱这种自由自在，但只要他的朋友们遇到了威胁，他就会不顾一切地去保护他们。对于毫不知情的观测者来说，艾克总是在一次又一次且轻而易举地完成着不可能的事情。
     * quote :
     * quoteAuthor :
     * range : 125.0
     * moveSpeed : 340.0
     * armorBase : 27.0
     * armorLevel : 3.0
     * manaBase : 280.0
     * manaLevel : 50.0
     * criticalChanceBase : 0.0
     * criticalChanceLevel : 0.0
     * manaRegenBase : 1.2
     * manaRegenLevel : 0.16
     * healthRegenBase : 1.8
     * healthRegenLevel : 0.18
     * magicResistBase : 32.0
     * magicResistLevel : 1.25
     * healthBase : 580.0
     * healthLevel : 80.0
     * attackBase : 59.0
     * attackLevel : 3.0
     * ratingDefense : 3
     * ratingMagic : 7
     * ratingDifficulty : 8
     * ratingAttack : 5
     * tips : -- 【R时空断裂】是一个有效的逃生手段，但它在用来进攻时也会非常给力。
     -- 如果你能够在一名敌方英雄身上触发【Z型驱动共振】，那么即使要承担一定风险也非常值得一试。它所提供的移速加成会让你轻松脱身。
     -- 【E相位俯冲】的位移是个非常好的起手技能，能让你轻松连上艾克的其它技能。用它来让【Q时间卷曲器】完成双次命中，或者达到【W时光交错】的引爆范围。
     * opponentTips : -- 艾克在大招没冷却的时候非常弱。要注意他留在身后的痕迹，来判断他的大招是否可用。
     -- 艾克的晕眩区域需要布置3秒。看好他在施法时创造的幻象，并试着猜一下那个区域放在哪个地方了。
     -- 时间卷曲器的第二次攻击造成的伤害比第一次更多；尽量避开它。
     * selectSoundPath : zh_CN/Ekko.mp3
     * Ekko_B : {"id":"106","name":"Z型驱动共振","cost":"","cooldown":"","description":"艾克的Z型驱动会让他的技能和普攻充盈着时光能量。第三次命中将会造成额外伤害并减弱目标的移动速度。如果目标是一名英雄，那么艾克自己会获得加速效果。","range":"","effect":"减速幅度：30/40/50/60% (在等级1/6/11/16时变化)，加速效果：50/60/70/80% (在等级1/6/11/16时变化)"}
     * Ekko_Q : {"id":"107","name":"时间卷曲器","cost":"50/60/70/80/90 法力","cooldown":"9/8.5/8/7.5/7","description":"艾克扔出一个时光手雷，这个手雷会在命中一个敌方英雄后扩展为一个时间扭曲的力场，对场内的所有敌方单位造成伤害和减速效果。然后它会在短暂的延迟后返回到艾克手上，返回途中会对沿途的敌人造成伤害。","range":"1075.0","effect":"艾克扔出一个设备，对沿途的敌人造成60/75/90/105/120(+0.2)魔法伤害。 它会在命中第一个敌方英雄后扩展为一个减速场，使场内的一切东西减速32/39/46/53/60%。然后它会在短暂的延迟后返回到艾克手上，返回途中会对所有命中的敌人造成60/85/110/135/160(+)魔法伤害。"}
     * Ekko_W : {"id":"108","name":"时光交错","cost":"50/55/60/65/70 法力","cooldown":"22/20/18/16/14","description":"艾克分离这条时间线，制造一个不稳定的异常时间点，这个时间点会在数秒后对范围内的敌人造成减速效果。如果艾克进入了这个异常时间点，那么他会获得护盾并引发一次爆炸，让范围内的敌人因悬浮在时间中而陷入晕眩状态。","range":"","effect":"被动：艾克的普攻会对生命值低于30%的敌人造成额外魔法伤害，伤害值相当于目标已损失生命值的3%(每33法术强度+1%)(对小兵和野怪的最小伤害：15，最大150)。\n\n主动：在3秒延迟后，艾克在目标区域制造一个暂时的时间场，并让进入它的敌人减速40%。如果艾克进入这个时间场，那么他会引爆它，获得一层持续2秒的护盾，护盾最多可吸收80/100/120/140/160(+1.5AP)伤害。在爆炸范围内的敌人会被晕眩2.25/2.25/2.25/2.25/2.25秒。"}
     * Ekko_E : {"id":"109","name":"相位俯冲","cost":"40/50/60/70/80 法力","cooldown":"11/10/9/8/7","description":"艾克在为Z型驱动充能的同时灵巧地滚动。他的下次攻击将造成魔法伤害并扭曲时间，并让他传送到他的攻击目标旁。","range":"325.0","effect":"艾克朝着目标方向位移一段距离。他的下次攻击将造成40/65/90/115/140(+0.4)魔法伤害，并让他传送到他的攻击目标旁。"}
     * Ekko_R : {"id":"110","name":"时空断裂","cost":"","cooldown":"110/90/70","description":"艾克打破他的时间线，变得不可被选取并回溯到一个更加有利的时间点上。他会回到几秒前的位置，并治疗这几秒内所受的伤势。在完成传送后，传送终点区域附近的敌人都会受到巨量伤害。","range":"850.0","effect":"让艾克免疫伤害且无法被选取，并且将他传送回4秒前所在的地方。艾克会治疗自己，治疗量相当于100/150/200+最近四秒里所承受伤害的20%(+0.04%)，并在完成传送后对附近的所有敌人造成200/350/500(+1.3)魔法伤害。"}
     * price : 6300,4500
     * like : [{"partner":"Vi","des":"蔚可以与纳尔共同游走，拥有足够的输出和控制，能将大多数敌人击溃。"},{"partner":"Gnar","des":"小纳尔的q和艾克的q可以不断消耗对方，而纳尔变身之后，艾克e接纳尔的r并使用w进行连续控制。"}]
     * hate : [{"partner":"Fiora","des":"剑姬w挡掉艾克攻击后，可以用两段q强行开战，然后e将艾克击退。"},{"partner":"Leblanc","des":"艾克面很难面对妖姬这种高爆发英雄，妖姬高伤害和短冷却技能进行换血会让艾克很难受。"}]
     */

    private String id;
    private String name;
    private String displayName;
    private String title;
    private String iconPath;
    private String portraitPath;
    private String splashPath;
    private String danceVideoPath;
    private String tags;
    private String description;
    private String quote;
    private String quoteAuthor;
    private String range;
    private String moveSpeed;
    private String armorBase;
    private String armorLevel;
    private String manaBase;
    private String manaLevel;
    private String criticalChanceBase;
    private String criticalChanceLevel;
    private String manaRegenBase;
    private String manaRegenLevel;
    private String healthRegenBase;
    private String healthRegenLevel;
    private String magicResistBase;
    private String magicResistLevel;
    private String healthBase;
    private String healthLevel;
    private String attackBase;
    private String attackLevel;
    private String ratingDefense;
    private String ratingMagic;
    private String ratingDifficulty;
    private String ratingAttack;
    private String tips;
    private String opponentTips;
    private String selectSoundPath;
    /**
     * id : 106
     * name : Z型驱动共振
     * cost :
     * cooldown :
     * description : 艾克的Z型驱动会让他的技能和普攻充盈着时光能量。第三次命中将会造成额外伤害并减弱目标的移动速度。如果目标是一名英雄，那么艾克自己会获得加速效果。
     * range :
     * effect : 减速幅度：30/40/50/60% (在等级1/6/11/16时变化)，加速效果：50/60/70/80% (在等级1/6/11/16时变化)
     */

    private EkkoBBean Ekko_B;
    /**
     * id : 107
     * name : 时间卷曲器
     * cost : 50/60/70/80/90 法力
     * cooldown : 9/8.5/8/7.5/7
     * description : 艾克扔出一个时光手雷，这个手雷会在命中一个敌方英雄后扩展为一个时间扭曲的力场，对场内的所有敌方单位造成伤害和减速效果。然后它会在短暂的延迟后返回到艾克手上，返回途中会对沿途的敌人造成伤害。
     * range : 1075.0
     * effect : 艾克扔出一个设备，对沿途的敌人造成60/75/90/105/120(+0.2)魔法伤害。 它会在命中第一个敌方英雄后扩展为一个减速场，使场内的一切东西减速32/39/46/53/60%。然后它会在短暂的延迟后返回到艾克手上，返回途中会对所有命中的敌人造成60/85/110/135/160(+)魔法伤害。
     */

    private EkkoQBean Ekko_Q;
    /**
     * id : 108
     * name : 时光交错
     * cost : 50/55/60/65/70 法力
     * cooldown : 22/20/18/16/14
     * description : 艾克分离这条时间线，制造一个不稳定的异常时间点，这个时间点会在数秒后对范围内的敌人造成减速效果。如果艾克进入了这个异常时间点，那么他会获得护盾并引发一次爆炸，让范围内的敌人因悬浮在时间中而陷入晕眩状态。
     * range :
     * effect : 被动：艾克的普攻会对生命值低于30%的敌人造成额外魔法伤害，伤害值相当于目标已损失生命值的3%(每33法术强度+1%)(对小兵和野怪的最小伤害：15，最大150)。

     主动：在3秒延迟后，艾克在目标区域制造一个暂时的时间场，并让进入它的敌人减速40%。如果艾克进入这个时间场，那么他会引爆它，获得一层持续2秒的护盾，护盾最多可吸收80/100/120/140/160(+1.5AP)伤害。在爆炸范围内的敌人会被晕眩2.25/2.25/2.25/2.25/2.25秒。
     */

    private EkkoWBean Ekko_W;
    /**
     * id : 109
     * name : 相位俯冲
     * cost : 40/50/60/70/80 法力
     * cooldown : 11/10/9/8/7
     * description : 艾克在为Z型驱动充能的同时灵巧地滚动。他的下次攻击将造成魔法伤害并扭曲时间，并让他传送到他的攻击目标旁。
     * range : 325.0
     * effect : 艾克朝着目标方向位移一段距离。他的下次攻击将造成40/65/90/115/140(+0.4)魔法伤害，并让他传送到他的攻击目标旁。
     */

    private EkkoEBean Ekko_E;
    /**
     * id : 110
     * name : 时空断裂
     * cost :
     * cooldown : 110/90/70
     * description : 艾克打破他的时间线，变得不可被选取并回溯到一个更加有利的时间点上。他会回到几秒前的位置，并治疗这几秒内所受的伤势。在完成传送后，传送终点区域附近的敌人都会受到巨量伤害。
     * range : 850.0
     * effect : 让艾克免疫伤害且无法被选取，并且将他传送回4秒前所在的地方。艾克会治疗自己，治疗量相当于100/150/200+最近四秒里所承受伤害的20%(+0.04%)，并在完成传送后对附近的所有敌人造成200/350/500(+1.3)魔法伤害。
     */

    private EkkoRBean Ekko_R;
    private String price;
    /**
     * partner : Vi
     * des : 蔚可以与纳尔共同游走，拥有足够的输出和控制，能将大多数敌人击溃。
     */

    private List<LikeBean> like;
    /**
     * partner : Fiora
     * des : 剑姬w挡掉艾克攻击后，可以用两段q强行开战，然后e将艾克击退。
     */

    private List<HateBean> hate;

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

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIconPath() {
        return iconPath;
    }

    public void setIconPath(String iconPath) {
        this.iconPath = iconPath;
    }

    public String getPortraitPath() {
        return portraitPath;
    }

    public void setPortraitPath(String portraitPath) {
        this.portraitPath = portraitPath;
    }

    public String getSplashPath() {
        return splashPath;
    }

    public void setSplashPath(String splashPath) {
        this.splashPath = splashPath;
    }

    public String getDanceVideoPath() {
        return danceVideoPath;
    }

    public void setDanceVideoPath(String danceVideoPath) {
        this.danceVideoPath = danceVideoPath;
    }

    public String getTags() {
        return tags;
    }

    public void setTags(String tags) {
        this.tags = tags;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getQuote() {
        return quote;
    }

    public void setQuote(String quote) {
        this.quote = quote;
    }

    public String getQuoteAuthor() {
        return quoteAuthor;
    }

    public void setQuoteAuthor(String quoteAuthor) {
        this.quoteAuthor = quoteAuthor;
    }

    public String getRange() {
        return range;
    }

    public void setRange(String range) {
        this.range = range;
    }

    public String getMoveSpeed() {
        return moveSpeed;
    }

    public void setMoveSpeed(String moveSpeed) {
        this.moveSpeed = moveSpeed;
    }

    public String getArmorBase() {
        return armorBase;
    }

    public void setArmorBase(String armorBase) {
        this.armorBase = armorBase;
    }

    public String getArmorLevel() {
        return armorLevel;
    }

    public void setArmorLevel(String armorLevel) {
        this.armorLevel = armorLevel;
    }

    public String getManaBase() {
        return manaBase;
    }

    public void setManaBase(String manaBase) {
        this.manaBase = manaBase;
    }

    public String getManaLevel() {
        return manaLevel;
    }

    public void setManaLevel(String manaLevel) {
        this.manaLevel = manaLevel;
    }

    public String getCriticalChanceBase() {
        return criticalChanceBase;
    }

    public void setCriticalChanceBase(String criticalChanceBase) {
        this.criticalChanceBase = criticalChanceBase;
    }

    public String getCriticalChanceLevel() {
        return criticalChanceLevel;
    }

    public void setCriticalChanceLevel(String criticalChanceLevel) {
        this.criticalChanceLevel = criticalChanceLevel;
    }

    public String getManaRegenBase() {
        return manaRegenBase;
    }

    public void setManaRegenBase(String manaRegenBase) {
        this.manaRegenBase = manaRegenBase;
    }

    public String getManaRegenLevel() {
        return manaRegenLevel;
    }

    public void setManaRegenLevel(String manaRegenLevel) {
        this.manaRegenLevel = manaRegenLevel;
    }

    public String getHealthRegenBase() {
        return healthRegenBase;
    }

    public void setHealthRegenBase(String healthRegenBase) {
        this.healthRegenBase = healthRegenBase;
    }

    public String getHealthRegenLevel() {
        return healthRegenLevel;
    }

    public void setHealthRegenLevel(String healthRegenLevel) {
        this.healthRegenLevel = healthRegenLevel;
    }

    public String getMagicResistBase() {
        return magicResistBase;
    }

    public void setMagicResistBase(String magicResistBase) {
        this.magicResistBase = magicResistBase;
    }

    public String getMagicResistLevel() {
        return magicResistLevel;
    }

    public void setMagicResistLevel(String magicResistLevel) {
        this.magicResistLevel = magicResistLevel;
    }

    public String getHealthBase() {
        return healthBase;
    }

    public void setHealthBase(String healthBase) {
        this.healthBase = healthBase;
    }

    public String getHealthLevel() {
        return healthLevel;
    }

    public void setHealthLevel(String healthLevel) {
        this.healthLevel = healthLevel;
    }

    public String getAttackBase() {
        return attackBase;
    }

    public void setAttackBase(String attackBase) {
        this.attackBase = attackBase;
    }

    public String getAttackLevel() {
        return attackLevel;
    }

    public void setAttackLevel(String attackLevel) {
        this.attackLevel = attackLevel;
    }

    public String getRatingDefense() {
        return ratingDefense;
    }

    public void setRatingDefense(String ratingDefense) {
        this.ratingDefense = ratingDefense;
    }

    public String getRatingMagic() {
        return ratingMagic;
    }

    public void setRatingMagic(String ratingMagic) {
        this.ratingMagic = ratingMagic;
    }

    public String getRatingDifficulty() {
        return ratingDifficulty;
    }

    public void setRatingDifficulty(String ratingDifficulty) {
        this.ratingDifficulty = ratingDifficulty;
    }

    public String getRatingAttack() {
        return ratingAttack;
    }

    public void setRatingAttack(String ratingAttack) {
        this.ratingAttack = ratingAttack;
    }

    public String getTips() {
        return tips;
    }

    public void setTips(String tips) {
        this.tips = tips;
    }

    public String getOpponentTips() {
        return opponentTips;
    }

    public void setOpponentTips(String opponentTips) {
        this.opponentTips = opponentTips;
    }

    public String getSelectSoundPath() {
        return selectSoundPath;
    }

    public void setSelectSoundPath(String selectSoundPath) {
        this.selectSoundPath = selectSoundPath;
    }

    public EkkoBBean getEkko_B() {
        return Ekko_B;
    }

    public void setEkko_B(EkkoBBean Ekko_B) {
        this.Ekko_B = Ekko_B;
    }

    public EkkoQBean getEkko_Q() {
        return Ekko_Q;
    }

    public void setEkko_Q(EkkoQBean Ekko_Q) {
        this.Ekko_Q = Ekko_Q;
    }

    public EkkoWBean getEkko_W() {
        return Ekko_W;
    }

    public void setEkko_W(EkkoWBean Ekko_W) {
        this.Ekko_W = Ekko_W;
    }

    public EkkoEBean getEkko_E() {
        return Ekko_E;
    }

    public void setEkko_E(EkkoEBean Ekko_E) {
        this.Ekko_E = Ekko_E;
    }

    public EkkoRBean getEkko_R() {
        return Ekko_R;
    }

    public void setEkko_R(EkkoRBean Ekko_R) {
        this.Ekko_R = Ekko_R;
    }

    public String getPrice() {
        return price;
    }

    public void setPrice(String price) {
        this.price = price;
    }

    public List<LikeBean> getLike() {
        return like;
    }

    public void setLike(List<LikeBean> like) {
        this.like = like;
    }

    public List<HateBean> getHate() {
        return hate;
    }

    public void setHate(List<HateBean> hate) {
        this.hate = hate;
    }

    public static class EkkoBBean {
        private String id;
        private String name;
        private String cost;
        private String cooldown;
        private String description;
        private String range;
        private String effect;

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

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getCooldown() {
            return cooldown;
        }

        public void setCooldown(String cooldown) {
            this.cooldown = cooldown;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRange() {
            return range;
        }

        public void setRange(String range) {
            this.range = range;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }
    }

    public static class EkkoQBean {
        private String id;
        private String name;
        private String cost;
        private String cooldown;
        private String description;
        private String range;
        private String effect;

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

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getCooldown() {
            return cooldown;
        }

        public void setCooldown(String cooldown) {
            this.cooldown = cooldown;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRange() {
            return range;
        }

        public void setRange(String range) {
            this.range = range;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }
    }

    public static class EkkoWBean {
        private String id;
        private String name;
        private String cost;
        private String cooldown;
        private String description;
        private String range;
        private String effect;

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

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getCooldown() {
            return cooldown;
        }

        public void setCooldown(String cooldown) {
            this.cooldown = cooldown;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRange() {
            return range;
        }

        public void setRange(String range) {
            this.range = range;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }
    }

    public static class EkkoEBean {
        private String id;
        private String name;
        private String cost;
        private String cooldown;
        private String description;
        private String range;
        private String effect;

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

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getCooldown() {
            return cooldown;
        }

        public void setCooldown(String cooldown) {
            this.cooldown = cooldown;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRange() {
            return range;
        }

        public void setRange(String range) {
            this.range = range;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }
    }

    public static class EkkoRBean {
        private String id;
        private String name;
        private String cost;
        private String cooldown;
        private String description;
        private String range;
        private String effect;

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

        public String getCost() {
            return cost;
        }

        public void setCost(String cost) {
            this.cost = cost;
        }

        public String getCooldown() {
            return cooldown;
        }

        public void setCooldown(String cooldown) {
            this.cooldown = cooldown;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }

        public String getRange() {
            return range;
        }

        public void setRange(String range) {
            this.range = range;
        }

        public String getEffect() {
            return effect;
        }

        public void setEffect(String effect) {
            this.effect = effect;
        }
    }

    public static class LikeBean {
        private String partner;
        private String des;

        public String getPartner() {
            return partner;
        }

        public void setPartner(String partner) {
            this.partner = partner;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }
    }

    public static class HateBean {
        private String partner;
        private String des;

        public String getPartner() {
            return partner;
        }

        public void setPartner(String partner) {
            this.partner = partner;
        }

        public String getDes() {
            return des;
        }

        public void setDes(String des) {
            this.des = des;
        }
    }
}
