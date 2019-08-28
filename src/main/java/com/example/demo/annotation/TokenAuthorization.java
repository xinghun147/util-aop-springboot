package com.example.demo.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 在Controller的方法上使用此注解，该方法在映射时会检查token是否失效
 *
 * @ClassName:  TokenAuthorization
 * @Description:TODO
 * @Date: 2019/8/28 9:43
 *
 * Date           Author          Version          Description
 * -----------------------------------------------------------------------------------
 * 2019/8/28       李珅              1.0              <初始创建>
 *
 * @author <a href="mailto:lishen@bjshenpu.com">liShen</a>
 * @version 1.0
 */
@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface TokenAuthorization {
}
