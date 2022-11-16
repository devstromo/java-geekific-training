package com.devstromo.behavioral.strategy.null_pattern;

import java.util.List;

import org.junit.jupiter.api.Test;

class RoutingHandlerTest {

    @Test
    public void testRouting() {
        Message sms = new Message("Sms data");
        Message jms = new Message("Jms data");
        Message nullMsg = new Message("Another");
        RoutingHandler handler = new RoutingHandler();
        handler.handle(List.of(sms, jms, nullMsg));
    }

}