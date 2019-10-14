package com.tangdou.creational.builder;

import com.tangdou.creational.builder.order.Meal;
import com.tangdou.creational.builder.order.MealBuilder;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/12
 * @Description:
 * @Version: V1.0
 */
public class Client implements Serializable {

    private static final long serialVersionUID = -1L;

    public static void main(String[] args) {
        Builder builder = new ConcreteBuilder();
        Director director = new Director(builder);
        Product product = director.build();

        //建造者模式-订单
        MealBuilder mealBuilder = new MealBuilder();
        Meal meal = mealBuilder.buildChickenBurger();
        meal.showItems();
        System.out.println("总价： " + meal.getCost());
    }
}
