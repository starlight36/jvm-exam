package com.hist.order.bean;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class User implements Serializable{
    private String uid;
    private String name;
    private Map<Integer,String> addressInfoMap = new HashMap<>();
    private String defaultAddress;

    public User(String uid, String name, Map<Integer, String> addressInfoMap, String defaultAddress) {
        this.uid = uid;
        this.name = name;
        this.addressInfoMap = addressInfoMap;
        this.defaultAddress = defaultAddress;
    }

    public String getDefaultAddress() {
        return defaultAddress;
    }

    public void setDefaultAddress(int index) {
        defaultAddress = addressInfoMap.get(index);
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Map<Integer, String> getAddressInfoMap() {
        return addressInfoMap;
    }

    public void setAddressInfoMap(Map<Integer, String> addressInfoMap) {
        this.addressInfoMap = addressInfoMap;
    }
}
