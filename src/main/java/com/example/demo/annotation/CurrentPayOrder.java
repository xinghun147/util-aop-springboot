package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在Controller的方法参数中使用此注解，该方法在映射时会注入当前登录的支付订单对象
 * 
 * @ClassName: PayOrder 
 * @Date: 2019/8/28 9:42
 *  
 * Date           Author          Version          Description
 * -----------------------------------------------------------------------------------
 * 2019/8/28      李珅             1.0              <初始创建>
 *  
 * @author <a href="mailto:lishen@bjshenpu.com">liShen</a>
 * @version 1.0
 */
@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
public @interface CurrentPayOrder {

}
