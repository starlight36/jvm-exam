package com.hist.order.config;

import com.hist.order.bean.Goods;
import com.hist.order.bean.Order;
import com.hist.order.bean.User;

import java.util.HashMap;
import java.util.Map;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class DbConfig {
    private static Map<String,Goods> goodsInfoMap =new HashMap<>();
    private static Map<String,User> userInfoMap = new HashMap<>();
    private static Map<String,Order> orderInfoMap = new HashMap<>();

    public static void set(Order order){
        orderInfoMap.put(order.getOrderNum(),order);

    }
    public static Order get(String orderNum){
       return  orderInfoMap.get(orderNum);
    }

    public static Goods getGoodsInfo(String goodsNum){
        return  goodsInfoMap.get(goodsNum);
    }
    public static User getUserInfo(String uid){
        return userInfoMap.get(uid);
    }

    static{
        goodsInfoMap.put("g0000",new Goods("g0000","牙刷","这是牙刷",200,10));
        goodsInfoMap.put("g0001",new Goods("g0001","牙膏","这是牙膏",500,20));
        goodsInfoMap.put("g0002",new Goods("g0002","笔记本","这是笔记本",300000,30));
        goodsInfoMap.put("g0003",new Goods("g0003","手机","这是手机",60000,100));

        Map<Integer,String> user1Addressinfo  = new HashMap<>();
        user1Addressinfo.put(0,"beijing");
        user1Addressinfo.put(1,"tianjin");
        user1Addressinfo.put(2,"jiaozuo");

        Map<Integer,String> user2Addressinfo  = new HashMap<>();
        user2Addressinfo.put(0,"dalian");
        user2Addressinfo.put(1,"shijiazhuang");
        user2Addressinfo.put(2,"shanghai");
        userInfoMap.put("u0001",new User("u0001","张三",user1Addressinfo,user1Addressinfo.get(0)));
        userInfoMap.put("u0002",new User("u0002","李四",user2Addressinfo,user2Addressinfo.get(0)));


    }


}
