package com.devtstromo.factory;

import org.junit.jupiter.api.Test;

import com.devtstromo.factory.method.BeefBurgerRestaurant;
import com.devtstromo.factory.method.Burger;
import com.devtstromo.factory.method.Restaurant;
import com.devtstromo.factory.method.VeggieBurgerRestaurant;

class RestaurantTest {

    @Test
    public void testFactoryMethod() {
        Restaurant beefRestaurant = new BeefBurgerRestaurant();
        Burger beefBurger = beefRestaurant.orderBurger();


        Restaurant veggieRestaurant = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieRestaurant.orderBurger();
    }

}