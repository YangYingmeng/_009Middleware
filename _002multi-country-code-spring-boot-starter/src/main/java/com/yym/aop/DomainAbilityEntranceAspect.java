package com.yym.aop;

import java.lang.reflect.Method;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.reflect.MethodSignature;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yym.AbilityFactory;

import lombok.extern.slf4j.Slf4j;


/**
 * 领域能力切面，拦截 `DomainAbilityEntrance` 入口，并动态调用 `bizCode` 对应的能力实现
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/24 10:54
 */
@Slf4j
@Aspect
@Component
public class DomainAbilityEntranceAspect {

    @Autowired
    private AbilityFactory abilityFactory;

    @Around("within(@com.yym.annotation.DomainAbilityEntrance *)")
    public Object aroundAbilityMethod(ProceedingJoinPoint joinPoint) throws Throwable {
        // 获取当前方法所属类
        Object target = joinPoint.getTarget();
        Class<?> abilityInterface = target.getClass().getInterfaces()[0]; // 获取能力接口

        // 使用 AbilityFactory 自动获取对应的能力实例
        Object abilityInstance = abilityFactory.getAbilityInstance(abilityInterface);
        if (abilityInstance == null) {
            throw new IllegalStateException("未找到合适的能力实例：" + abilityInterface.getSimpleName());
        }

        // 通过反射找到对应方法
        MethodSignature methodSignature = (MethodSignature) joinPoint.getSignature();
        Method method = abilityInstance.getClass().getMethod(
                methodSignature.getName(),
                methodSignature.getParameterTypes()
        );

        log.info("切面代理执行能力实例：{} -> {}", abilityInterface.getSimpleName(), abilityInstance.getClass().getSimpleName());

        // 执行实例方法
        return method.invoke(abilityInstance, joinPoint.getArgs());
    }
}
