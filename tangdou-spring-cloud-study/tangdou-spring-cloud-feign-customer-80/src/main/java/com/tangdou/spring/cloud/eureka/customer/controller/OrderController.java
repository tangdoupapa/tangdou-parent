package com.tangdou.spring.cloud.eureka.customer.controller;

import com.tangdou.common.base.entity.Payment;
import com.tangdou.common.base.result.DataResult;
import com.tangdou.common.base.result.Result;
import com.tangdou.spring.cloud.eureka.customer.service.PaymentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Api
@RestController
@RequestMapping("comsumer")
public class OrderController {

//    public static final String PAYENT_URL = "http://localhost:8001";

    public static final String PAYENT_URL = "http://TANGDOU-SPRING-CLOUD-EUREKA-PROVIDER-8001";
    @Resource
    private RestTemplate restTemplate;

    @Autowired
    private PaymentService paymentService;


    @GetMapping("payment/create")
    public Result<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYENT_URL + "/payment/create", payment, DataResult.class);
    }

    @GetMapping("payment/selectOne/{id}")
    public Result<Payment> getPayment(@PathVariable("id") String id) {
        return restTemplate.getForObject(PAYENT_URL + "/payment/get/" + id, DataResult.class);
    }

    @GetMapping("payment/feign/selectOne/{id}")
    public Result<Payment> getPaymentFromFeign(@PathVariable("id") String id) {
        return paymentService.selectOne(id);
    }

}
