package com.hist.order.service;

import com.hist.order.bean.Order;
import com.hist.order.vo.OrderVo;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
public interface OrderService {
    public Order create(OrderVo orderVo) throws Exception;

    public void submitOrder(String orderNum) throws Exception;

    void cancleOrderByNum(String orderNum) throws Exception;
}
