package com.tangdou.creational.factory;

import com.tangdou.creational.factory.entity.Product;

/**
 * @author: tangdoupapa
 * @Date: 2019/9/17
 * @Description:  工厂方法模式 - 工厂接口
 * @Version: V1.0
 */
public interface FactoryMethod {

    Product createProduct();
}
