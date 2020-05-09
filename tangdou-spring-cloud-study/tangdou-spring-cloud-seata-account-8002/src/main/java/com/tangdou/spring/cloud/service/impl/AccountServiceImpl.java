package com.tangdou.spring.cloud.service.impl;

import com.tangdou.common.service.impl.BaseServiceImpl;
import com.tangdou.spring.cloud.dao.AccountDao;
import com.tangdou.spring.cloud.entity.AccountEntity;
import com.tangdou.spring.cloud.service.AccountService;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.math.BigDecimal;

@Service
@Slf4j
public class AccountServiceImpl extends BaseServiceImpl<AccountDao, AccountEntity, String> implements AccountService {

    @Resource
    private AccountDao accountDao;

    @Override
    public void decrease(String userId, BigDecimal money) {
        log.info("账户扣除余额开始---");
        int a = 10/0;
        accountDao.decrease(userId, money);
        log.info("账户扣除余额结束---");
    }
}
