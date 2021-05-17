package com.xuhuaixin.classshoot;

import android.app.Application;
import android.database.sqlite.SQLiteDatabase;

/**
 * author:
 * date: 2021/5/16
 */
public class MyApplication extends Application {

    public static DaoSession mSession;

    @Override
    public void onCreate() {
        super.onCreate();
        initDB();
    }

    private void initDB() {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(this, "ClassShoot.db");
        SQLiteDatabase db = devOpenHelper.getWritableDatabase();
        DaoMaster daoMaster = new DaoMaster(db);
        mSession = daoMaster.newSession();
    }

}
