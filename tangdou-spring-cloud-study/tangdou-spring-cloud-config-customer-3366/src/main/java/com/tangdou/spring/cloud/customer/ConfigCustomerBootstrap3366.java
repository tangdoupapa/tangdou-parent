package com.tangdou.spring.cloud.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableSwagger2
public class ConfigCustomerBootstrap3366 {

    public static void main(String[] args) {
        SpringApplication.run(ConfigCustomerBootstrap3366.class, args);
    }
}
