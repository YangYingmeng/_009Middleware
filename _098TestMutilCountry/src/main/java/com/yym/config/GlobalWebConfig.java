package com.yym.config;

import javax.annotation.Resource;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.yym.interceptor.AbilityInterceptor;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/25 14:29
 */
@Configuration
public class GlobalWebConfig implements WebMvcConfigurer {

    @Resource
    private AbilityInterceptor threadLocalInterceptor;

    @Override
    public void addInterceptors(InterceptorRegistry registry) {

        registry.addInterceptor(threadLocalInterceptor).addPathPatterns("/**");
    }
}
