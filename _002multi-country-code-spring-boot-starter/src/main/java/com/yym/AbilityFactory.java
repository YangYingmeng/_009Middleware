package com.yym;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;

import com.yym.annotation.DomainAbilityInstance;
import com.yym.threadlocal.ServiceContextManager;
import com.yym.threadlocal.context.ServiceContext;

import lombok.extern.slf4j.Slf4j;

/**
 * 领域能力工厂类，负责加载和管理不同 `bizCode` 的能力实例
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/24 10:23
 */
@Slf4j
public class AbilityFactory {

    @Autowired
    private ApplicationContext applicationContext;

    public <T> T getAbilityInstance(Class<T> abilityInterface) {
        ServiceContext context = ServiceContextManager.getServiceContext();
        String region = context.getRegion();
        Map<String, T> instances = applicationContext.getBeansOfType(abilityInterface);
        for (Map.Entry<String, T> entry : instances.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            DomainAbilityInstance abilityInstance =
                    clazz.getAnnotation(DomainAbilityInstance.class);
            if (abilityInstance != null && abilityInstance.bizCode().equals(region)) {
                return entry.getValue();
            }
        }
        return this.getAbilityInstance(abilityInterface, "global");  // fallback to global if not found
    }

    public <T> T getAbilityInstance(Class<T> abilityInterface, String region) {
        Map<String, T> instances = applicationContext.getBeansOfType(abilityInterface);
        for (Map.Entry<String, T> entry : instances.entrySet()) {
            Class<?> clazz = entry.getValue().getClass();
            DomainAbilityInstance abilityInstance =
                    clazz.getAnnotation(DomainAbilityInstance.class);
            if (abilityInstance != null && abilityInstance.bizCode().equals(region)) {
                return entry.getValue();
            }
        }
        return null;
    }
}
