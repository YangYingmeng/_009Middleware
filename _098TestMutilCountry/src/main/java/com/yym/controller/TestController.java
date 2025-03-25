package com.yym.controller;

import lombok.RequiredArgsConstructor;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.yym.entity.TestDTO;
import com.yym.service.test.TestDomainService;

/**
 * 测试接口
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/25 9:57
 */
@RestController
@RequestMapping("/v1/test")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class TestController {

    private final TestDomainService testDomainService;

    /**
     * 测试
     */
    @PostMapping(value = "/test")
    public List<TestDTO> test(TestDTO param) {

        return testDomainService.test(param);
    }
}
