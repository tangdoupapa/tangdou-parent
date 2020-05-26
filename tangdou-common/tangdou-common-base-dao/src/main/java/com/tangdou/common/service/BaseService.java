package com.tangdou.common.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.tangdou.common.dao.BaseRepository;

import java.io.Serializable;

public interface BaseService<R extends BaseRepository<T, ID>, T extends Serializable, ID> extends IService<T> {

}
