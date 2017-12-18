package com.fsr.constant;

/**
 * Created by Hasee on 2017/5/11.
 */
public interface ContractConstant {
    /**
     * 单间承租合同
     */
    int ROOM_CONTRACT = 1;

    /**
     * 承租房屋合同
     */
    int HOUSE_CONTRACT = 2;

    /**
     * 单间承租合同
     */
    String ROOM_CONTRACT_STR = "单间租赁";

    /**
     * 承租房屋合同
     */
    String HOUSE_CONTRACT_STR = "房屋承租";


    /**
     * 按月支付
     */
     int MONTH_PAID = 1;

    /**
     * 季度支付
     */
    int SEASON_PAID = 2;

    /**
     * 半年支付
     */
    int HALFYEAR_PAID = 3;

    /**
     * 年支付
     */
    int YEAR_PAID = 4;

    /**
     * 按月支付
     */
    String MONTH_PAID_STR = "按月支付";

    /**
     * 季度支付
     */
    String SEASON_PAID_STR = "季度支付";

    /**
     * 半年支付
     */
    String HALFYEAR_PAID_STR = "半年支付";

    /**
     * 年支付
     */
    String YEAR_PAID_STR = "按年支付";


    /**
     * 递增
     */
    int INCREMENT = 1;

    /**
     * 不递增
     */
    int NON_INCREMENT = 2;

    /**
     * 递增
     */
    String INCREMENT_STR = "是";

    /**
     * 不递增
     */
    String NON_INCREMENT_STR = "否";
}
