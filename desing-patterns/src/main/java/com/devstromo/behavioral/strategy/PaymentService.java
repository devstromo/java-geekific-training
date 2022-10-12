package com.devstromo.behavioral.strategy;

import lombok.Setter;

@Setter
public class PaymentService {
    private int cost;
    private boolean includeDelivery;

    private PaymentStrategy strategy;

    public void processOrder() {
        strategy.collectPaymentDetails();
        if (strategy.validatePaymentDetails()) {
            strategy.pay(getTotal());
        }
    }

    private int getTotal() {
        return includeDelivery ? cost + 10 : cost;
    }
}
