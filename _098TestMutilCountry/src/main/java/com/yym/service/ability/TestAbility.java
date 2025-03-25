package com.yym.service.ability;

import java.util.List;

import org.springframework.stereotype.Component;

import com.yym.annotation.DomainAbility;
import com.yym.annotation.DomainAbilityEntrance;
import com.yym.entity.TestDTO;

/**
 * 域能力扩展点
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/25 9:59
 */
@Component
@DomainAbilityEntrance(entranceCode = "testDomain", entranceName = "测试域", entranceDesc = "测试域能力扩展点")
public interface TestAbility {

    @DomainAbility(name = "test")
    List<TestDTO> test(TestDTO dtoParam);
}
