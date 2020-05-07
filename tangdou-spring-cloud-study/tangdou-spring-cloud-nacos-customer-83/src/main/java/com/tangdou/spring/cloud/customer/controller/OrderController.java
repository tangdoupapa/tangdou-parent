package com.tangdou.spring.cloud.customer.controller;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import com.alibaba.csp.sentinel.slots.block.BlockException;
import com.tangdou.common.base.entity.Payment;
import com.tangdou.common.base.result.DataResult;
import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.ResultUtil;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import javax.annotation.Resource;

@Api
@RestController
@RequestMapping("comsumer")
public class OrderController {

//    public static final String PAYENT_URL = "http://localhost:8001";

    //        public static final String PAYENT_URL = "http://tangdou-spring-cloud-nacos-provider";
    public static final String PAYENT_URL = "http://tangdou-spring-cloud-nacos-config";
    @Resource
    private RestTemplate restTemplate;


    @GetMapping("payment/create")
    public Result<Payment> create(Payment payment) {
        return restTemplate.postForObject(PAYENT_URL + "/payment/create", payment, DataResult.class);
    }

    @GetMapping("payment/selectOne/{id}")
    public Result<Payment> getPayment(@PathVariable("id") long id) {
        return restTemplate.getForObject(PAYENT_URL + "/payment/get/" + id, DataResult.class);
    }

    @GetMapping("payment/select/{id}")
    public Result<Payment> getPaymentOther(@PathVariable("id") long id) {
//        int a= 10/0;
        return restTemplate.getForObject(PAYENT_URL + "/payment/get/" + id, DataResult.class);
    }

    @GetMapping("payment/select")
    @SentinelResource(value = "comsumerPaymentSelect",blockHandler = "blockHandler")
    public Result<Payment> getPaymentParam(@RequestParam(value = "id", required = false) long id) {
//        int a= 10/0;
        return restTemplate.getForObject(PAYENT_URL + "/payment/get/" + id, DataResult.class);
    }

    public Result<Payment> blockHandler(BlockException e){
        return ResultUtil.successData(null,"热点规则出发");
    }


}
