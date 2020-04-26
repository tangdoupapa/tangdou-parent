package com.tangdou.spring.cloud.eureka.customer.config;

import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class GatewayConfig {

    @Bean
    public RouteLocator customRouteLocator(RouteLocatorBuilder builder) {
        RouteLocatorBuilder.Builder routes = builder.routes();
        routes.route("guonei_path", f -> f.path("/guonei").uri("http://news.baidu.com/guonei"));
        routes.route("guonei_path", f -> f.path("/guoji").uri("http://news.baidu.com/guoji"));
        return routes.build();
    }
}
