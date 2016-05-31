package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDao {
    public static void main(String[] args) {
        // 数据库图表(数据库的框架)
        // 两个参数, 第一个参数是数据库的版本号
        // 第二个参数是包名
        Schema schema = new Schema(1, "com.zouliangyu.lol.greendao");
        addNote(schema);

        // 自动生成代码
        // 第一个参数图表对象, 第二个参数是自动生成的代码路径
        try {
            new DaoGenerator().generateAll(schema, "./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 为数据库里添加我所需要的内容
     * @param schema
     */
    public static void addNote(Schema schema) {
        // 添加表名
        Entity entity = schema.addEntity("Article");
        // 加入id   id自增
        entity.addIdProperty().autoincrement().primaryKey();
        // 添加类属性  根据属性生成相应表中的字段
        entity.addStringProperty("title");
        entity.addStringProperty("desc");
        entity.addStringProperty("time");
        entity.addStringProperty("url");
        entity.addStringProperty("imageUrl");

        Entity entityHero = schema.addEntity("Hero");
        entityHero.addIdProperty().autoincrement().primaryKey();
        entityHero.addStringProperty("imageUrl");
        entityHero.addStringProperty("code"); // 代号
        entityHero.addStringProperty("enName");



    }
}
