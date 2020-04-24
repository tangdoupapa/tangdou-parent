package com.tangdou.spring.cloud.controller;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import com.tangdou.common.base.entity.Payment;
import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.spring.cloud.service.PaymentService;
import io.swagger.annotations.Api;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

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
    private int port;

    @Resource
    private DiscoveryClient discoveryClient;


    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("get/{id}")
    @HystrixCommand(fallbackMethod = "selectOneHandler", commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"),
    })
    public Result<Payment> selectOne(@PathVariable("id") String id) {
        Payment payment = this.paymentService.findById(id);
        //超时设置,feign超时测试
       /* try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }*/
        if (id.equals("1")) {
            throw new RuntimeException("复数");
        }
        return ResultUtil.successData(payment, "port=" + port);
    }

    private Result<Payment> selectOneHandler(@PathVariable("id") String id) {
        return ResultUtil.successMessage("超时处理……");
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("ok/{id}")
    public Result<Payment> selectOk(@PathVariable("id") String id) {
        Payment payment = this.paymentService.findById(id);
        return ResultUtil.successData(payment, "ok=" + port);
    }

    @PostMapping("create")
    public Result<Payment> create(@RequestBody Payment payment) {
        Payment insert = this.paymentService.save(payment);

        return ResultUtil.successData(payment, "insert success");
    }

    @GetMapping("discovery")
    public Object discovery() {
        List<String> services = discoveryClient.getServices();
        services.forEach(service -> {
            System.out.println("----service" + service);
        });
        List<ServiceInstance> instances = discoveryClient.getInstances("TANGDOU-SPRING-CLOUD-EUREKA-PROVIDER-8001");
        for (ServiceInstance instance : instances) {
            System.out.println(instance.getServiceId() + "\t" + instance.getHost() + "\t" + instance.getPort() + "\t" + instance.getUri());
        }

        return this.discoveryClient;
    }

    /*@GetMapping("lb")
    public String getPaymentLB() {
        return serverPort;
    }

    @GetMapping("feign/timeout")
    public String getFeignTimeOut() {
        try {
            TimeUnit.SECONDS.sleep(3);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return serverPort;
    }

    @GetMapping("zipkin")
    public String paymentZipkin() {
        return "hi,i`am paymentzipkin server fall back.welcome to atguigu.hahahahahhahahah";
    }*/
}