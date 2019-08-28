package com.example.demo.interceptor;

import com.example.demo.annotation.TokenAuthorization;
import com.example.demo.constants.Constants;
import com.example.demo.service.TokenService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.lang.reflect.Method;
import java.util.Map;

/**
 * token验证拦截器
 *
 * @ClassName:  TokenAuthorizationInterceptor
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
@Component
public class TokenAuthorizationInterceptor extends HandlerInterceptorAdapter {

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Autowired
    private TokenService tokenService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response, Object handler) throws Exception {
        //如果不是映射到方法直接通过
        if (!(handler instanceof HandlerMethod)) {
            return true;
        }
        HandlerMethod handlerMethod = (HandlerMethod) handler;
        Method method = handlerMethod.getMethod();
        //从header中得到token
        String token = request.getParameter(Constants.AUTHORIZATION_KEY);
        //验证token是否存在
        Map<String, Object> resultMap = tokenService.queryTokenInvalid(token);
        if(resultMap!=null){
            if (resultMap.get("bool") != null) {
                if (Boolean.parseBoolean(resultMap.get("bool").toString())){
                    //如果token验证成功，将token对应的流水号存在request中，便于之后注入
                    request.setAttribute(Constants.SERIAL_NUMBER_KEY, resultMap.get("serialNumber").toString());
                    return true;
                }
            }
        }


        //如果验证token失败，并且方法注明了Authorization，返回token村务
        if (method.getAnnotation(TokenAuthorization.class) != null) {
            //返回失败页面
            String url = "/token_invalid.html?startDate=" + System.currentTimeMillis();
            response.setCharacterEncoding("UTF-8");
            response.sendRedirect(url);
            //返回json
            /*response.setContentType("application/json; charset=utf-8");
            PrintWriter out = null;
            try {
                out = response.getWriter();
                out.append(JSONObject.toJSONString(requestResult));
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                if (out != null) {
                    out.close();
                }
            }*/
            return false;
        }
        return true;
    }
}
