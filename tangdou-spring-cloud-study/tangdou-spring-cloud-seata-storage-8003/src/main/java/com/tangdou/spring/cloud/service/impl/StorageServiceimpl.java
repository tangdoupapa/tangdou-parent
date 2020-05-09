package com.tangdou.spring.cloud.service.impl;

import com.tangdou.common.service.impl.BaseServiceImpl;
import com.tangdou.spring.cloud.dao.StorageDao;
import com.tangdou.spring.cloud.entity.StorageEntity;
import com.tangdou.spring.cloud.service.StorageService;
import io.seata.rm.DefaultResourceManager;
import io.seata.rm.datasource.ConnectionProxy;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;

@Service
@Slf4j
public class StorageServiceimpl extends BaseServiceImpl<StorageDao, StorageEntity, String> implements StorageService {

    @Resource
    private StorageDao storageDao;

    @Autowired
    private DataSource dataSource;

    @Override
    public void decrease(String productId, Integer count){
        log.info("库存扣减开始----");
        storageDao.decrease(productId, count);
        log.info("库存扣减结束----");
    }
}
