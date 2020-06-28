package com.tangdou.spring.cloud;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.tangdou"})
@MapperScan(basePackages = "com.tangdou.**.dao")
@EnableSwagger2
@EnableEurekaClient
@EnableDiscoveryClient // @EnableDiscoveryClient 配合@EnableEurekaClient同时使用
public class EurekaProvider8001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider8001.class, args);
    }
}
