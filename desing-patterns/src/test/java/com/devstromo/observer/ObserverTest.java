package com.devstromo.observer;

import org.junit.jupiter.api.Test;

import com.devstromo.behavioral.observer.EmailMsgListener;
import com.devstromo.behavioral.observer.Event;
import com.devstromo.behavioral.observer.MobileAppListener;
import com.devstromo.behavioral.observer.Store;

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