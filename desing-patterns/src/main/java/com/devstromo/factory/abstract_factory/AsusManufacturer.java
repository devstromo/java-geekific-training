package com.devstromo.factory.abstract_factory;

public class AsusManufacturer extends Company {

    @Override
    protected Gpu createGpu() {
        return new AsusGpu();
    }

    @Override
    protected Monitor createMonitor() {
        return new AsusMonitor();
    }
}
