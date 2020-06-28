package com.tangdou.spring.cloud;

import io.seata.spring.annotation.datasource.EnableAutoDataSourceProxy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages = {"com.tangdou"}, exclude = DataSourceAutoConfiguration.class)
@MapperScan(basePackages = "com.tangdou.**.dao")
@EnableSwagger2
@EnableDiscoveryClient
@EnableAutoDataSourceProxy(useJdkProxy = true)
public class StorageMain8001 {

    public static void main(String[] args) {
        SpringApplication.run(StorageMain8001.class, args);
    }
}
