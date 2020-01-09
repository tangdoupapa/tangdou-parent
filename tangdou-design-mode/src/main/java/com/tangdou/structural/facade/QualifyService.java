package com.tangdou.structural.facade;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description:
 * @Version: V1.0
 */
public class QualifyService implements Serializable {

    private static final long serialVersionUID = -1L;

    public boolean isAvailable(PointGift pointGift) {
        System.out.println("校验" + pointGift.getName() + " 积分资格通过");
        return true;
    }

}
