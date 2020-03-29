package com.tangdou.common.base.service.impl;

import com.tangdou.common.base.dao.BaseRepository;
import com.tangdou.common.base.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 09:27
 * @Description:
 */
public class BaseServiceImpl<R extends BaseRepository<T, ID>, T, ID> implements BaseService<R, T, ID> {

    @Autowired
    BaseRepository<T, ID> baseRepository;

    @Override
    public T save(T t) {
        return baseRepository.save(t);
    }

    @Override
    public T update(T t) {
        return baseRepository.save(t);
    }

    @Override
    public List<T> findAll() {
        return baseRepository.findAll();
    }
}
