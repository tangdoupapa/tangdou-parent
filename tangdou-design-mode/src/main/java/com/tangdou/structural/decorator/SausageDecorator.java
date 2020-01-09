package com.tangdou.structural.decorator;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2020/1/9
 * @Description:  装饰者 - 香肠
 * @Version: V1.0
 */
public class SausageDecorator extends AbstractDecorator implements Serializable {

    private static final long serialVersionUID = -1L;

    public SausageDecorator(AbstractBattercake abstractBattercake) {
        super(abstractBattercake);
    }

    @Override
    protected String getDesc() {
        return super.getDesc() + "加一个香肠 ";
    }

    @Override
    protected int cost() {
        return super.cost() + 2;
    }
}
