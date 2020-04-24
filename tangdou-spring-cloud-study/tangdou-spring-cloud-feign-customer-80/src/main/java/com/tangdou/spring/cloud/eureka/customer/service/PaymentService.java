package com.tangdou.spring.cloud.eureka.customer.service;

import com.tangdou.common.base.entity.Payment;
import com.tangdou.common.base.result.DataResult;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Service
@FeignClient(value = "TANGDOU-SPRING-CLOUD-EUREKA-PROVIDER-8001")
public interface PaymentService {

    @GetMapping("payment/get/{id}")
    DataResult<Payment> selectOne(@PathVariable("id") String id);

}
