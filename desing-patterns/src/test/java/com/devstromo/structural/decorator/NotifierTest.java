package com.devstromo.structural.decorator;

import org.junit.jupiter.api.Test;

class NotifierTest {

    @Test
    public void testDecorator() {
        INotifier notifier = new FacebookDecorator(new WhatsAppDecorator(new Notifier("Geekific")));
        notifier.send("Like and Subscribe!!!");
    }

}