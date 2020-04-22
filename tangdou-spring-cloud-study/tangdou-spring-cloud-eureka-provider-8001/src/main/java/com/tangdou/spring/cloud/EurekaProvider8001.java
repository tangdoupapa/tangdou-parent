package com.tangdou.spring.cloud;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.tangdou"})
@EntityScan("com.tangdou")
@EnableJpaRepositories(basePackages = "com.tangdou.spring.cloud.dao")
@EnableSwagger2
public class EurekaProvider8001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaProvider8001.class, args);
    }
}
