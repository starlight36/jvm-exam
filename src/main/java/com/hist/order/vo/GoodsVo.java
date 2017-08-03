package com.hist.order.vo;

import com.hist.order.bean.Goods;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class GoodsVo extends Goods {
    //购买数量
    private int buyAmoumt;
    //价格  数量*单价
    private int goodsTotalPrice;

    public int getGoodsTotalPrice() {
        return goodsTotalPrice;
    }

    public void setGoodsTotalPrice(int goodsTotalPrice) {
        this.goodsTotalPrice = goodsTotalPrice;
    }

    public GoodsVo(){}

    public GoodsVo(String gid,int buyAmoumt){
        super(gid);
        this.buyAmoumt = buyAmoumt;
    }

    public int getBuyAmoumt() {
        return buyAmoumt;
    }

    public void setBuyAmoumt(int buyAmoumt) {
        this.buyAmoumt = buyAmoumt;
    }
}
