package com.tangdou.creational.factory;

import com.tangdou.creational.factory.entity.Product;
import com.tangdou.creational.factory.entity.ProductEntity1;
import com.tangdou.creational.factory.entity.ProductEntity2;
import com.tangdou.creational.factory.entity.ProductEntity3;

/**
 * @author: tangdoupapa
 * @Date: 2019/9/15
 * @Description: 简单工厂
 * @Version: V1.0
 */
public class SimpleFactory {

    public static Product getProduct(Integer type) {
        if (type == 1) {
            return new ProductEntity1();
        } else if (type == 2) {
            return new ProductEntity2();
        } else if (type == 3) {
            return new ProductEntity3();
        } else {
            return new ProductEntity1();
        }
    }

}


