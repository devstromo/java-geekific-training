package com.devtstromo.observer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class NotificationService {
    private final Map<Event, List<EventListener>> customers;

    public NotificationService() {
        this.customers = new HashMap<>();
        Arrays.stream(Event.values())
            .forEach(event -> customers.put(event, new ArrayList<>()));
    }

    public void subscribe(Event eventType, EventListener listener) {
        customers.get(eventType)
            .add(listener);
    }

    public void unsubscribe(Event eventType, EventListener listener) {
        customers.get(eventType)
            .remove(listener);
    }

    public void notifySubscribers(Event event) {
        customers.get(event).forEach(listener -> listener.update(event));
    }
}
