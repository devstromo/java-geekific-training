package com.devstromo;

import lombok.Data;

@Data
public class Node<T> {
    private final T data;
    private Node<T> nextNode;
}
