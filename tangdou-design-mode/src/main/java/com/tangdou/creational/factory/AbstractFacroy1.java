package com.tangdou.creational.factory;

import com.tangdou.creational.factory.entity.ProductA;
import com.tangdou.creational.factory.entity.ProductA1;
import com.tangdou.creational.factory.entity.ProductB;
import com.tangdou.creational.factory.entity.ProductB1;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/9
 * @Description:
 * @Version: V1.0
 */
public class AbstractFacroy1 implements AbstractFactory, Serializable {

    private static final long serialVersionUID = -1L;

    @Override
    public ProductA createProductA() {
        return new ProductA1();
    }

    @Override
    public ProductB createProductB() {
        return new ProductB1();
    }
}
