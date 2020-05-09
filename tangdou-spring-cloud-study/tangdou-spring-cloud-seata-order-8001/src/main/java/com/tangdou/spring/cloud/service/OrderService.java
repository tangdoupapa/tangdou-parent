package com.tangdou.spring.cloud.service;

import com.tangdou.common.service.BaseService;
import com.tangdou.spring.cloud.dao.SeataOrderRepository;
import com.tangdou.spring.cloud.entity.OrderEntity;

/**
 * (order)表服务接口
 *
 * @author makejava
 * @since 2020-03-06 14:22:26
 */
public interface OrderService extends BaseService<SeataOrderRepository, OrderEntity, String> {

    void create(OrderEntity order);

}