package com.tangdou.structural.decorator;

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
        AbstractBattercake battercake = new Battercake();
        battercake = new EggDecorator(battercake);
        battercake = new EggDecorator(battercake);
        battercake = new SausageDecorator(battercake);
        System.out.println("售价" + battercake.cost() + "  " + battercake.getDesc());
    }

}
