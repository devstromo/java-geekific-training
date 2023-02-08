package com.devstromo.stack;

import com.devstromo.Node;

public class LinkedLinkStack<T> {
    private Node<T> root;
    private int size;

    public LinkedLinkStack() {
    }

    public void push(T data) {
        var node = new Node<T>(data);
        if (!isEmpty()) {
            node.setNextNode(root);
        }
        root = node;
        size++;
    }

    public T pop() {
        if (isEmpty()) {
            return null;
        }
        T oldRootData = root.getData();
        root = root.getNextNode();
        size--;
        return oldRootData;
    }

    public T peek() {
        return !isEmpty() ? root.getData() : null;
    }

    public boolean isEmpty() {
        return root == null;
    }

}
