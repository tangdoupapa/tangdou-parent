package com.tangdou.structural.decorator;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description: 装饰者 - 加一个鸡蛋
 * @Version: V1.0
 */
public class EggDecorator extends AbstractDecorator implements Serializable {

    private static final long serialVersionUID = -1L;

    public EggDecorator(AbstractBattercake abstractBattercake) {
        super(abstractBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "加一个鸡蛋";
    }

    @Override
    protected int cost() {
        return super.cost() + 1;
    }
}
