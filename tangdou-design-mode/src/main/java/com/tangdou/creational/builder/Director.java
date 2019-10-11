package com.tangdou.creational.builder;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/12
 * @Description:
 * @Version: V1.0
 */
public class Director implements Serializable {

    private static final long serialVersionUID = -1L;

    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Product build(){
        builder.buildPartA();
        builder.buildPartB();
        builder.buildPartC();
        return builder.getProduct();
    }
}
