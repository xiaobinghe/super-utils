package com.locensate.superlibray.datamanager;

import android.content.Context;
import android.content.res.AssetManager;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;

/**
 * -------------------------------------
 * <p>
 * 项目名称： lepro
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：将放在assert目录下的文件copy到本地sd卡中
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

public class AssertDataManager {

    private final Context context;

    public AssertDataManager(Context context) {
        this.context = context;
    }

    /**
     * 将assert目录下的文件拷贝到本地sd卡
     *
     * @param assertPath 在assert目录下的路径
     * @param savePath   要保存到本地的路径
     * @param fileName   文件的名称
     * @return
     */
    public boolean copyFile(String assertPath, String savePath, String fileName) {
        File path = new File(savePath);
        if (!path.exists()) {
            path.mkdirs();
        }
        File filePath = new File(savePath + "/" + fileName);
        if (filePath.exists()) {
            filePath.delete();
        }
        AssetManager assets = context.getAssets();
        try {
            InputStream is = assets.open(assertPath + "/" + fileName);
            FileOutputStream fos = new FileOutputStream(filePath);
            byte[] b = new byte[1024];
            int count = 0;
            while ((count = is.read(b)) > 0) {
                fos.write(b, 0, count);
            }
            fos.flush();
            fos.close();
            is.close();
        } catch (Exception e) {

            return false;
        }
        return true;
    }
}
