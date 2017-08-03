package com.hist.order.vo;

import java.util.ArrayList;
import java.util.List;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class OrderVo {
    private List<GoodsVo> goodsVos =  new ArrayList<>();
    private Integer totalPrice;
    private String userId;
    private int addressId;

    public List<GoodsVo> getGoodsVos() {
        return goodsVos;
    }

    public void setGoodsVos(List<GoodsVo> goodsVos) {
        this.goodsVos = goodsVos;
    }

    public Integer getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Integer totalPrice) {
        this.totalPrice = totalPrice;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }
}
