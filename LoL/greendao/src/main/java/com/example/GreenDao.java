package com.example;

import de.greenrobot.daogenerator.DaoGenerator;
import de.greenrobot.daogenerator.Entity;
import de.greenrobot.daogenerator.Schema;

public class GreenDao {
    public static void main(String[] args) {
        Schema schema = new Schema(1, "com.zouliangyu.lol.greendao");
        addNote(schema);

        try {
            new DaoGenerator().generateAll(schema,"./app/src/main/java");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void addNote(Schema schema) {
        Entity entity = schema.addEntity("Article");
        entity.addIdProperty().autoincrement().primaryKey();
        entity.addStringProperty("title");
        entity.addStringProperty("desc");
        entity.addStringProperty("time");
        entity.addStringProperty("url");










    }
}
