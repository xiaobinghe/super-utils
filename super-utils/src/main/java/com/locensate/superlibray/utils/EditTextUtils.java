package com.locensate.superlibray.utils;

import android.content.Context;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.widget.EditText;

import java.io.UnsupportedEncodingException;

/**
 * -------------------------------------
 * <p>
 * 项目名称： lepro
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：edittext工具类，监听输入内容是否超出最大长度
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
public class EditTextUtils {

    public static void setLengthFilter(EditText editText, int chinaMax, Context context) {
        editText.addTextChangedListener(new MaxLengthWatcher(chinaMax, editText, context));
    }

    /** 判断是否是输入法的表情 */
    public static boolean isEmojiCharacter(char codePoint) {
        return !((codePoint == 0x0) ||
                (codePoint == 0x9) ||
                (codePoint == 0xA) ||
                (codePoint == 0xD) ||
                ((codePoint >= 0x20) && codePoint <= 0xD7FF)) ||
                ((codePoint >= 0xE000) && (codePoint <= 0xFFFD)) ||
                ((codePoint >= 0x10000) && (codePoint <= 0x10FFFF));
    }

    /*
  * 监听输入内容是否超出最大长度，并设置光标位置
  * 限制数字字符数，1汉字相当于2字母 或2数字
  * */
    public static class MaxLengthWatcher implements TextWatcher {

        private int maxLen = 0;
        private EditText editText = null;
        private Context mContext;


        public MaxLengthWatcher(int maxLen, EditText editText, Context context) {
            this.maxLen = maxLen;
            this.editText = editText;
            this.mContext = context;
        }

        public void afterTextChanged(Editable s) {
            // TODO Auto-generated method stub
            if (!TextUtils.isEmpty(s.toString())) {
                String limitSubstring = getLimitSubstring(s.toString());
                if (!TextUtils.isEmpty(limitSubstring)) {
                    if (!limitSubstring.equals(s.toString())) {
                        editText.setText(limitSubstring);
                        editText.setSelection(limitSubstring.length());
                    }
                }
            }
        }

        public void beforeTextChanged(CharSequence arg0, int arg1, int arg2,
                                      int arg3) {
            // TODO Auto-generated method stub

        }

        public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3) {
            // TODO Auto-generated method stub

        }

        private String getLimitSubstring(String inputStr) {
            int orignLen = inputStr.length();
            int resultLen = 0;
            String temp = null;
            for (int i = 0; i < orignLen; i++) {
                temp = inputStr.substring(i, i + 1);
                try {
                    if (temp.getBytes("utf-8").length == 3) {
                        resultLen += 2;
                    } else {
                        resultLen++;
                    }
                } catch (UnsupportedEncodingException e) {
                    e.printStackTrace();
                }
                if (resultLen > maxLen) {
                    return inputStr.substring(0, i);
                }
            }
            return inputStr;
        }

    }
}
