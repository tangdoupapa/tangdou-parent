package com.tangdou.spring.cloud.service;

import com.tangdou.common.service.BaseService;
import com.tangdou.spring.cloud.dao.AccountDao;
import com.tangdou.spring.cloud.entity.AccountEntity;

import java.math.BigDecimal;

public interface AccountService extends BaseService<AccountDao, AccountEntity, String> {

    void decrease(String userId, BigDecimal money);
}
