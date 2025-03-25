package com.yym.service.ability.region;

import lombok.extern.slf4j.Slf4j;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yym.annotation.DomainAbilityInstance;
import com.yym.entity.TestDTO;
import com.yym.service.ability.TestAbility;

/**
 * 可以指定泰国版本为通用业务, 其它国家有定制化需求实现子方法即可
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/25 10:07
 */
@Slf4j
@Component
@DomainAbilityInstance(bizCode = "thailand")
public class ThailandTestAbility implements TestAbility {

    @Override
    public List<TestDTO> test(TestDTO dtoParam) {
        log.info("全部国家通用方法 test");
        return List.of();
    }
}
