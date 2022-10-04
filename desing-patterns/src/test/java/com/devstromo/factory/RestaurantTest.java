package com.devstromo.factory;

import org.junit.jupiter.api.Test;

import com.devstromo.factory.method.BeefBurgerRestaurant;
import com.devstromo.factory.method.Burger;
import com.devstromo.factory.method.Restaurant;
import com.devstromo.factory.method.VeggieBurgerRestaurant;

class RestaurantTest {

    @Test
    public void testFactoryMethod() {
        Restaurant beefRestaurant = new BeefBurgerRestaurant();
        Burger beefBurger = beefRestaurant.orderBurger();


        Restaurant veggieRestaurant = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieRestaurant.orderBurger();
    }

}