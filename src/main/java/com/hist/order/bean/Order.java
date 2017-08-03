package com.hist.order.bean;

import com.hist.order.vo.GoodsVo;

import java.io.Serializable;
import java.util.List;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:  订单信息
 ******************************************/

public class Order implements Serializable {
    private String orderNum;
    private List<GoodsVo> buyGoods;
    private int totalPrice;
    private User user;
    private short status;
    private int addressId;

    public int getAddressId() {
        return addressId;
    }

    public void setAddressId(int addressId) {
        this.addressId = addressId;
    }

    public Order(){

    }

    public Order(String orderNum, List<GoodsVo> buyGoods, int totalPrice, User user, short status) {
        this.orderNum = orderNum;
        this.buyGoods = buyGoods;
        this.totalPrice = totalPrice;
        this.user = user;
        this.status = status;
    }

    public String getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(String orderNum) {
        this.orderNum = orderNum;
    }

    public List<GoodsVo> getBuyGoods() {
        return buyGoods;
    }

    public void setBuyGoods(List<GoodsVo> buyGoods) {
        this.buyGoods = buyGoods;
    }

    public int getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(int totalPrice) {
        this.totalPrice = totalPrice;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public short getStatus() {
        return status;
    }

    public void setStatus(short status) {
        this.status = status;
    }
}