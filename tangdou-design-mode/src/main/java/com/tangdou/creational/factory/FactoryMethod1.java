package com.tangdou.creational.factory;

import com.tangdou.creational.factory.entity.Product;
import com.tangdou.creational.factory.entity.ProductEntity1;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/9/17
 * @Description: 工厂方法模式 - 工厂1：创建产品1
 * @Version: V1.0
 */
public class FactoryMethod1 implements FactoryMethod, Serializable {

    private static final long serialVersionUID = -1L;

    @Override
    public Product createProduct(){
        return new ProductEntity1();
    }
}
