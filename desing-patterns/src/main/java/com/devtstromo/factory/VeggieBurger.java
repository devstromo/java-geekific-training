package com.devtstromo.factory;

public class VeggieBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Vegetarian Burger");
    }
}
