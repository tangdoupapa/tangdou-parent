package com.tangdou.spring.cloud.dao;

import com.tangdou.common.dao.BaseRepository;
import com.tangdou.spring.cloud.entity.OrderEntity;

/**
 * (Payment)表数据库访问层
 *
 * @author makejava
 * @since 2020-03-06 14:22:26
 */
public interface SeataOrderRepository extends BaseRepository<OrderEntity, String> {


}