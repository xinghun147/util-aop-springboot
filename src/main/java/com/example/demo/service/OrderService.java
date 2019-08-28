package com.example.demo.service;

import com.example.demo.entity.Order;

/**
 * 订单服务接口
 * 
 * @ClassName: OrderService 
 * @Date: 2019/8/28 13:38
 *  
 * Date           Author          Version          Description
 * -----------------------------------------------------------------------------------
 * 2019/8/28      李珅             1.0              <初始创建>
 *  
 * @author <a href="mailto:lishen@bjshenpu.com">liShen</a>
 * @version 1.0
 */
public interface OrderService {

    Order queryOrder(String serialNumber);
}
