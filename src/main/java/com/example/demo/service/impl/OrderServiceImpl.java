package com.example.demo.service.impl;
import java.time.LocalDateTime;

import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.springframework.stereotype.Service;

/**
 * 订单服务实现类 
 * 
 * @ClassName: OrderServiceImpl 
 * @Date: 2019/8/28 13:39
 *  
 * Date           Author          Version          Description
 * -----------------------------------------------------------------------------------
 * 2019/8/28      李珅             1.0              <初始创建>
 *  
 * @author <a href="mailto:lishen@bjshenpu.com">liShen</a>
 * @version 1.0
 */
@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public Order queryOrder(String serialNumber) {
        Order order = new Order();
        order.setId("12345");
        order.setSerialNumber("67890");
        order.setCreateDate(LocalDateTime.now());
        return order;
    }
}
