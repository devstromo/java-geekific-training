package com.devstromo.behavioral.strategy;


import org.junit.jupiter.api.Test;

class PaymentServiceTest {

    @Test
    public void testStrategyPattern() {
        PaymentService paymentService = new PaymentService();
        // The strategy can now be easily picked at runtime
        paymentService.setStrategy(new PaymentByCreditCard());
        paymentService.processOrder();
    }

}