package com.locensate.superlibray.utils;

import android.content.Context;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

/**
 * -------------------------------------
 * <p>
 * 项目名称： lepro
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：软键盘操作工具类，打开或关闭工具类
 * <p>
 * 作者： xiaobinghe
 * <p>
 * 时间： 2016/11/16
 * <p>
 * 修改历史：
 * <p>
 * 修改时间：
 * <p>
 * 修改描述：
 * <p>
 * -------------------------------------
 */
public class KeyBoardUtils {

    private KeyBoardUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 隐藏键盘
     */
    public static void hideKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) UtilsManager.getInstance().getAppContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.hideSoftInputFromWindow(view.getWindowToken(), 0);
    }

    /**
     * 显示键盘
     */
    public static void showKeyboard(View view) {
        InputMethodManager imm = (InputMethodManager) UtilsManager.getInstance().getAppContext().getSystemService(Context.INPUT_METHOD_SERVICE);
        imm.showSoftInput(view, InputMethodManager.SHOW_FORCED);
    }
}
