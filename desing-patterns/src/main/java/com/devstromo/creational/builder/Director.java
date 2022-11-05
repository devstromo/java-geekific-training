package com.devstromo.creational.factory.builder;

public class Director {

    // Defines the order in which we should call the construction steps so that we can reuse
    // specific configurations of the products we are building
    // Director are optional
    public void buildBugatti(Builder builder) {
        builder.brand("Bugatti")
            .model("Chiron")
            .color("Blue");
    }

    public void buildLambo(Builder builder) {
        builder.brand("Lamborghini")
            .model("Aventador")
            .color("Yellow");
    }
}
