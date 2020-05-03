package com.tangdou.spring.cloud.customer.controller;

import com.tangdou.common.base.entity.Payment;
import com.tangdou.common.base.result.DataResult;
import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Api
@RestController
@RefreshScope
@RequestMapping("comsumer")
public class OrderController {

    public static final String PAYENT_URL = "http://localhost:8001";

    //    public static final String PAYENT_URL = "http://CLOUD-PAYMENT-SERVICE";
    @Resource
    private RestTemplate restTemplate;

    @Value("${felix.name}")
    private String felixName;


    @GetMapping("payment/create")
    public Result<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYENT_URL + "/payment/create", payment, DataResult.class);
    }

    @GetMapping("payment/selectOne/{id}")
    public Result<Payment> getPayment(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYENT_URL + "/payment/get/" + id, DataResult.class);
    }

    @GetMapping("name")
    public Result<String> getName() {
        return ResultUtil.success(felixName);
    }

}
