package com.tangdou.common.service.impl;

import com.tangdou.common.dao.BaseRepository;
import com.tangdou.common.service.BaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;

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

    @Override
    public void delete(ID id) {
        baseRepository.deleteById(id);
    }

    @Override
    public T findById(ID id) {
        return baseRepository.findById(id).orElse(null);
    }

    protected Specification<T> getSpec(String companyId) {
        /**
         * root: 对象数据   cb:构造查询条件
         */
        return (root, criteriaQuery, criteriaBuilder) -> criteriaBuilder.equal(root.get("companyId").as(String.class), companyId);
    }
}
