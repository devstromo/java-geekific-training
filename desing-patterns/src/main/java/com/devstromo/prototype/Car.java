package com.devstromo.prototype;

public class Car extends Vehicle {

    private int topSpeed;

    // the difference between a shallow and a deep copy
    // cannot be spotter here as all our fields are immutable
    // this newly created car will reference the same 'GpsSystem'
    // object in memory, and any change done on this object will
    // be reflected in both cars
    private GpsSystem gpsSystem;

    public Car(String brand, String model, String color, int topSpeed) {
        super(brand, model, color);
        this.topSpeed = topSpeed;
    }

    Car(Car car) {
        super(car);
        this.topSpeed = car.topSpeed;
        this.gpsSystem = car.gpsSystem; // shallow copy
        // new GpsSystem() or gpsSystem.clone() // deep copy
    }

    public int getTopSpeed() {
        return topSpeed;
    }

    @Override
    public Car clone() {
        return new Car(this);
    }
}
