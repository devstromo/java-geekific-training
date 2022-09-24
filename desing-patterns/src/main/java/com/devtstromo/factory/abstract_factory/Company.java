package com.devtstromo.factory.abstract_factory;

public abstract class Company {

    protected abstract Gpu createGpu();

    protected abstract Monitor createMonitor();
}
