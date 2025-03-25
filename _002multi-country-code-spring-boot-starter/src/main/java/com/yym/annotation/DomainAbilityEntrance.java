package com.yym.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 领域能力入口注解，用于标识某个业务域的入口
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/24 10:20
 */
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface DomainAbilityEntrance {

    /**
     * 能力入口唯一标识
     */
    String entranceCode();

    /**
     * 能力入口名称
     */
    String entranceName();

    /**
     * 能力入口描述
     */
    String entranceDesc() default "";
}
