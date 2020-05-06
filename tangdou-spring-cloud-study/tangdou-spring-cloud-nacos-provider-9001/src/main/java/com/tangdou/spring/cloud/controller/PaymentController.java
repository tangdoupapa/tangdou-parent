package com.tangdou.spring.cloud.controller;

import com.tangdou.common.base.entity.Payment;
import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.spring.cloud.service.PaymentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2020-03-06 14:22:26
 */
@Api
@RestController
@RequestMapping("payment")
public class PaymentController {
    /**
     * 服务对象
     */
    @Resource
    private PaymentService paymentService;

    @Value("${server.port}")
    private String port;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    public Result<Payment> selectOne(@PathVariable("id") String id) {
        Payment payment = this.paymentService.findById(id);
        return ResultUtil.successData(payment, "select success "+port+"!");
    }

    @PostMapping("create")
    public Result<Payment> create(@RequestBody Payment payment) {
        Payment insert = this.paymentService.save(payment);
        System.out.println(insert);
        System.out.println("1234567890");
        return ResultUtil.successData(payment, "insert success");
    }

}