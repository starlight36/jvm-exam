package com.hist.order.vo;

import java.util.List;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public class OrderRequestVo {
    private List<GoodsVo> goodsVos;

    public List<GoodsVo> getGoodsVos() {
        return goodsVos;
    }

    public void setGoodsVos(List<GoodsVo> goodsVos) {
        this.goodsVos = goodsVos;
    }
}
