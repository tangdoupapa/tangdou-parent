package com.tangdou.spring.cloud.dao;

import com.tangdou.common.dao.BaseRepository;
import com.tangdou.spring.cloud.entity.StorageEntity;
import org.apache.ibatis.annotations.Update;
import org.springframework.transaction.annotation.Transactional;

public interface StorageDao extends BaseRepository<StorageEntity, String> {

    @Update(value="update StorageEntity a set a.used = a.used + ?2,a.residue = a.residue -?2\n" +
            "        where a.productId = ?1")
    @Transactional
    void decrease(String productId, Integer count);
}
