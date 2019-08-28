package com.example.demo.controller;


import com.example.demo.annotation.MonitorRequest;
import com.example.demo.annotation.TokenAuthorization;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    /**
     * 添加了自定义注解@MonitorRequest AOP拦截
     * @return
     */
    @MonitorRequest
    @RequestMapping(value = "/test")
    public String test(){
        return "method be added @MonitorRequest";
    }

    /**
     * 没有添加自定义注解
     * @return
     */
    @RequestMapping(value = "test2")
    public String test2(){
        return "method not be added @MonitorRequest";
    }

    /**
     * 没有添加自定义注解 拦截器拦截
     * @return
     */
    @TokenAuthorization
    @RequestMapping(value = "test3")
    public String test3(){
        return "method be added @TokenAuthorization";
    }
}
