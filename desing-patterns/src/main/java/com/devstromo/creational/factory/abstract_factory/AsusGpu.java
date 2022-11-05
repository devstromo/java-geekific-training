package com.devstromo.creational.factory.abstract_factory;

public class AsusGpu implements Gpu {
    @Override
    public void assemble() {
        System.out.println("Asus Component");
    }
}
