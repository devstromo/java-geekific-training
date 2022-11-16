package com.devstromo.behavioral.strategy.null_pattern;

public class NullRouter implements Router {
    @Override
    public void route(Message msg) {
        System.out.println("Not implementation");
    }
}
