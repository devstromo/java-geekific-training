package com.devstromo.locks_monitors_semaphores;

import static java.util.concurrent.TimeUnit.SECONDS;
import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.concurrent.locks.StampedLock;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class MyClassTest {

    ReentrantLock lock = new ReentrantLock();
    int count = 0;

    @Test
    public void testReentrantLock() throws InterruptedException {
        ExecutorService executor = Executors.newFixedThreadPool(4);
        IntStream.range(0, 1000)
            .forEach(i -> executor.submit(this::increment));
        Thread.sleep(10_000);
        assertEquals(1000, count);
    }

    @Test
    public void testReentrantLock2() throws InterruptedException {
        Executors.newSingleThreadExecutor()
            .submit(() -> {
                lock.lock();
                try {
                    Thread.sleep(2_000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    lock.unlock();
                }
            });

        Executors.newSingleThreadScheduledExecutor()
            .scheduleAtFixedRate(() -> {
                System.out.println("Locked: " + lock.isLocked());
                System.out.println("Held by this thread: " + lock.isHeldByCurrentThread());
                boolean locked = lock.tryLock();
                System.out.println("Lock acquired: " + locked);
            }, 0, 1, SECONDS);
    }

    @Test
    public void testReadWriteLock() {
        List<String> list = new ArrayList<>();
        ReadWriteLock lock = new ReentrantReadWriteLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable writeTask = () -> {
            lock.writeLock()
                .lock();
            try {
                list.add("geekific");
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.writeLock()
                    .unlock();
            }
        };

        Runnable readTask = () -> {
            lock.readLock()
                .lock();
            try {
                System.out.println(list.get(0));
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.readLock()
                    .unlock();
            }
        };

        executor.submit(writeTask);
        executor.submit(readTask);
        executor.submit(readTask);
    }

    @Test
    public void testStampedLock() {
        List<String> list = new ArrayList<>();
        StampedLock lock = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        Runnable writeTask = () -> {
            long stamp = lock.writeLock();
            try {
                list.add("geekific");
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockWrite(stamp);
            }
        };

        Runnable readTask = () -> {
            long stamp = lock.readLock();
            try {
                System.out.println(list.get(0));
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlockRead(stamp);
            }
        };

        executor.submit(writeTask);
        executor.submit(readTask);
        executor.submit(readTask);
    }

    @Test
    public void testOptimisticLocking() {
        StampedLock lock = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);

        executor.submit(() -> {
            long stamp = lock.tryOptimisticRead();
            try {
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                Thread.sleep(2_000);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
                Thread.sleep(2_000);
                System.out.println("Optimistic Lock Valid: " + lock.validate(stamp));
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                lock.unlock(stamp);
            }
        });
        executor.submit(() -> {
            long stamp = lock.writeLock();
            try {
                System.out.println("Write Lock Acquired");
                Thread.sleep(2_000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                System.out.println("Write Done");
                lock.unlock(stamp);
            }
        });
    }

    @Test
    public void testConvertReadToWriteLocks() {
        StampedLock lock = new StampedLock();
        ExecutorService executor = Executors.newFixedThreadPool(2);
        boolean writeIsNeed = true;
        executor.submit(() -> {
            long stamp = lock.readLock();
            try {
                if (writeIsNeed) {
                    stamp = lock.tryConvertToReadLock(stamp);
                    if (stamp == 0L)
                        stamp = lock.writeLock();
                    // do a write operation
                }
            } finally {
                lock.unlock(stamp);
            }
        });
    }

    @Test
    public void testSemaphore() {
        Semaphore semaphore = new Semaphore(5);
        ExecutorService executor = Executors.newFixedThreadPool(10);
        Runnable task = () -> {
            boolean permit = false;
            try {
                permit = semaphore.tryAcquire(1, SECONDS);
                if (permit) {
                    System.out.println("Semaphore acquired");
                    Thread.sleep(5_000);
                } else {
                    System.out.println("Could not acquire semaphore");
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                if (permit)
                    semaphore.release();
            }
        };
        IntStream.range(0, 10)
            .forEach(i -> executor.submit(task));
    }

    void increment() {
        lock.lock();
        try {
            count += 1;
        } finally {
            lock.unlock();
        }
    }

}