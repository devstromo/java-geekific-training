package com.devstromo.tree.heaps;

public interface IHeap<T extends Comparable<T>> {
    IHeap<T> insert(T data);

    T getRoot();

    void sort();
}
