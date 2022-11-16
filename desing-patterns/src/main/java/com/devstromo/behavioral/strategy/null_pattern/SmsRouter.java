package com.devstromo.behavioral.strategy.null_pattern;

public class SmsRouter implements Router {
    @Override
    public void route(Message msg) {
        System.out.println("Sms msg " + msg.message());
    }
}
