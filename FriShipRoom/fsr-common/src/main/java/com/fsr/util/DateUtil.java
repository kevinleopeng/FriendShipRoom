package com.fsr.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

public class DateUtil
{
    public static final String Format_Date = "yyyy-MM-dd";
    public static final String Format_Time = "HH:mm:ss";
    public static final String Format_DateTime = "yyyy-MM-dd HH:mm:ss";
    public static final String Format_WITHNOMINUTE = "yyyy-MM-dd HH:mm";

    public static String getCurrentDate()
    {
        return new SimpleDateFormat("yyyy-MM-dd").format(new Date());
    }

    public static String getCurrentDate(String format)
    {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(new Date());
    }

    public static String getDateStrByDate(Date date, String format)
    {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(date);
    }

    public static String getCurrentTime()
    {
        return new SimpleDateFormat("HH:mm:ss").format(new Date());
    }

    public static String getCurrentTime(String format)
    {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(new Date());
    }

    public static String getCurrentDateTime()
    {
        String format = "yyyy-MM-dd HH:mm:ss";
        return getCurrentDateTime(format);
    }

    public static int getDayOfWeek()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(7);
    }

    public static int getDayOfWeek(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(7);
    }

    public static int getDayOfMonth()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(5);
    }

    public static int getDayOfMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(5);
    }

    public static int getMaxDayOfMonth(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.getActualMaximum(5);
    }


    public static String getFirstDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, 1);
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }


    public static String getLastDayOfMonth(Date date) {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        cal.set(5, cal.getActualMaximum(5));
        return new SimpleDateFormat("yyyy-MM-dd").format(cal.getTime());
    }

    public static int getDayOfYear()
    {
        Calendar cal = Calendar.getInstance();
        return cal.get(6);
    }

    public static int getDayOfYear(Date date)
    {
        Calendar cal = Calendar.getInstance();
        cal.setTime(date);
        return cal.get(6);
    }



    public static String getCurrentDateTime(String format)
    {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(new Date());
    }

    public static String toString(Date date)
    {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd").format(date);
    }

    public static String toDateTimeString(Date date)
    {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(date);
    }

    public static String toString(Date date, String format)
    {
        SimpleDateFormat t = new SimpleDateFormat(format);
        return t.format(date);
    }

    public static String toTimeString(Date date)
    {
        if (date == null) {
            return "";
        }
        return new SimpleDateFormat("HH:mm:ss").format(date);
    }


    public static int compareTime(String time1, String time2)
    {
        return compareTime(time1, time2, "HH:mm:ss");
    }


    public static int compareTime(String time1, String time2, String format)
    {
        String[] arr1 = time1.split(":");
        String[] arr2 = time2.split(":");
        if (arr1.length < 2) {
            throw new RuntimeException("错误的时间值:" + time1);
        }
        if (arr2.length < 2) {
            throw new RuntimeException("错误的时间值:" + time2);
        }
        int h1 = Integer.parseInt(arr1[0]);
        int m1 = Integer.parseInt(arr1[1]);
        int h2 = Integer.parseInt(arr2[0]);
        int m2 = Integer.parseInt(arr2[1]);
        int s1 = 0; int s2 = 0;
        if (arr1.length == 3) {
            s1 = Integer.parseInt(arr1[2]);
        }
        if (arr2.length == 3) {
            s2 = Integer.parseInt(arr2[2]);
        }
        if ((h1 < 0) || (h1 > 23) || (m1 < 0) || (m1 > 59) || (s1 < 0) || (s1 > 59)) {
            throw new RuntimeException("错误的时间值:" + time1);
        }
        if ((h2 < 0) || (h2 > 23) || (m2 < 0) || (m2 > 59) || (s2 < 0) || (s2 > 59)) {
            throw new RuntimeException("错误的时间值:" + time2);
        }
        if (h1 != h2) {
            return h1 > h2 ? 1 : -1;
        }
        if (m1 == m2) {
            if (s1 == s2) {
                return 0;
            }
            return s1 > s2 ? 1 : -1;
        }

        return m1 > m2 ? 1 : -1;
    }

    public static boolean isTime(String time)
    {
        String[] arr = time.split(":");
        if (arr.length < 2)
            return false;
        try
        {
            int h = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int s = 0;
            if (arr.length == 3) {
                s = Integer.parseInt(arr[2]);
            }
            if ((h < 0) || (h > 23) || (m < 0) || (m > 59) || (s < 0) || (s > 59))
                return false;
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }

    public static boolean isDate(String date)
    {
        String[] arr = date.split("-");
        if (arr.length < 3)
            return false;
        try
        {
            int y = Integer.parseInt(arr[0]);
            int m = Integer.parseInt(arr[1]);
            int d = Integer.parseInt(arr[2]);
            if ((y < 0) || (m > 12) || (m < 0) || (d < 0) || (d > 31))
                return false;
        }
        catch (Exception e) {
            return false;
        }
        return true;
    }







    public static Date addMinute(Date date, int count)
    {
        return new Date(date.getTime() + 60000L * count);
    }

    public static Date addHour(Date date, int count)
    {
        return new Date(date.getTime() + 3600000L * count);
    }

    public static Date addDay(Date date, int count)
    {
        return new Date(date.getTime() + 86400000L * count);
    }

    public static Date addWeek(Date date, int count)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(3, count);
        return c.getTime();
    }

    public static Date addMonth(Date date, int count)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(2, count);
        return c.getTime();
    }

    public static Date addYear(Date date, int count)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(1, count);
        return c.getTime();
    }




    public static String toDisplayDateTime(Date date)
    {
        long minite = (System.currentTimeMillis() - date.getTime()) / 60000L;
        if (minite < 60L) {
            return toString(date, "MM-dd") + " " + minite + "分钟前";
        }
        if (minite < 1440L) {
            return toString(date, "MM-dd") + " " + minite / 60L + "小时前";
        }
        return toString(date, "MM-dd") + " " + minite / 1440L + "天前";
    }

    public static int getCurrentYear()
    {
        return getYearOfDate(new Date());
    }

    public static int getYearOfDate(Date date)
    {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        return c.get(1);
    }
    public static synchronized Date addDay2(Date date, int count) {
        return new Date(date.getTime() + 0x5265c00L * (long) count);
    }
    public static synchronized Date decreaseDay(Date date, int count) {
        return new Date(date.getTime() - 0x5265c00L * (long) count);
    }
    /**
     * 传入秒数 返回 xx:xx:xx这种时间格式
     * @param second
     * @return
     */
    public static String getTimeStr(long second) {
        String timsStr = "";
        if (second >= (60 * 60)) {
            long hour = second / (60 * 60);
            long second_ = second % 3600;
            String miniteStr = "";
            String hourStr = String.valueOf(hour);
            if (hourStr.length() == 1) {
                hourStr = "0" + hourStr;
            }
            if (second_ > 60) {
                String minite = String.valueOf(second_ / 60);
                if (minite.length() == 1) {
                    minite = "0" + minite;
                }
                String second2 = String.valueOf(second_ % 60);
                if (second2.length() == 1) {
                    second2 = "0" + second2;
                }
                miniteStr = minite + ":" + second2;
            }else if(second_ == 0){
                timsStr = hourStr +":00:00";
                return timsStr;
            }
            timsStr = hourStr + ":" + miniteStr;
        } else if (second > 60) {
            String minite = String.valueOf(second / 60);
            if (minite.length() == 1) {
                minite = "0" + minite;
            }
            String second2 = String.valueOf(second % 60);
            if (second2.length() == 1) {
                second2 = "0" + second2;
            }
            timsStr = "00:" + minite + ":" + second2;
        } else {
            String secondStr = String.valueOf(second);
            if (secondStr.length() == 1) {
                secondStr = "0" + secondStr;
            }
            timsStr = "00:00:" + secondStr;
        }
        return timsStr;
    }


    /**
     * 根据日期获得不带秒的日期字符串
     *
     * @param date
     * @return
     * @author ZhangKaichuan
     */
    public static String toStringWithNoMinute(Date date) {
        if (date == null) {
            return "";
        }
        String str = DateUtil.toString(date, Format_WITHNOMINUTE);
        return str;
    }

    public static Set<String> getDateRange(String from, String to) {
        Set<String> daySet;
        String[] startDateArr = from.split("-");
        Calendar startCal = Calendar.getInstance();
        Integer[] dateArr = new Integer[3];
        String[] endDateArr = to.split("-");
        Calendar endCal = Calendar.getInstance();
        Integer[] endArr = new Integer[3];

        dateArr[0] = Integer.valueOf(startDateArr[0]);
        dateArr[1] = Integer.valueOf(startDateArr[1]) - 1;
        dateArr[2] = Integer.valueOf(startDateArr[2]);
        startCal.set(dateArr[0], dateArr[1], dateArr[2], 0, 0, 0);

        endArr[0] = Integer.valueOf(endDateArr[0]);
        endArr[1] = Integer.valueOf(endDateArr[1]) - 1;
        endArr[2] = Integer.valueOf(endDateArr[2]);
        endCal.set(endArr[0], endArr[1], endArr[2], 0, 0, 0);

        long startTime = startCal.getTimeInMillis();
        long endTime = endCal.getTimeInMillis();
        long days = (endTime - startTime)/1000/60/60/24;

        if (days >= 12) {
            int count = 2 << 3;
            int j = 4;

            while (true) {
                count = 2 << j;
                if (count * 0.75 > days) {
                    break;
                }
                ++j;
            }
            daySet = new LinkedHashSet<>(count);

           // System.out.println("days:"+days + "count:" + count);
        } else {
            daySet = new LinkedHashSet<>();
        }
        String  startStr = DateUtil.getDateStrByDate(startCal.getTime(), "yyyy-MM-dd");

        while (!startStr.equals(to)) {
            daySet.add(startStr);
            startCal.add(Calendar.DAY_OF_MONTH, 1);
            startStr = DateUtil.getDateStrByDate(startCal.getTime(), "yyyy-MM-dd");
        }
        daySet.add(DateUtil.getDateStrByDate(endCal.getTime(), "yyyy-MM-dd"));

        return daySet;
    }

    public static String getMovedDate(Date date, int days) {
        Calendar cal = Calendar.getInstance();

        cal.setTime(date);
        for (int i = 0; i < days; i++) {
            cal.add(Calendar.DAY_OF_MONTH, 1);
        }
        String dateStr = DateUtil.getDateStrByDate(cal.getTime(), "yyyy-MM-dd");
        return dateStr;
    }
}