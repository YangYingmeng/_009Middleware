package com.yym.threadlocal.context;

import java.io.Serializable;

import lombok.Data;

/**
 * 业务上下文对象，存储当前请求的业务身份信息
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/24 13:51
 */
@Data
public class ServiceContext implements Serializable {

    /**
     * 区域信息（可用于区分国家）
     */
    private String region;

    /**
     * 业务身份（bizCode）
     */
    private String bizCode;
}
