package com.tangdou.spring.cloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.tangdou"}, exclude = DataSourceAutoConfiguration.class)
@EntityScan("com.tangdou")
@EnableJpaRepositories(basePackages = "com.tangdou.spring.cloud.dao")
@EnableSwagger2
@EnableDiscoveryClient
@EnableAutoDataSourceProxy(useJdkProxy = true)
public class AccountMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(AccountMain8001.class, args);
    }
}
