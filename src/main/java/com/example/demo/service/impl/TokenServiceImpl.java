package com.example.demo.service.impl;

import com.example.demo.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

/**
 * token验证服务实现类
 *
 * @ClassName:  TokenServiceImpl
 * @Description:TODO
 * @Date: 2019/8/28 11:24
 *
 * Date           Author          Version          Description
 * -----------------------------------------------------------------------------------
 * 2019/8/28       李珅              1.0              <初始创建>
 *
 * @author <a href="mailto:lishen@bjshenpu.com">liShen</a>
 * @version 1.0
 */
@Service
public class TokenServiceImpl implements TokenService {

    private static Logger logger = LoggerFactory.getLogger(TokenServiceImpl.class);



    /**
    * 判断token是否失效
    *
    * @Title: queryTokenInvalid
    * @description: TODO
    * @param: token
    * @return: boolean
    * @author: 李珅
    * @date: 2019/8/27  14:38
    */
    @Override
    public Map<String,Object> queryTokenInvalid(String token) {
        Map<String,Object> resultMap = new HashMap<>();
        resultMap.put("bool",Boolean.TRUE);
        resultMap.put("serialNumber", "8a8ba02d6cd60d88016cd60d8cc70000");
        return resultMap;
    }
}
