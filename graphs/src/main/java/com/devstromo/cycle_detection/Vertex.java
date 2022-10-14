package com.devstromo.cycle_detection;

import java.util.HashSet;
import java.util.Set;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Vertex<T> {
    private final T data;
    private boolean visited;
    private boolean beingVisited;

    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Set<Vertex<T>> neighbors = new HashSet<>();

    public void addNeighbor(Vertex<T> vertex) {
        neighbors.add(vertex);
    }
}
