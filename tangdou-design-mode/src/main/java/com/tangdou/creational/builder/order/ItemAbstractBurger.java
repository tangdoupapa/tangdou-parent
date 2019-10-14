package com.tangdou.creational.builder.order;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/13
 * @Description:
 * @Version: V1.0
 */
public abstract class ItemAbstractBurger implements Item, Serializable {

    private static final long serialVersionUID = -1L;

    public Packing packing() {
        return new PackingWrapper();
    }

    public abstract float price();
}
