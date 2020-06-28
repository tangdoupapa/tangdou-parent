package com.tangdou.ihrm.company.application;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 09:56
 * @Description:
 */
@SpringBootApplication(scanBasePackages = "com.tangdou")
@MapperScan("com.tangdou.**.dao")
@EnableSwagger2
public class CompanyApplication {

    public static void main(String[] args) {
        SpringApplication.run(CompanyApplication.class);
    }
}
