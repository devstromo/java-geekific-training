package com.devstromo.behavioral.iterator;

import java.util.Deque;
import java.util.LinkedList;

public class DepthFirstIterator<T> implements Iterator<T> {
    private final Vertex<T> startVertex;
    private Deque<Vertex<T>> stack = new LinkedList<>();

    public DepthFirstIterator(Vertex<T> startVertex) {
        this.startVertex = startVertex;
        stack.push(startVertex);
    }

    @Override
    public boolean hasNext() {
        return !stack.isEmpty();
    }

    @Override
    public Vertex<T> getNext() {
        if (!hasNext()) {
            return null;
        }
        Vertex<T> current = stack.pop();
        if(!current.isVisited()){
            current.setVisited(true);
            current.getNeighbors().forEach(stack::push);
            return current;
        }
        return getNext();
    }

    @Override
    public void reset() {
        stack.clear();
        stack.push(startVertex);
    }

}
