package com.devstromo.stack;

import static java.lang.System.arraycopy;

public class Stack<T> {
    private T[] stack;
    private int size;

    // full -> double its capacity;
    // 75% empty -> cut the capacity by half
    public Stack() {
        this.stack = (T[]) new Object[1];
    }

    public void push(T data) {
        if (stack.length == size) {
            resize(2 * size);
        }
        stack[size++] = data;
    }

    public T pop() {
        T dataToPop = stack[--size];
        if (size != 0 && size <= stack.length / 4) {
            resize(stack.length / 2);
        }
        return dataToPop;
    }

    public T peek() {
        return stack[size - 1];
    }

    private void resize(int capacity) {
        T[] newStack = (T[]) new Object[capacity];
        arraycopy(stack, 0, newStack, 0, size);
        stack = newStack;
    }

    public boolean isEmpty() {
        return size == 0;
    }
}
