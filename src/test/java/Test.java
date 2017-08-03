import com.alibaba.fastjson.JSON;
import com.hist.order.Application;
import com.hist.order.bean.Order;
import com.hist.order.config.DbConfig;
import com.hist.order.config.ErrorCodeConfig;
import com.hist.order.enumtype.OrderStatus;
import com.hist.order.exception.BusinessException;
import com.hist.order.service.OrderService;
import com.hist.order.vo.GoodsVo;
import com.hist.order.vo.OrderVo;
import org.junit.After;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationContextLoader;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.ArrayList;
import java.util.List;

/******************************************
 * @author: wangyuan
 * @createDate: 2017/8/3
 * @company: (C) Copyright 
 * @since: JDK 1.8
 * @Description:
 ******************************************/
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=Application.class, loader=SpringApplicationContextLoader.class)
@WebAppConfiguration
public class Test {
    private Logger logger = LoggerFactory.getLogger(Test.class);
    @Autowired
    private OrderService orderService;

    private Order order;


    //测试创建订单
    @Before
    public void createOrder(){
        logger.info("----初始化创建订单----");
        List<GoodsVo> goodsVoList  = new ArrayList<>();
        GoodsVo goodsVo1 = new GoodsVo("g0001",3);
        GoodsVo goodsVo2 = new GoodsVo("g0003",3);
        goodsVoList.add(goodsVo1);
        goodsVoList.add(goodsVo2);
        OrderVo orderVo = new OrderVo();
        orderVo.setUserId("u0001");
        orderVo.setGoodsVos(goodsVoList);
        orderVo.setAddressId(1);
        try {
            order = orderService.create(orderVo);
            System.out.println(JSON.toJSONString(order));
            logger.info("----创建订单完成----");
        } catch (Exception e) {
            if( e instanceof BusinessException){
                logger.error(ErrorCodeConfig.getErrorMsg(((BusinessException) e).getCode()));
            }else{
                e.printStackTrace();
            }

        }

    }
    //测试提交订单
    @org.junit.Test
    public void testSubmitOrder(){
        try {
            logger.info("---测试提交订单----");
            String orderNum = order.getOrderNum();
            orderService.submitOrder( orderNum);
            String status = OrderStatus.getOrderStatusMap().get( DbConfig.get(orderNum).getStatus());
            logger.info("订单状态{}",status);
            logger.info("---测试提交订单完成----");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @After
    public void testCancleOrder(){

        try {
            logger.info("---测试取消订单开始----");
            String orderNum = order.getOrderNum();
            orderService.cancleOrderByNum(orderNum);
            String status = OrderStatus.getOrderStatusMap().get( DbConfig.get(orderNum).getStatus());
            logger.info("订单状态{}",status);
            logger.info("---测试取消订单完成----");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
