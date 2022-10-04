package com.devstromo.singleton;

public class Singleton {

    private static volatile Singleton instance;
    private final String data;

    public Singleton(String data) {
        this.data = data;
    }

    public static Singleton getInstance(String data) {
        // the usage of usage a local variable can improve the method
        // overall performance by as much as 40%
        Singleton result = instance;
        if (result == null) {
            synchronized (Singleton.class) {
                result = instance;
                if (result == null)
                    instance = result = new Singleton(data);
            }
        }

        return result;
    }

    public String getData() {
        return data;
    }
}
