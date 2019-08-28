package com.example.demo.resolvers;

import com.example.demo.annotation.CurrentPayOrder;
import com.example.demo.constants.Constants;
import com.example.demo.entity.Order;
import com.example.demo.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.MethodParameter;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.support.WebDataBinderFactory;
import org.springframework.web.context.request.NativeWebRequest;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.method.support.HandlerMethodArgumentResolver;
import org.springframework.web.method.support.ModelAndViewContainer;
import org.springframework.web.multipart.support.MissingServletRequestPartException;

/**
 * 获取支付订单对象切面方法
 *
 * @author <a href="mailto:lishen@bjshenpu.com">liShen</a>
 * @version 1.0
 * @ClassName: CurrentPayOrderAspect
 * @Description:TODO
 * @Date: 2019/8/28 9:44
 * <p>
 * Date           Author          Version          Description
 * -----------------------------------------------------------------------------------
 * 2019/8/28       李珅              1.0              <初始创建>
 */
@Component
public class CurrentPayOrderResolver implements HandlerMethodArgumentResolver {

    @Autowired
    private OrderService orderService;

    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public boolean supportsParameter(MethodParameter parameter) {
        //如果参数类型是UnipayPayOrderBr并且有CurrentPayOrder注解则支持
        if (parameter.getParameterType().isAssignableFrom(Order.class) &&
                parameter.hasParameterAnnotation(CurrentPayOrder.class)) {
            return true;
        }
        return false;
    }

    @Override
    public Object resolveArgument(MethodParameter parameter, ModelAndViewContainer mavContainer, NativeWebRequest webRequest, WebDataBinderFactory binderFactory) throws Exception {
        //取出鉴权时存入的登录用户Id
        String serialNumber = webRequest.getAttribute(Constants.SERIAL_NUMBER_KEY, RequestAttributes.SCOPE_REQUEST).toString();
        if (serialNumber != null) {
            //从数据库中查询并返回
            return orderService.queryOrder(serialNumber);
        }
        throw new MissingServletRequestPartException(Constants.SERIAL_NUMBER_KEY);
    }
}
