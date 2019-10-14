package com.tangdou.creational.builder.order;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/13
 * @Description:  表示食品条目
 * @Version: V1.0
 */
public interface Item {

    public String name();

    public Packing packing();

    public float price();
}
