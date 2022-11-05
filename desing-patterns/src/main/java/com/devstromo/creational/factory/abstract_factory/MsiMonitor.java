package com.devstromo.creational.factory.abstract_factory;

public class MsiMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("MSI Monitor");
    }
}
