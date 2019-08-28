package com.example.demo.entity;

import java.time.LocalDateTime;
import java.util.Date;

/**
 * 订单类 
 * 
 * @ClassName: Order 
 * @Date: 2019/8/28 13:34
 *  
 * Date           Author          Version          Description
 * -----------------------------------------------------------------------------------
 * 2019/8/28      李珅             1.0              <初始创建>
 *  
 * @author <a href="mailto:lishen@bjshenpu.com">liShen</a>
 * @version 1.0
 */
public class Order {
    private String id;

    private String serialNumber;

    private LocalDateTime createDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getSerialNumber() {
        return serialNumber;
    }

    public void setSerialNumber(String serialNumber) {
        this.serialNumber = serialNumber;
    }

    public LocalDateTime getCreateDate() {
        return createDate;
    }

    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    @Override
    public String toString() {
        return "Order{" +
                "id='" + id + '\'' +
                ", serialNumber='" + serialNumber + '\'' +
                ", createDate=" + createDate +
                '}';
    }
}
