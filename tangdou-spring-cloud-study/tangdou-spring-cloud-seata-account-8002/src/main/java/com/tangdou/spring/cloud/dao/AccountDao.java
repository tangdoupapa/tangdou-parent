package com.tangdou.spring.cloud.dao;

import com.tangdou.common.dao.BaseRepository;
import com.tangdou.spring.cloud.entity.AccountEntity;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;

public interface AccountDao extends BaseRepository<AccountEntity, String> {

    @Query(value="update AccountEntity a set a.used = a.used + ?2,a.residue = a.residue - ?2 where a.id = ?1")
    @Modifying
    @Transactional
    void decrease(String userId, BigDecimal money);
}
