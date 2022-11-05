package com.devstromo.builder;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import com.devstromo.creational.factory.builder.Car;
import com.devstromo.creational.factory.builder.CarBuilder;
import com.devstromo.creational.factory.builder.Director;

class CarTest {

    @Test
    public void testSimpleBuilder() {
        CarBuilder builder = new CarBuilder();
        Car car = builder.id(2122)
            .brand("Bugatti")
            .model("Chiron")
            .color("Blue")
            .build();
        assertEquals("Bugatti", car.getBrand());
    }

    @Test
    public void testDirector() {
        CarBuilder builder = new CarBuilder();
        Director director = new Director();
        director.buildBugatti(builder);
        Car car = builder.id(2122)
            .build();
        assertEquals("Bugatti", car.getBrand());
    }

}