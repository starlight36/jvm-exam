package com.hist.order.config;

import java.util.HashMap;
import java.util.Map;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class ErrorCodeConfig {

    public static String OK ="ok";
    public static String ERR_NOT_FOUND_GOODS="ERR_NOT_FOUND_GOODS";
    public static String ERR_NOT_ENOUGH_GOODS="ERR_NOT_ENOUGH_GOODS";
    public static String ERR_NOT_FOUND_USERINFO="ERR_NOT_FOUND_USERINFO";
    public static String ERR_NOT_FOUND_ORDERINFO="ERR_NOT_FOUND_ORDERINFO";


    public static Map<String, String> map = new HashMap();

    static{
        map.put(ERR_NOT_FOUND_GOODS,"没有此商品信息");
        map.put(ERR_NOT_ENOUGH_GOODS,"库存没有那么多商品");
        map.put(ERR_NOT_FOUND_USERINFO,"没有找到此用户信息");
        map.put(ERR_NOT_FOUND_ORDERINFO,"没有找到此订单信息");

    }

    public ErrorCodeConfig() {
    }

    public static boolean hasErrorCode(String errorCode) {
        if( null == errorCode || "".equals(errorCode)){
            return false;
        }
        return map.containsKey(errorCode);
    }

    public static String getErrorMsg(String errorCode) {
        return map.containsKey(errorCode)?(String)map.get(errorCode):"未定义错误";
    }


}
