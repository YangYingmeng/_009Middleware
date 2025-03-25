package com.yym;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication(scanBasePackages = "com.yym")
public class TestApplication {
    public static void main(String[] args) {

        SpringApplication.run(TestApplication.class, args);
        System.out.println("++ TestApplication start ++");
    }
}
