package com.devstromo.creational.factory.abstract_factory;

public class MsiGpu implements Gpu {
    @Override
    public void assemble() {
        System.out.println("MSI Component");
    }
}
