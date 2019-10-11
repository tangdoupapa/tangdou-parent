package com.tangdou.creational.builder;


import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/11
 * @Description:
 * @Version: V1.0
 */
public abstract class Builder implements Serializable {

    private static final long serialVersionUID = -1L;

    protected Product product = new Product();

    public abstract void buildPartA();

    public abstract void buildPartB();

    public abstract void buildPartC();

    public Product getProduct() {
        return product;
    }

}
