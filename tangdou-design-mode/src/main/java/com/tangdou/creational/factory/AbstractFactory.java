package com.tangdou.creational.factory;

import com.tangdou.creational.factory.entity.ProductA;
import com.tangdou.creational.factory.entity.ProductB;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/9
 * @Description:
 * @Version: V1.0
 */
public interface AbstractFactory {

    ProductA createProductA();

    ProductB createProductB();
}
