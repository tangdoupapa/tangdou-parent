package com.tangdou.creational.builder.order;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/13
 * @Description:  饮料瓶
 * @Version: V1.0
 */
public class PackingBottle implements Packing, Serializable {

    private static final long serialVersionUID = -1L;

    public String pack() {
        return "bottle";
    }
}
