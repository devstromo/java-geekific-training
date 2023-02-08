package com.devstromo.queue;

public class Queue<T> implements IQueue<T> {
    private final T[] queue;
    private final int capacity;
    private int head;
    private int tail;
    private int size;

    public Queue(int capacity) {
        this.queue = (T[]) new Object[capacity];
        this.capacity = capacity;
        size = 0;
        head = 0;
        tail = -1;
    }

    @Override
    public void enqueue(T data) {
        if (isFull()) {
            System.out.println("Queue is full!!");
            return;
        }
        tail = (tail + 1) % capacity;
        queue[tail] = data;
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            System.out.println("Queue is empty!!");
            return null;
        }
        T dataToRemove = queue[head];
        head = (head + 1) % capacity;
        size--;
        return dataToRemove;
    }

    @Override
    public T peek() {
        return queue[head];
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        return capacity == size;
    }
}
