package com.tangdou.creational.builder.order;

import java.io.Serializable;
import java.util.List;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/13
 * @Description: 一顿饭
 * @Version: V1.0
 */
public class Meal implements Serializable {

    private static final long serialVersionUID = -1L;

    private List<Item> items;

    public void addItem(Item item) {
        this.items.add(item);
    }

    public float getCost() {
        Double sum = items.stream().mapToDouble(Item::price).sum();
        return sum.floatValue();
    }

    public void showItems() {
        this.items.forEach(o -> System.out.println("Item:" + o.name() + "  Packing:" + o.packing().pack() + "price:" + o.price()));
    }

}
