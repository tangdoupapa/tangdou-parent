package com.tangdou.spring.cloud.eureka.server;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@EnableEurekaServer
@SpringBootApplication
public class EurekaServerBootstrap7001 {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerBootstrap7001.class, args);
    }
}

