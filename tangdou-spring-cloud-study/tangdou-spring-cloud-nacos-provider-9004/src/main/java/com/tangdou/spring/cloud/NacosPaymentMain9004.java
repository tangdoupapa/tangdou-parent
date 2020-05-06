package com.tangdou.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.tangdou"})
@EntityScan("com.tangdou")
@EnableJpaRepositories(basePackages = "com.tangdou.spring.cloud.dao")
@EnableSwagger2
@EnableDiscoveryClient
public class NacosPaymentMain9004 {

    public static void main(String[] args) {
        SpringApplication.run(NacosPaymentMain9004.class, args);
    }
}
