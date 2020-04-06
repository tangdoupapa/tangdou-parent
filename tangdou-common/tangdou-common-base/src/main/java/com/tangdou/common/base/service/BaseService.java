package com.tangdou.common.base.service;

import com.tangdou.common.base.dao.BaseRepository;

import java.util.List;

public interface BaseService<R extends BaseRepository<T, ID>, T, ID> {
    /**
     * @Auther: tangdouopapa
     * @Description: 通用的保存数据
     * @Date: 2020/3/29 9:34
     * @Param: T 保存的实体对象
     * @return: T 返回保存的实体对象(含有id)
     */
    T save(T t);

    /**
     * @Auther: tangdouopapa
     * @Description: 更新的修改数据
     * @Date: 2020/3/29 9:34
     * @Param: T 更新的实体对象
     * @return: T 返回更新的实体对象(含有id)
     */
    T update(T t);

    /**
     * 查询全部数据
     *
     * @return
     */
    List<T> findAll();

    /**
     * 删除数据
     *
     * @param id
     * @return
     */
    void delete(ID id);

    /**
     * @Auther: tangdouopapa
     * @Description: 根据id查询实体
     * @Param: T 保存的实体对象
     * @return: T 返回保存的实体对象(含有id)
     */
    T findById(ID id);
}
