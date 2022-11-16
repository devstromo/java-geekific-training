package com.devstromo.behavioral.strategy.null_pattern;

public class RouterFactory {
    public static Router getRouterForMessage(Message message) {
        if (message.message()
            .contains("Jms"))
            return new JmsRouter();
        if (message.message()
            .contains("Sms"))
            return new SmsRouter();
        return new NullRouter();
    }
}
