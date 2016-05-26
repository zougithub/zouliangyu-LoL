package com.zouliangyu.lol.greendao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.zouliangyu.lol.base.MyApplication;

/**
 * Created by zouliangyu on 16/5/26.
 */
public class GreendaoSingle {
    private SQLiteDatabase db; //数据库
    private DaoMaster daoMaster; // 管理者
    private DaoSession daoSession; // 会话者
    private ArticleDao articleDao;  // 数据库内相应表的操作对象
    private Context context;
    private DaoMaster.DevOpenHelper helper;

    public DaoMaster.DevOpenHelper getHelper() {
        if (helper == null) {
            helper = new DaoMaster.DevOpenHelper(context, "Article.db", null);
        }
        return helper;
    }


    private static GreendaoSingle ourInstance = new GreendaoSingle();

    public static GreendaoSingle getInstance() {
        return ourInstance;
    }

    private GreendaoSingle() {
        context = MyApplication.getContext();
    }

    public SQLiteDatabase getDb() {
        if (db == null) {
            db = getHelper().getWritableDatabase();
        }
        return db;
    }

    public DaoMaster getDaoMaster() {
        if (daoMaster == null) {
            daoMaster = new DaoMaster(getDb());
        }
        return daoMaster;
    }

    public DaoSession getDaoSession() {
        if (daoSession == null) {
            daoSession = getDaoMaster().newSession();
        }
        return daoSession;
    }

    public ArticleDao getArticleDao() {
        if (articleDao == null) {
            articleDao = getDaoSession().getArticleDao();
        }
        return articleDao;
    }


}
