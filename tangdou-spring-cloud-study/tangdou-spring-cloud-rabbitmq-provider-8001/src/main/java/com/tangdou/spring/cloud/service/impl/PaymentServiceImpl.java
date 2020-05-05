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

}