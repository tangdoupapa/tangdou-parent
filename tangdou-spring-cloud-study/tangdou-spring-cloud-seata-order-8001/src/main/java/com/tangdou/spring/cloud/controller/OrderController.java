package com.tangdou.spring.cloud.controller;

import com.tangdou.common.base.result.Result;
import com.tangdou.common.base.util.ResultUtil;
import com.tangdou.spring.cloud.entity.OrderEntity;
import com.tangdou.spring.cloud.service.OrderService;
import io.swagger.annotations.Api;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * (Payment)表控制层
 *
 * @author makejava
 * @since 2020-03-06 14:22:26
 */
@Api
@RestController
public class OrderController {
    /**
     * 服务对象
     */
    @Resource
    private OrderService orderService;

    @GetMapping("/order/create")
    public Result create(OrderEntity order) {
        orderService.create(order);
        return ResultUtil.successMessage("订单创建成功！");
    }

}