package com.tangdou.spring.cloud.service;

import com.tangdou.common.service.BaseService;
import com.tangdou.spring.cloud.dao.StorageDao;
import com.tangdou.spring.cloud.entity.StorageEntity;

import java.sql.SQLException;

public interface StorageService extends BaseService<StorageDao, StorageEntity, String> {

    void decrease(String productId, Integer count);
}
