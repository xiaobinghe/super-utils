package com.locensate.superlibray.utils;

import android.content.Context;
import android.os.Handler;

/**
 * -------------------------------------
 * <p>
 * 项目名称： lepro
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：用户sdk配置
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2016/11/17
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class UtilsManager {

    private static UtilsManager instance;
    private Context appContext;
    private String userKey;
    /**
     * 主线程ID
     */
    private static int mMainThreadId = -1;
    /**
     * 主线程ID
     */
    private static Thread mMainThread;
    /**
     * 主线程Handler
     */
    private static Handler mMainThreadHandler;

    /**
     * 初始化sdk userKey为sdk的key，当前还没有用到，可空
     */
    private UtilsManager(Context appContext, String userKey, Handler mMainThreadHandler, Thread mMainThread) {
        this.appContext = appContext;
        this.userKey = userKey;

        this.mMainThread = mMainThread;
        this.mMainThreadId = (int) mMainThread.getId();
        this.mMainThreadHandler = mMainThreadHandler;
    }

    public static UtilsManager getInstance() {
        if (instance == null) {
            throw new RuntimeException("UtilsManager not initialized!");
        } else {
            return instance;
        }
    }

    /**
     * 初始化sdk，需要在Application的oncreate()方法中调用
     */
    public static void init(Context appContext, String userKey, Handler mMainThreadHandler, Thread mMainThread) {
        instance = new UtilsManager(appContext, userKey, mMainThreadHandler, mMainThread);
        DisplayUtil.init(appContext);
    }

    /**
     * 获取程序Application中的上下文
     */
    public Context getAppContext() {
        return appContext;
    }

    /**
     * 设置一级标签名称 默认是dou361
     */
    public void setFristTag(String flag) {
        LogUtils.setFristTag(flag);
    }

    /**
     * 设置开发环境 默认是false,正式环境无日志输出
     */
    public void setDebugEnv(boolean flag) {
        LogUtils.setPrintLog(flag);
    }

    /**
     * 设置日志输出等级 默认是log.e()等级输出
     */
    public void setLogLevel(int flag) {
        LogUtils.setLogLevel(flag);
    }

    /**
     * 设置sputils中字符串的加密key
     */
    public void setCryptKey(String key) {
        CryptUtil.setCryptKey(key);
    }

    /**
     * 获取主线程ID
     */
    public int getMainThreadId() {
        return mMainThreadId;
    }

    /**
     * 获取主线程
     */
    public Thread getMainThread() {
        return mMainThread;
    }

    /**
     * 获取主线程的handler
     */
    public Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

}
