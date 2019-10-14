package com.tangdou.creational.builder.order;

import java.io.Serializable;

/**
 * @author: tangdoupapa
 * @Date: 2019/10/14
 * @Description: 主要用来构建各种不同的视频
 * @Version: V1.0
 */
public class MealBuilder implements Serializable {

    private static final long serialVersionUID = -1L;


    public Meal buildVegMeal() {
        Meal meal = new Meal();
        meal.addItem(new ItemVerBurger());
        meal.addItem(new ItemCoke());
        return meal;
    }

    public Meal buildChickenBurger() {
        Meal meal = new Meal();
        meal.addItem(new ItemChickenBurger());
        meal.addItem(new ItemPepsi());
        return meal;
    }
}
