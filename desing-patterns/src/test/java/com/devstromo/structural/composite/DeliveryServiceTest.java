package com.devstromo.structural.composite;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class DeliveryServiceTest {

    @Test
    public void testCompositePattern() {
        DeliveryService deliveryService = new DeliveryService();
        deliveryService.setupOrder(
            new CompositeBox(
                new VideoGame("1", 100)
            ),
            new CompositeBox(
                new CompositeBox(
                    new Book("2", 200),
                    new Book("3", 300)
                ),
                new VideoGame("4", 400),
                new VideoGame("5", 500)
            )
        );
        assertEquals(1500.0, deliveryService.calculateOrderPrice());
    }

}