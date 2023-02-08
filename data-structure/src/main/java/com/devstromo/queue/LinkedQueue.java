package com.devstromo.queue;

import com.devstromo.Node;

import lombok.ToString;

@ToString(onlyExplicitlyIncluded = true)
public class LinkedQueue<T> implements IQueue<T> {
    @ToString.Include
    private Node<T> head;
    private Node<T> tail;
    private int size;

    public LinkedQueue() {
        head = tail = null;
    }

    @Override
    public void enqueue(T data) {
        var node = new Node<T>(data);
        if (isEmpty()) {
            head = tail = node;
        } else {
            tail.setNextNode(node);
            tail = node;
        }
        size++;
    }

    @Override
    public T dequeue() {
        if (isEmpty()) {
            return null;
        }
        T dataToRemove = head.getData();
        head = head.getNextNode();
        size--;
        return dataToRemove;
    }

    @Override
    public T peek() {
        return !isEmpty() ? head.getData() : null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean isFull() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
