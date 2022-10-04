package com.devstromo.observer;

public class Store {
    private final NotificationService notificationService;

    public Store() {
        this.notificationService = new NotificationService();
    }

    public void newItemPromotion(Event event) {
        notificationService.notifySubscribers(event);
    }

    public NotificationService getNotificationService() {
        return notificationService;
    }
}
