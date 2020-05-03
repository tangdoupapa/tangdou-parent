package com.tangdou.spring.cloud.eureka.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient
@EnableConfigServer
public class ConfigBootstrap3344 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigBootstrap3344.class, args);
    }
}
