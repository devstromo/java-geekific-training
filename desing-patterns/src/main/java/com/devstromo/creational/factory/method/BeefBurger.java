package com.devstromo.creational.factory.method;

public class BeefBurger implements Burger {
    private boolean angus;

    @Override
    public void prepare() {
        System.out.println("Beef Burger");
    }

    public boolean isAngus() {
        return angus;
    }

    public void setAngus(boolean angus) {
        this.angus = angus;
    }
}
