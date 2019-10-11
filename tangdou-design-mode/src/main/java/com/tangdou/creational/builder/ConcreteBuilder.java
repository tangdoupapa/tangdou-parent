package com.tangdou.creational.builder;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/12
 * @Description:
 * @Version: V1.0
 */
public class ConcreteBuilder extends Builder implements Serializable {

    private static final long serialVersionUID = -1L;

    public void buildPartA() {
        product.setPartA("A");
    }

    public void buildPartB() {
        product.setPartB("B");
    }

    public void buildPartC() {
        product.setPartC("C");
    }
}
