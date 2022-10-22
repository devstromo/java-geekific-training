package com.devstromo.tree.ternary;

import lombok.Data;
import lombok.NonNull;

@Data
public class Node<T extends Comparable<T>> {
    @NonNull
    private char character;
    private T value;
    private Node<T> leftChild;
    private Node<T> middleChild;
    private Node<T> rightChild;

    public boolean isEndOfWord() {
        return value != null;
    }

}
