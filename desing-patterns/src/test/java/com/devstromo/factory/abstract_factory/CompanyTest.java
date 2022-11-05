package com.devstromo.factory.abstract_factory;


import org.junit.jupiter.api.Test;

import com.devstromo.creational.factory.abstract_factory.AsusManufacturer;
import com.devstromo.creational.factory.abstract_factory.Company;
import com.devstromo.creational.factory.abstract_factory.Gpu;
import com.devstromo.creational.factory.abstract_factory.Monitor;
import com.devstromo.creational.factory.abstract_factory.MsiManufacturer;

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