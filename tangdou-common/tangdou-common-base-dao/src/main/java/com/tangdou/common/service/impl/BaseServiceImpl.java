package com.tangdou.common.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.tangdou.common.dao.BaseRepository;
import com.tangdou.common.service.BaseService;

import java.io.Serializable;

/**
 * @Auther: tangdouopapa
 * @Date: 2020/3/29 09:27
 * @Description:
 */
public class BaseServiceImpl<R extends BaseRepository<T, ID>, T extends Serializable, ID>
        extends ServiceImpl<BaseRepository<T, ID>, T> implements BaseService<R, T, ID> {

    protected QueryWrapper<T> getSpec(String companyId){
        return new QueryWrapper<T>().eq("company_id",companyId);
    }
}