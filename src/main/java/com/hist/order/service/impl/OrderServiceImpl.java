package com.hist.order.service.impl;

import com.hist.order.bean.Goods;
import com.hist.order.bean.Order;
import com.hist.order.bean.User;
import com.hist.order.config.DbConfig;
import com.hist.order.config.ErrorCodeConfig;
import com.hist.order.enumtype.OrderStatus;
import com.hist.order.exception.BusinessException;
import com.hist.order.service.OrderService;
import com.hist.order.vo.GoodsVo;
import com.hist.order.vo.OrderVo;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
@Service
public class OrderServiceImpl implements OrderService{
    @Override
    public Order create(OrderVo orderVo) throws Exception {
        List<GoodsVo> buyGoods = getGoods(orderVo.getGoodsVos());
        if(buyGoods.size()>0){
            User userInfo =  DbConfig.getUserInfo(orderVo.getUserId());
            if( null == userInfo){
                throw  new BusinessException(ErrorCodeConfig.ERR_NOT_FOUND_USERINFO);
            }
            Order order = new Order();
            order.setOrderNum(generateOrderNum());
            order.setUser(userInfo);
            order.setBuyGoods(buyGoods);
            order.setTotalPrice(caluTotalPrice(buyGoods));
            order.setStatus(OrderStatus.INIT.getCode());
            DbConfig.set(order);
            changeGoodsAmount(buyGoods,true);
            return  order;
        }
       return null;

    }

    @Override
    public void submitOrder(String orderNum) {
        Order result = DbConfig.get(orderNum);
        if( null==result){
            throw new BusinessException(ErrorCodeConfig.ERR_NOT_FOUND_ORDERINFO);
        }
        result.setStatus(OrderStatus.SUBMIT.getCode());

    }

    @Override
    public void cancleOrderByNum(String orderNum) {
        Order result = DbConfig.get(orderNum);
        if( null==result){
            throw new BusinessException(ErrorCodeConfig.ERR_NOT_FOUND_ORDERINFO);
        }
        result.setStatus(OrderStatus.CANCALE.getCode());
        changeGoodsAmount(result.getBuyGoods(),true);
    }

    /**
     *
     * @param goodsVos
     * @param flag  true 取消订单时，把原来购买商品重新添加到库存中
     *              false  创建订单时，把要购买的商品去库存中减去。
     */
    private void changeGoodsAmount(List<GoodsVo> goodsVos,boolean flag){
        for(GoodsVo goodsVo : goodsVos){
            Goods goodsInfo = DbConfig.getGoodsInfo(goodsVo.getId());
            int amunt = flag?goodsInfo.getAmount()+goodsVo.getAmount():
                    goodsInfo.getAmount()-goodsVo.getAmount();
            goodsInfo.setAmount(amunt);
        }
    }


    private String generateOrderNum(){
        return UUID.randomUUID().toString();
    }

    private List<GoodsVo> getGoods(List<GoodsVo> goodsVos) throws Exception {
        List<GoodsVo> goodsVoList = new ArrayList<>();
        for(GoodsVo goodsVo :goodsVos){
            Goods goodsInfo = DbConfig.getGoodsInfo(goodsVo.getId());
            if( null == goodsInfo ){
                throw new BusinessException(ErrorCodeConfig.ERR_NOT_FOUND_GOODS);
            }
            if( goodsVo.getBuyAmoumt()>goodsInfo.getAmount() ){
                throw  new BusinessException(ErrorCodeConfig.ERR_NOT_ENOUGH_GOODS);
            }
            goodsVo.setName(goodsInfo.getName());
            goodsVo.setAmount(goodsInfo.getAmount());
            goodsVo.setDescription(goodsInfo.getDescription());
            goodsVo.setPrice(goodsInfo.getPrice());
            goodsVo.setGoodsTotalPrice(goodsVo.getBuyAmoumt()*goodsInfo.getPrice());

            goodsVoList.add(goodsVo);
        }
        return goodsVoList;
    }

    private int caluTotalPrice(List<GoodsVo> goodsVos){
        int totalPrice = 0;
        for(GoodsVo goodsVo : goodsVos){
            totalPrice += goodsVo.getBuyAmoumt()*DbConfig.getGoodsInfo(goodsVo.getId()).getPrice();
        }
        return totalPrice;

    }
}
