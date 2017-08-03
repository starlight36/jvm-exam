package com.hist.order.bean;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class JsonResult {

    private Map<String, Object> data = new HashMap<>();
    private String code;
    private String msg;
    private String desc;
    private Long time = Long.valueOf((new Date()).getTime());


    public Map<String, Object> getData() {
        return data;
    }

    public void setData(Map<String, Object> data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public String getDesc() {
        return desc;
    }

    public void setDesc(String desc) {
        this.desc = desc;
    }

    public void put(String key, Object value) {
        this.data.put(key, value);
    }
}

