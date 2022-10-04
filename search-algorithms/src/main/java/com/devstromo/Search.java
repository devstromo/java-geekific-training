package com.devstromo;

public interface Search<T extends Comparable<T>> {
    int search(T data);
}
