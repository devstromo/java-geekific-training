package com.devstromo.factory.method;

public class VeggieBurger implements Burger {

    @Override
    public void prepare() {
        System.out.println("Vegetarian Burger");
    }
}
