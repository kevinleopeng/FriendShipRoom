package com.fsr.constant;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Hasee on 2017/5/11.
 */
public class RoomConstant {
    /**
     * 主卧
     */
    public static int MASTER_BEDROOM = 1;

    /**
     * 隔断
     */
    public static int CUTOFF_BEDROOM = 2;

    /**
     * 次卧
     */
    public static int LYINGDOWN_BEDROOM = 3;

    /**
     * 小次卧
     */
    public static int SLYINGDOWN_BEDROOM = 4;

    /**
     * 主卧
     */
    public static String MASTER_BEDROOM_STR = "主卧";

    /**
     * 隔断
     */
    public static String CUTOFF_BEDROOM_STR = "隔断间";

    /**
     * 次卧
     */
    public static String LYINGDOWN_BEDROOM_STR = "次卧";

    /**
     * 小次卧
     */
    public static String SLYINGDOWN_BEDROOM_STR = "小次卧";

    /**
     * 有
     */
    public static int HAVE = 1;

    /**
     * 没有
     */
    public static int NO = 0;

    public static String HAVE_STR = "有";

    public static String NO_STR = "无";

    public static String IS_STR = "是";

    public static String NON_STR = "否";

    public static Map<Integer, String> roomTypeMap;

    static {
        roomTypeMap = new HashMap();

        roomTypeMap.put(MASTER_BEDROOM, MASTER_BEDROOM_STR);
        roomTypeMap.put(CUTOFF_BEDROOM, CUTOFF_BEDROOM_STR);
        roomTypeMap.put(LYINGDOWN_BEDROOM, LYINGDOWN_BEDROOM_STR);
        roomTypeMap.put(SLYINGDOWN_BEDROOM, SLYINGDOWN_BEDROOM_STR);
    }
}
