package com.locensate.superlibray.utils;

import android.content.Context;
import android.view.Gravity;
import android.widget.Toast;

/**
 * -------------------------------------
 * <p>
 * 项目名称： lepro
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：toast管理
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2016/11/18
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class ToastUtils {

    /**
     * 只定义一个Toast
     */
    private static Toast mToast;

    private ToastUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 初始化单例模式
     */
    private static void init(Context context) {
        if (mToast == null) {
            mToast = new Toast(context);
        }
    }

    /**
     * 对toast的简易封装。
     */
    private static void showToast(Context context, int orientation, String str, int showTime) {
        init(context);
        mToast.makeText(context, str, showTime);
        mToast.setGravity(orientation, 0, 0);
        mToast.show();
    }

    /**
     * 获取文字
     */
    private static String getString(Context context, int resId) {
        return context.getResources().getString(resId);
    }

    /**
     * 底部显示
     */
    private static void showToast2Bottom(Context context, String str, int showTime) {
        showToast(context, Gravity.BOTTOM, str, showTime);
    }

    /**
     * 中间显示
     */
    private static void showToast2Center(Context context, String str, int showTime) {
        showToast(context, Gravity.CENTER, str, showTime);
    }

    /**
     * 底部短显示
     */
    public static void showToastShort2Bottom(Context context, String str) {
        showToast2Bottom(context, str, Toast.LENGTH_SHORT);
    }

    /**
     * 中间短显示
     */
    public static void showToastShort2Center(Context context, String str) {
        showToast2Center(context, str, Toast.LENGTH_SHORT);
    }

    /**
     * 底部长显示
     */
    public static void showToastLong2Bottom(Context context, String str) {
        showToast2Bottom(context, str, Toast.LENGTH_LONG);
    }

    /**
     * 中间长显示
     */
    public static void showToastLong2Center(Context context, String str) {
        showToast2Center(context, str, Toast.LENGTH_LONG);
    }

    /**
     * 底部短显示
     */
    public static void showToastShort2Bottom(Context context, int resId) {
        showToast2Bottom(context, getString(context, resId), Toast.LENGTH_SHORT);
    }

    /**
     * 中间短显示
     */
    public static void showToastShort2Center(Context context, int resId) {
        showToast2Center(context, getString(context, resId), Toast.LENGTH_SHORT);
    }

    /**
     * 底部长显示
     */
    public static void showToastLong2Bottom(Context context, int resId) {
        showToast2Bottom(context, getString(context, resId), Toast.LENGTH_LONG);
    }

    /**
     * 中间长显示
     */
    public static void showToastLong2Center(Context context, int resId) {
        showToast2Center(context, getString(context, resId), Toast.LENGTH_LONG);
    }

    /**
     * 底部短显示
     */
    public static void showToastShort2Bottom(String str) {
        showToast2Bottom(UtilsManager.getInstance().getAppContext(), str, Toast.LENGTH_SHORT);
    }

    /**
     * 中间短显示
     */
    public static void showToastShort2Center(String str) {
        showToast2Center(UtilsManager.getInstance().getAppContext(), str, Toast.LENGTH_SHORT);
    }

    /**
     * 底部长显示
     */
    public static void showToastLong2Bottom(String str) {
        showToast2Bottom(UtilsManager.getInstance().getAppContext(), str, Toast.LENGTH_LONG);
    }

    /**
     * 中间长显示
     */
    public static void showToastLong2Center(String str) {
        showToast2Center(UtilsManager.getInstance().getAppContext(), str, Toast.LENGTH_LONG);
    }

    /**
     * 底部短显示
     */
    public static void showToastShort2Bottom(int resId) {
        showToast2Bottom(UtilsManager.getInstance().getAppContext(), getString(UtilsManager.getInstance().getAppContext(), resId), Toast.LENGTH_SHORT);
    }

    /**
     * 中间短显示
     */
    public static void showToastShort2Center(int resId) {
        showToast2Center(UtilsManager.getInstance().getAppContext(), getString(UtilsManager.getInstance().getAppContext(), resId), Toast.LENGTH_SHORT);
    }

    /**
     * 底部长显示
     */
    public static void showToastLong2Bottom(int resId) {
        showToast2Bottom(UtilsManager.getInstance().getAppContext(), getString(UtilsManager.getInstance().getAppContext(), resId), Toast.LENGTH_LONG);
    }

    /**
     * 中间长显示
     */
    public static void showToastLong2Center(int resId) {
        showToast2Center(UtilsManager.getInstance().getAppContext(), getString(UtilsManager.getInstance().getAppContext(), resId), Toast.LENGTH_LONG);
    }

}
