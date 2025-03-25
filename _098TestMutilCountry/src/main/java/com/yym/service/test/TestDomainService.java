package com.yym.service.test;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yym.AbilityFactory;
import com.yym.entity.TestDTO;
import com.yym.service.ability.TestAbility;

import lombok.extern.slf4j.Slf4j;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/25 10:50
 */
@Slf4j
@Service
public class TestDomainService {

    @Autowired
    private AbilityFactory abilityFactory;

    public List<TestDTO> test(TestDTO param) {

        TestAbility testAbility = abilityFactory.getAbilityInstance(TestAbility.class);
        return testAbility.test(param);
    }
}
