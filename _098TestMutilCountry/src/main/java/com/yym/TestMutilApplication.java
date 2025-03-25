package com.yym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

/**
 * @Author: Yym
 * @Version: 1.0
 * @Date: 2025/3/24 17:47
 */
@EnableAspectJAutoProxy
@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackages = "com.yym")
public class TestMutilApplication {

    public static void main(String[] args) {

        SpringApplication.run(TestMutilApplication.class, args);
        System.out.println("++ TestMutilApplication start ++");
    }

}
