package com.tangdou.structural.facade;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description:
 * @Version: V1.0
 */
public class ShippingService implements Serializable {

    private static final long serialVersionUID = -1L;

    public String shipGife(PointGift pointGift) {
        return "物流订单号";
    }

}
