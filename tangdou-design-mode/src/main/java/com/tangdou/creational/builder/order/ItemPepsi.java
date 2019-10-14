package com.tangdou.creational.builder.order;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/13
 * @Description:
 * @Version: V1.0
 */
public class ItemPepsi extends ItemAbstractColdDrink implements Serializable {

    private static final long serialVersionUID = -1L;

    public String name() {
        return "可口可乐";
    }

    public float price() {
        return 20;
    }
}
