package com.devtstromo.factory.abstract_factory;

public class MsiManufacturer extends Company {

    @Override
    protected Gpu createGpu() {
        return new MsiGpu();
    }

    @Override
    protected Monitor createMonitor() {
        return new MsiMonitor();
    }
}
