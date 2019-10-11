package com.tangdou.creational.builder;

import java.io.Serializable;
import java.util.Arrays;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/12
 * @Description:
 * @Version: V1.0
 */
public class Client implements Serializable {

    private static final long serialVersionUID = -1L;

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.build();
    }
}
