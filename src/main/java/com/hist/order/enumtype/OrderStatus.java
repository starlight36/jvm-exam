package com.hist.order.enumtype;

import java.util.HashMap;
import java.util.Map;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public enum OrderStatus {
    INIT((short)1,"初始下单"),
    PAYING((short)2,"支付中"),
    PAYED((short)3,"支付成功"),
    SEND_OFF((short)4,"已发货") ,
    SUCCESS((short)5,"交易成功") ,
    APPLY_REFUND((short)6,"退货申请中"),
    AGREE_REFUND((short)7,"已同意退货"),
    REFUND_SUCCESS((short)8,"退货成功"),
    REFUSE_REFUND((short)9,"拒绝退货"),
    SUBMIT((short)10,"提交订单"),
    CANCALE((short)11,"取消订单"),
    CLOSED((short)99,"交易关闭");


    private final short code;
    private final String name;

    private OrderStatus(short code, String name) {
        this.code = code;
        this.name = name;

    }

    public short getCode() {
        return code;
    }

    public String getName() {
        return name;
    }


    public static Map<Short,String> getOrderStatusMap(){
        Map<Short,String> map = new HashMap<Short,String>();
        for(OrderStatus status:values()){
            map.put(status.getCode(),status.getName());
        }
        return map;
    }

}
