package com.tangdou.creational.factory;

import com.tangdou.creational.factory.entity.Product;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/9/17
 * @Description: 测试类
 * @Version: V1.0
 */
public class Cliect implements Serializable {

    private static final long serialVersionUID = -1L;

    public static void main(String[] args) {
        //测试简单工厂
        Product product1 = SimpleFactory.getProduct(1);
        Product product2 = SimpleFactory.getProduct(2);
        System.out.println("product1 class = " + product1.getClass());
        System.out.println("product2 class = " + product2.getClass());

        //测试工厂方法
        FactoryMethod factoryMethod1 = new FactoryMethod1();
        Product productMethod1 = factoryMethod1.createProduct();
        System.out.println("productMethod1 class = " + productMethod1.getClass());
        FactoryMethod factoryMethod2 = new FactoryMethod1();
        Product productMethod2 = factoryMethod2.createProduct();
        System.out.println("productMethod2 class = " + productMethod2.getClass());
    }
}
