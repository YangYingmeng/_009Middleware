package com.yym.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Inherited;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 领域能力注解，标识某个具体业务方法是能力扩展点
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/24 10:19
 */
@Inherited
@Target({ElementType.METHOD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainAbility {

    /**
     * 业务方法名称
     */
    String name();
}
