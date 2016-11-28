package com.locensate.superlibray.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
/**
 * -------------------------------------
 * <p>
 * 项目名称： lepro
 * <p>
 * 版权：locensate.com 版权所有 2016
 * <p>
 * 公司主页：http://www.locensate.com/
 * <p>
 * 描述：日期工具类，String/long与date相互转换，两个日期的比较等
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
public class DateUtils {

    private DateUtils() {
        throw new UnsupportedOperationException("cannot be instantiated");
    }

    /**
     * 输入日期获取对应的日期
     *
     * @param sdfTo    获取的日期类型，Date对象，long 毫秒值，String 字符串日期
     * @param defValue 输入要转换的日期，Date对象，long 毫秒值，String 字符串日期
     * @return 要求获取的类型的日期
     */
    public static Object getData(String sdfTo, Date defValue) {
        return getData(sdfTo, null, defValue);
    }
    /**
     * 输入日期获取对应的日期
     *
     * @param sdfTo    获取的日期类型，Date对象，long 毫秒值，String 字符串日期
     * @param sdfFrom  输入要转换的日期类型，Date对象，long 毫秒值，String 字符串日期
     * @param defValue 输入要转换的日期，Date对象，long 毫秒值，String 字符串日期
     * @return 要求获取的类型的日期
     */
    public static Object getData(String sdfTo, String sdfFrom, Object defValue) {
        String type = defValue.getClass().getSimpleName();
        Date date;
        if ("Integer".equals(type) || "Long".equals(type)) {
            date = new Date((Long) defValue);
        } else if ("Date".equals(type)) {
            date = (Date) defValue;
        } else if ("String".equals(type)) {
            SimpleDateFormat sdf = new SimpleDateFormat(sdfFrom);
            try {
                date = sdf.parse((String) defValue);
            } catch (ParseException e) {
                throw new RuntimeException("the date type parse exception!");
            }

        } else {
            throw new RuntimeException("the date type illgel!");
        }
        if (DateType.DATE.equals(sdfTo)) {
            return date;
        } else if (DateType.DATETIME.equals(sdfTo)) {
            return date.getTime();
        } else {
            SimpleDateFormat sdf = new SimpleDateFormat(sdfTo);
            return sdf.format(date);
        }

    }

    public static long getCurrentTimeMillis() {
        return new Date().getTime();
    }

    /**
     * 比较两个日期的大小（-2转换异常0相等1大于-1小于）
     */
    public static int compareDate(Date dateF, Date dateS) {
        try {
            if (dateF.getTime() > dateS.getTime()) {
                return 1;
            } else if (dateF.getTime() < dateS.getTime()) {
                return -1;
            } else {
                return 0;
            }
        } catch (Exception exception) {
            exception.printStackTrace();
            return -2;
        }

    }

    /**
     * 获得指定年和月的天数
     */
    public static int getMonthLastDay(int year, int month) {
        Calendar a = Calendar.getInstance();
        a.set(Calendar.YEAR, year);
        a.set(Calendar.MONTH, month - 1);
        /** 把日期设置为当月第一天 */
        a.set(Calendar.DATE, 1);
        /** 日期回滚一天，也就是最后一天 */
        a.roll(Calendar.DATE, -1);
        int maxDate = a.get(Calendar.DATE);
        return maxDate;
    }

    /**
     * 获得指定天在当月的天索引
     */
    public static int getDayOfMonth(Date date) {
        Calendar aCalendar = Calendar.getInstance(Locale.CHINA);
        aCalendar.setTime(date);
        int day = aCalendar.getActualMaximum(Calendar.DATE);
        return day;
    }


    /**
     * 获取当天是星期几
     */
    public static String getDateToWeek(Date date) {
        Calendar c = Calendar.getInstance(Locale.CHINA);
        c.setTime(date);
        String mWay = String.valueOf(c.get(Calendar.DAY_OF_WEEK));
        if ("1".equals(mWay)) {
            mWay = "天";
        } else if ("2".equals(mWay)) {
            mWay = "一";
        } else if ("3".equals(mWay)) {
            mWay = "二";
        } else if ("4".equals(mWay)) {
            mWay = "三";
        } else if ("5".equals(mWay)) {
            mWay = "四";
        } else if ("6".equals(mWay)) {
            mWay = "五";
        } else if ("7".equals(mWay)) {
            mWay = "六";
        }
        return "星期" + mWay;
    }
    public static class DateType {

        /**
         * 输出类型 Date
         */
        public static String DATE = "DATE";
        /**
         * 输出类型 Datetime
         */
        public static String DATETIME = "DATETIME";
        /**
         * 输出类型
         */
        public static String sdf_yyyyMMddHHmmss = "yyyyMMddHHmmss";
        public static String sdf_yyyy_MM_dd_HH_mm_ss = "yyyy-MM-dd HH:mm:ss";
        public static String sdf_yyyy_MM_dd_HH_mm = "yyyy-MM-dd HH:mm";
        public static String sdf_yyyy_MM_dd = "yyyy-MM-dd";
        public static String sdf_HH_mm_ss = "HH:mm:ss";
        public static String sdf_yyyy = "yyyy";
        public static String sdf_MM = "MM";
        public static String sdf_dd = "dd";
        public static String sdf_HH_mm = "HH:mm";
    }

}
