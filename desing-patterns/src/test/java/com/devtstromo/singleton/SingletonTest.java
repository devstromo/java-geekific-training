package com.devtstromo.singleton;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class SingletonTest {

    @Test
    public void testSingleton() {
        Singleton firstInstance = Singleton.getInstance("data");
        assertEquals(Singleton.getInstance("data"), firstInstance);
    }
}