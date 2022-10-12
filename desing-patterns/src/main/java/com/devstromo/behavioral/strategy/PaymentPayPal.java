package com.devstromo.behavioral.strategy;

public class PaymentPayPal implements PaymentStrategy {
    private String email;
    private String password;

    @Override
    public void collectPaymentDetails() {
        // Pop-up to collect card details...
        email = "";
        password = "";
    }

    @Override
    public boolean validatePaymentDetails() {
        // Validate account
        return false;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paying " + amount + " using PayPal");
    }
}
