package com.devstromo.behavioral.strategy.null_pattern;

public class JmsRouter implements Router {
    @Override
    public void route(Message msg) {
        System.out.println("JmsRouter msg " + msg.message());
    }
}
