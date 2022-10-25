package com.devstromo.behavioral.iterator;

public interface Iterator<T> {
    boolean hasNext();
    Vertex<T> getNext();
    void reset();
}
