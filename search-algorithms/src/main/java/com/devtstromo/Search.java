package com.devtstromo;

public interface Search<T extends Comparable<T>> {
    int search(T data);
}
