package com.devtstromo.observer;

public class MobileAppListener implements EventListener {
    private final String username;

    public MobileAppListener(String username) {
        this.username = username;
    }

    @Override
    public void update(Event eventType) {
        // Actually send the push notifications
        System.out.println("Mobile for: " + eventType.name() + " with username: " + username);
    }
}
