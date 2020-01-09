package com.tangdou.structural.decorator;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description:
 * @Version: V1.0
 */
public class Battercake extends AbstractBattercake implements Serializable {

    private static final long serialVersionUID = -1L;

    @Override
    protected String getDesc() {
        return "煎饼";
    }

    @Override
    protected int cost() {
        return 8;
    }
}
