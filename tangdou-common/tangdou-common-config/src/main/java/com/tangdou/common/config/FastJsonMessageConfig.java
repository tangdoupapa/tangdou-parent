package com.tangdou.common.config;

import com.alibaba.fastjson.support.spring.FastJsonHttpMessageConverter;
import com.tangdou.common.util.FastJsonUtil;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;
import org.springframework.http.converter.HttpMessageConverter;

import java.util.ArrayList;
import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/4/6 18:52
 * @Description:
 */
@Configuration
public class FastJsonMessageConfig {

    @Bean
    public HttpMessageConverter fastJsonHttpMessageConverters() {
        FastJsonHttpMessageConverter fastJsonHttpMessageConverter = new FastJsonHttpMessageConverter();
        List<MediaType> fastMediaTypes = new ArrayList<>();
        fastMediaTypes.add(MediaType.APPLICATION_JSON);
        fastJsonHttpMessageConverter.setSupportedMediaTypes(fastMediaTypes);
        fastJsonHttpMessageConverter.setFastJsonConfig(FastJsonUtil.getFastJsonConfig());
        return fastJsonHttpMessageConverter;
    }
}
