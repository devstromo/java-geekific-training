package com.devstromo.factory;

import org.junit.jupiter.api.Test;

import com.devstromo.creational.factory.method.BeefBurgerRestaurant;
import com.devstromo.creational.factory.method.Burger;
import com.devstromo.creational.factory.method.Restaurant;
import com.devstromo.creational.factory.method.VeggieBurgerRestaurant;

class RestaurantTest {

    @Test
    public void testFactoryMethod() {
        Restaurant beefRestaurant = new BeefBurgerRestaurant();
        Burger beefBurger = beefRestaurant.orderBurger();


        Restaurant veggieRestaurant = new VeggieBurgerRestaurant();
        Burger veggieBurger = veggieRestaurant.orderBurger();
    }

}