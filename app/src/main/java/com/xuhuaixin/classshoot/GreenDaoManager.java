package com.xuhuaixin.classshoot;

/**
 * author:
 * date: 2021/5/16
 */
public class GreenDaoManager {

    private static volatile GreenDaoManager INSTANCE;
    private StudentDao mStudentDao;

    public static GreenDaoManager getInstance() {
        if (INSTANCE == null) {
            synchronized (GreenDaoManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = new GreenDaoManager();
                }
            }
        }
        return INSTANCE;
    }

    private GreenDaoManager() {
        mStudentDao = MyApplication.mSession.getStudentDao();
    }

    public StudentDao getStudentDao() {
        return mStudentDao;
    }
}
