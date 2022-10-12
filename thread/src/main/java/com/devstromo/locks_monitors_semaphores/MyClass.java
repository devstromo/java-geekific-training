package com.devstromo.locks_monitors_semaphores;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.stream.IntStream;

public class MyClass {
    private static int count = 0;

    public static void main(String[] args) throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        IntStream.range(0, 1000)
            .forEach(i -> executor.submit(MyClass::increment));
        Thread.sleep(10_000);
        System.out.println(count);

        count = 0;
        IntStream.range(0, 1000)
            .forEach(i -> executor.submit(MyClass::incrementSync));
        Thread.sleep(10_000);
        System.out.println(count);
    }

    static void increment() {
        count += 1;
    }

    static synchronized void incrementSync() {
        count += 1;
    }
}
