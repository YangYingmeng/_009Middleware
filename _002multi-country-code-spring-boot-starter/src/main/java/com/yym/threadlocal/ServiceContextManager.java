package com.yym.threadlocal;

import com.yym.threadlocal.context.ServiceContext;

/**
 * 业务上下文管理器，存储和获取当前线程的业务上下文（ServiceContext）
 *
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/24 13:47
 */
public class ServiceContextManager {

    private static final ThreadLocal<ServiceContext> SERVICE_CONTEXT_THREAD_LOCAL = new ThreadLocal<>();

    /**
     * 获取当前线程的业务上下文
     */
    public static ServiceContext getServiceContext() {
        return SERVICE_CONTEXT_THREAD_LOCAL.get();
    }

    /**
     * 设置当前线程的业务上下文
     */
    public static void setServiceContext(ServiceContext context) {
        SERVICE_CONTEXT_THREAD_LOCAL.set(context);
    }

    /**
     * 清除当前线程的业务上下文
     */
    public static void clearServiceContext() {
        SERVICE_CONTEXT_THREAD_LOCAL.remove();
    }
}
