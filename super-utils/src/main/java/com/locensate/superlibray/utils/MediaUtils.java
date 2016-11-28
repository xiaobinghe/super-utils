package com.locensate.superlibray.utils;

import android.annotation.TargetApi;
import android.content.Context;
import android.media.AudioManager;
import android.os.Build;
import android.os.PowerManager;

/**
 * -------------------------------------
 * <p>
 * 项目名称： lepro
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：多媒体工具类，不全
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
public class MediaUtils {

    private MediaUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * @param bMute 值为true时为关闭背景音乐。
     */
    @TargetApi(Build.VERSION_CODES.FROYO)
    public static boolean muteAudioFocus(boolean bMute) {
        boolean bool = false;
        AudioManager am = (AudioManager) UtilsManager.getInstance().getAppContext().getSystemService(Context.AUDIO_SERVICE);
        if (bMute) {
            int result = am.requestAudioFocus(null, AudioManager.STREAM_MUSIC, AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
            bool = result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
        } else {
            int result = am.abandonAudioFocus(null);
            bool = result == AudioManager.AUDIOFOCUS_REQUEST_GRANTED;
        }
        return bool;
    }

    /**
     * 获得亮屏操作对象，保持常亮调用wakeLock.acquire();恢复正常调用wakeLock.release();
     */
    public static PowerManager.WakeLock getWakeLock() {
        PowerManager pm = (PowerManager) UtilsManager.getInstance().getAppContext().getSystemService(Context.POWER_SERVICE);
        return pm.newWakeLock(PowerManager.SCREEN_BRIGHT_WAKE_LOCK, "liveTAG");
    }

}
