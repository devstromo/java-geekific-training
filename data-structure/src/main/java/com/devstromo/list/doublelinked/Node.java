package com.devstromo.list.doublelinked;

import lombok.Data;

@Data
public class Node<T> {
    private final T data;
    private Node<T> previous;
    private Node<T> next;

    @Override
    public String toString() {
        return data.toString() + " -> ";
    }
}
