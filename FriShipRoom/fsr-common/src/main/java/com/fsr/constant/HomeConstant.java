package com.fsr.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hasee on 2017/5/11.
 */
public class HomeConstant {
    /**
     * 装修中
     */
    public static int DECORATING = 1;

    /**
     * 通风中
     */
    public static int VENTILATE = 2;

    /**
     * 租赁中
     */
    public static int RENTING = 3;

    /**
     * 租赁完
     */
    public static int RENTED = 4;

    /**
     * 装修中
     */
    public static String DECORATING_STR = "装修中";

    /**
     * 通风中
     */
    public static String VENTILATE_STR = "通风中";

    /**
     * 租赁中
     */
    public static String RENTING_STR = "租赁中";

    /**
     * 已租完
     */
    public static String RENTED_STR = "已租完";

    /**
     * 有客厅阳台
     */
    public static int HAVE_LIVING_BALCONY = 1;

    /**
     * 无客厅阳台
     */
    public static int NO_LIVING_BALCONY = 0;

    /**
     * 有生活阳台
     */
    public static int HAVE_LIFE_BALCONY = 1;

    /**
     * 无生活阳台
     */
    public static int NO_LIFE_BALCONY = 0;

    /**
     * 有
     */
    public static String HAVE_STR = "有";

    /**
     * 无
     */
    public static String NO_STR = "无";

    public static Map<Integer, String> homeTypeMap;

    static {
        homeTypeMap = new HashMap();

        homeTypeMap.put(DECORATING, DECORATING_STR);
        homeTypeMap.put(VENTILATE, VENTILATE_STR);
        homeTypeMap.put(RENTING, RENTING_STR);
        homeTypeMap.put(RENTED, RENTED_STR);
    }
}
