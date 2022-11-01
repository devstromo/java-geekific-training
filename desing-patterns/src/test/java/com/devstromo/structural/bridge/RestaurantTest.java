package com.devstromo.structural.bridge;

import org.junit.jupiter.api.Test;

class RestaurantTest {

    @Test
    public void testBridgePattern() {
        AmericanRestaurant restaurant = new AmericanRestaurant(new PepperoniPizza());
        restaurant.deliver();

        ItalianRestaurant italianRestaurant = new ItalianRestaurant(new VeggiePizza());
        italianRestaurant.deliver();

    }

}