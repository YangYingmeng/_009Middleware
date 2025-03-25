package com.yym.configuration;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

import com.yym.AbilityFactory;

/**
 * SPI 自动配置类
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/24 14:14
 */
@Configuration
@ComponentScan(basePackages = "com.yym")
@EnableAspectJAutoProxy // 配置类启动切面 其它配置均用spring方式注入容器
@EnableConfigurationProperties
public class AbilityConfig {
    /**
     * 提供 AbilityFactory 实例
     *
     * @return AbilityFactory
     */
    @Bean
    public AbilityFactory abilityFactory() {
        return new AbilityFactory();
    }
}
