package com.example.demo.service;

import java.util.Map;

/**
 * token验证服务
 *
 * @ClassName:  TokenService
 * @Description:TODO
 * @Date: 2019/8/28 11:23
 *
 * Date           Author          Version          Description
 * -----------------------------------------------------------------------------------
 * 2019/8/28       李珅              1.0              <初始创建>
 *
 * @author <a href="mailto:lishen@bjshenpu.com">liShen</a>
 * @version 1.0
 */
public interface TokenService {

    Map<String,Object> queryTokenInvalid(String token);

}
