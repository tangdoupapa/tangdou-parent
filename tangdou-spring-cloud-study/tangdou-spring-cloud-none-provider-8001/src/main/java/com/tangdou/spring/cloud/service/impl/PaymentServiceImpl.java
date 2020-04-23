package com.tangdou.spring.cloud.service.impl;

import com.tangdou.common.base.entity.Payment;
import com.tangdou.common.service.impl.BaseServiceImpl;
import com.tangdou.spring.cloud.dao.PaymentDao;
import com.tangdou.spring.cloud.service.PaymentService;
import org.springframework.stereotype.Service;

/**
 * (Payment)表服务实现类
 *
 * @author makejava
 * @since 2020-03-06 14:22:26
 */
@Service("paymentService")
public class PaymentServiceImpl extends BaseServiceImpl<PaymentDao, Payment, String> implements PaymentService {
    /*@Resource
    private PaymentDao paymentDao;

    *//**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     *//*
    @Override
    public Payment queryById(String id) {
        return this.paymentDao.queryById(id);
    }

    *//**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     *//*
    @Override
    public List<Payment> queryAllByLimit(int offset, int limit) {
        return this.paymentDao.queryAllByLimit();
    }

    *//**
     * 新增数据
     *
     * @param payment 实例对象
     * @return 实例对象
     *//*
    @Override
    public Payment insert(Payment payment) {
        this.paymentDao.insert(payment);
        return payment;
    }

    *//**
     * 修改数据
     *
     * @param payment 实例对象
     * @return 实例对象
     *//*
    @Override
    public Payment update(Payment payment) {
        this.paymentDao.update(payment);
        return this.queryById(payment.getId());
    }

    *//**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 是否成功
     *//*
    @Override
    public boolean deleteById(Long id) {
        return this.paymentDao.deleteById(id) > 0;
    }*/
}