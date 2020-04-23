package com.tangdou.common.service;

import com.tangdou.common.base.request.PagerRequest;
import com.tangdou.common.dao.BaseRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.jpa.domain.Specification;

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

    /**
     * @Auther: tangdouopapa
     * @Description: 查询分页数据
     * @Param: pagerRequest 前端分页参数
     * @return: Page<T> 返回分页数据
     */
    Page<T> findPage(PagerRequest pagerRequest);

    /**
     * @Auther: tangdouopapa
     * @Description: 查询分页数据
     * @Param: pagerRequest 前端分页参数
     * @return: Page<T> 返回分页数据
     */
    Page<T> findPage(PagerRequest pagerRequest, Specification<T> specification);
}
