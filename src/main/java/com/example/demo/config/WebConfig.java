package com.example.demo.config;

import com.example.demo.interceptor.TokenAuthorizationInterceptor;
import com.example.demo.resolvers.CurrentPayOrderResolver;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

import java.util.List;

/**
 * 自定义拦截器配置类 
 * 
 * @ClassName: TokenAuthorizationConfig 
 * @Date: 2019/8/27 16:33
 *  
 * Date           Author          Version          Description
 * -----------------------------------------------------------------------------------
 * 2019/8/27      李珅             1.0              <初始创建>
 *  
 * @author <a href="mailto:lishen@bjshenpu.com">liShen</a>
 * @version 1.0
 */
@Configuration
public class WebConfig extends WebMvcConfigurerAdapter {

    @Autowired
    private TokenAuthorizationInterceptor tokenAuthorizationInterceptor;

    @Autowired
    private CurrentPayOrderResolver currentPayOrderResolver;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(tokenAuthorizationInterceptor).addPathPatterns("/**");
    }

    @Override
    public void addArgumentResolvers(List<HandlerMethodArgumentResolver> argumentResolvers) {
        argumentResolvers.add(currentPayOrderResolver);
    }
}
