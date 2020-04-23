package com.tangdou.spring.cloud.service;

import com.tangdou.common.base.entity.Payment;
import com.tangdou.common.service.BaseService;
import com.tangdou.spring.cloud.dao.PaymentDao;

/**
 * (Payment)表服务接口
 *
 * @author makejava
 * @since 2020-03-06 14:22:26
 */
public interface PaymentService extends BaseService<PaymentDao, Payment, String> {

   /* *//**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     *//*
    Payment queryById(Long id);

    *//**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     *//*
    List<Payment> queryAllByLimit(int offset, int limit);

    *//**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     *//*
    Payment insert(Payment payment);

    *//**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     *//*
    Payment update(Payment payment);

    *//**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     *//*
    boolean deleteById(Long id);
*/
}