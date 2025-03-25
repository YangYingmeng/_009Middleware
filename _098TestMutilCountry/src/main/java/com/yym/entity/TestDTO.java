package com.yym.entity;

import lombok.Data;

/**
 * 在bp领域可以使用VO 在业务领域使用对应的DO, 用泛型限制每个接口的域能力
 * 该测试案例为单体项目未涉及DDD领域, 使用DO限制接口领域能力
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/25 10:02
 */
@Data
public class TestDTO {

    private Long id;
}
