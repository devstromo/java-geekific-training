package com.devstromo.factory.abstract_factory;


import org.junit.jupiter.api.Test;

class CompanyTest {

    @Test
    public void testAbstractFactory() {
        Company msi = new MsiManufacturer();
        Gpu msiGpu = msi.createGpu();
        Monitor msiMonitor = msi.createMonitor();

        Company asus = new AsusManufacturer();
        Gpu asusGpu = asus.createGpu();
        Monitor asusMonitor = asus.createMonitor();

    }

}