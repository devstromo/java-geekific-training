package com.devtstromo.factory.abstract_factory;

public class MsiMonitor implements Monitor {
    @Override
    public void assemble() {
        System.out.println("MSI Monitor");
    }
}
