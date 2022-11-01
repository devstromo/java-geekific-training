package com.devstromo.structural.bridge;

public class AmericanRestaurant extends Restaurant {

    public AmericanRestaurant(Pizza pizza) {
        super(pizza);
    }

    @Override
    void addSauce() {
        pizza.setToppings("Super Secret Recipe");
    }

    @Override
    void addToppings() {
        pizza.setToppings("Everything");
    }

    @Override
    void makeCrust() {
        pizza.setCrust("Thick");
    }

}
