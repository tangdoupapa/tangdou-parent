package com.tangdou.spring.cloud.eureka.customer.config;

import feign.Logger;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FeignLoggerConfig {

    @Bean
    public Logger.Level getFeignLoggerLevel() {
        return Logger.Level.HEADERS;
    }
}
