package com.yym.service.ability.region;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yym.annotation.DomainAbilityInstance;
import com.yym.entity.TestDTO;
import com.yym.service.ability.TestAbility;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/25 10:07
 */
@Slf4j
@Component
@DomainAbilityInstance(bizCode = "japan")
public class JapanTestAbility extends ThailandTestAbility implements TestAbility {

    @Override
    public List<TestDTO> test(TestDTO dtoParam) {
        log.info("日本定制化test需求");
        return List.of();
    }
}
