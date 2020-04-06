package com.tangdou.ihrm.company.application;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 09:56
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.tangdou")
@EntityScan("com.tangdou.ihrm.company.dao")
@EnableJpaRepositories(basePackages = "com.tangdou.ihrm.company.dao")
@EnableSwagger2
public class CompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class);
    }
}
