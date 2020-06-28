package com.tangdou.spring.cloud.service.impl;

import com.tangdou.common.service.impl.BaseServiceImpl;
import com.tangdou.common.util.IdWorker;
import com.tangdou.spring.cloud.dao.SeataOrderRepository;
import com.tangdou.spring.cloud.entity.OrderEntity;
import com.tangdou.spring.cloud.service.AccountService;
import com.tangdou.spring.cloud.service.OrderService;
import com.tangdou.spring.cloud.service.StorageService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * (order)表服务实现类
 *
 * @author makejava
 * @since 2020-03-06 14:22:26
 */
@Service
@Slf4j
public class OrderServiceImpl extends BaseServiceImpl<SeataOrderRepository, OrderEntity, String> implements OrderService {

    @Autowired
    private IdWorker idWorker;

    @Resource
    private SeataOrderRepository orderDao;
    @Resource
    private StorageService storageService;
    @Resource
    private AccountService accountService;

    @GlobalTransactional(name = "fsp_tx_group", rollbackFor = Exception.class)
    @Transactional
    @Override
    public void create(OrderEntity order) {
        log.info("-------->开始创建新订单");
        order.setId(idWorker.nextIdToString());
        orderDao.insert(order);
        log.info("--------订单微服务开始调用库存,做扣减");
        storageService.decrease(order.getProductId(), order.getCount());
        log.info("-------订单微服务开始调用库存，做扣减end");

        log.info("-------订单微服务开始调用账户，做扣减");
        accountService.decrease(order.getUserId(), order.getMoney());
        log.info("-------订单微服务开始调用账户，做扣减end");
        log.info("-------修改订单状态");
        order.setStatus(0);
        orderDao.insert(order);
        log.info("-------修改订单状态结束");

        log.info("--------下订单结束了，哈哈哈哈");
    }
}
