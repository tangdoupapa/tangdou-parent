package com.tangdou.spring.cloud.eureka.customer;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.hystrix.EnableHystrix;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@SpringBootApplication(exclude = {DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableSwagger2
@EnableEurekaClient
@EnableDiscoveryClient
// value 指服务名   configuration- 提供规则的config类(该类不能被 @ComponentScan 扫描到 )  定制访问指定服务的规则策略
//@RibbonClient(value = "TANGDOU-SPRING-CLOUD-EUREKA-PROVIDER-8001", configuration = IRuleConfig.class)
@EnableHystrix
public class HystrixCustomerBootstrap {

    public static void main(String[] args) {
        SpringApplication.run(HystrixCustomerBootstrap.class, args);
    }
}
