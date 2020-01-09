package com.tangdou.structural.decorator;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description:
 * @Version: V1.0
 */
public abstract class AbstractDecorator extends AbstractBattercake implements Serializable {

    private static final long serialVersionUID = -1L;

    private AbstractBattercake abstractBattercake;

    public AbstractDecorator(AbstractBattercake abstractBattercake) {
        this.abstractBattercake = abstractBattercake;
    }

    @Override
    protected String getDesc() {
        return abstractBattercake.getDesc();
    }

    @Override
    protected int cost() {
        return abstractBattercake.cost();
    }
}
