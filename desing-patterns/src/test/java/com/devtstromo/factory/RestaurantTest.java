package com.devtstromo.factory;

import org.junit.jupiter.api.Test;

class RestaurantTest {

    @Test
    public void testFactoryMethod() {
        Restaurant beefRestaurant = new BeefBurgerRestaurant();
        Burger beefBurger = beefRestaurant.orderBurger();


        Restaurant veggieRestaurant = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieRestaurant.orderBurger();
    }

}