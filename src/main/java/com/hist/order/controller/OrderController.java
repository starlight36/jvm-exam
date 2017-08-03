package com.hist.order.controller;

import com.hist.order.bean.JsonResult;
import com.hist.order.bean.Order;
import com.hist.order.service.OrderService;
import com.hist.order.vo.OrderVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
@RestController
public class OrderController extends BaseController {

    @Autowired
    private OrderService orderService;

    //创建订单
    @RequestMapping("/create")
    public JsonResult createOrder(@RequestBody OrderVo orderVo){
        JsonResult jsonResult = createSuccessResult();

        try {
            Order order = orderService.create(orderVo);
            jsonResult.put("order",order);
        } catch (Exception e) {
            handleException(e,jsonResult);
        }
        return jsonResult;



    }
    //订单提交
    @RequestMapping(value = "/submitOrder")
    public JsonResult submitOrder(@RequestBody Order order){
        JsonResult jsonResult = createSuccessResult();
        try {
            orderService.submitOrder(order.getOrderNum());
        } catch (Exception e) {
            handleException(e,jsonResult);
        }
        return jsonResult;
    }
    //取消订单
    @RequestMapping(value = "cancaleOrder")
    public JsonResult cancaleOrder(@RequestBody Order order){
        JsonResult jsonResult = new JsonResult();
        try {
            orderService.cancleOrderByNum(order.getOrderNum());
        } catch (Exception e) {
           handleException(e,jsonResult);
        }
        return jsonResult;

    }






}
