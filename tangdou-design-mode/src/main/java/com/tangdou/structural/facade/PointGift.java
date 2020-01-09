package com.tangdou.structural.facade;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description:
 * @Version: V1.0
 */
public class PointGift implements Serializable {

    private static final long serialVersionUID = -1L;

    private String name;

    public PointGift(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
