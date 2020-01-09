package com.tangdou.structural.facade;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description:
 * @Version: V1.0
 */
public class PointsPaymentService implements Serializable {

    private static final long serialVersionUID = -1L;

    public boolean pay(PointGift pointGift) {
        //扣减积分
        return true;
    }

}
