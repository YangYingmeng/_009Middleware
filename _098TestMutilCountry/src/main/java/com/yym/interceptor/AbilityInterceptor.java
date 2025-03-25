package com.yym.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.yym.threadlocal.ServiceContextManager;
import com.yym.threadlocal.context.ServiceContext;

/**
 * 设置国家标识到上下文
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/25 9:50
 */
@Component
public class AbilityInterceptor implements HandlerInterceptor {

    /**
     * 区域(国家)标识
     */
    @Value("${region}")
    private String region;

    /**
     * 调用时间：Controller方法处理之前
     * 执行顺序：链式Interceptor情况下,Intercepter按照声明的顺序一个接一个执行
     * 若返回false,则中断执行,注意：不会进入afterCompletion
     */
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        ServiceContext context = new ServiceContext();
        context.setRegion(region);
        ServiceContextManager.setServiceContext(context);
        return true;
    }

    /**
     * 调用前提：preHandler 返回true
     * 调用时间：DispatcherServlet进行视图渲染之后
     * 多用于清理资源
     */
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex)
            throws Exception {
        // 防止内存泄露
        ServiceContextManager.clearServiceContext();
    }
}
