package com.yym.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 领域能力实例注解，用于标识某个业务身份（bizCode）的能力实现
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/24 10:21
 */
@Inherited
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainAbilityInstance {

    /**
     * 业务身份（bizCode），通常代表国家或地区
     */
    String bizCode();
}
