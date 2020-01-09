package com.tangdou.structural.facade;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description:
 * @Version: V1.0
 */
public class GifeExchangeService implements Serializable {

    private static final long serialVersionUID = -1L;

    private QualifyService qualifyService;

    private PointsPaymentService pointsPaymentService;

    private ShippingService shippingService;

    public void setQualifyService(QualifyService qualifyService) {
        this.qualifyService = qualifyService;
    }

    public void setPointsPaymentService(PointsPaymentService pointsPaymentService) {
        this.pointsPaymentService = pointsPaymentService;
    }

    public void setShippingService(ShippingService shippingService) {
        this.shippingService = shippingService;
    }

    public void giftExchange(PointGift pointGift) {
        if (qualifyService.isAvailable(pointGift)) {
            if (pointsPaymentService.pay(pointGift)) {
                String s = shippingService.shipGife(pointGift);
                System.out.println("下单成功,订单为：" + s);
            }
        }
    }
}
