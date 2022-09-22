package com.devtstromo.patterns.observer;

import org.junit.jupiter.api.Test;

class ObserverTest {

    @Test
    public void testObserver() {
        Store store = new Store();

        store.getNotificationService()
            .subscribe(Event.NEW_ITEM, new EmailMsgListener("notengo@gmail.com"));
        store.getNotificationService()
            .subscribe(Event.SALE, new EmailMsgListener("notengo@subs.com"));
        store.getNotificationService()
            .subscribe(Event.NEW_ITEM, new MobileAppListener("notengo@"));
        store.newItemPromotion(Event.NEW_ITEM);
    }

}