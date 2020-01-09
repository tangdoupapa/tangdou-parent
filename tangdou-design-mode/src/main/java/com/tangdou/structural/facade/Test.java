package com.tangdou.structural.facade;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description:
 * @Version: V1.0
 */
public class Test implements Serializable {

    private static final long serialVersionUID = -1L;

    public static void main(String[] args) {
        PointGift pointGift = new PointGift("sdfas");
        GifeExchangeService gifeExchangeService = new GifeExchangeService();
        gifeExchangeService.setPointsPaymentService(new PointsPaymentService());
        gifeExchangeService.setQualifyService(new QualifyService());
        gifeExchangeService.setShippingService(new ShippingService());

        gifeExchangeService.giftExchange(pointGift);
    }
}
