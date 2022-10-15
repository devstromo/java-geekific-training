package com.devstromo.kruskal;

import com.devstromo.cycle_detection.Vertex;

import lombok.Data;

@Data
public class Edge<T> implements Comparable<Edge<T>> {

    private final Vertex<T> source;
    private final Vertex<T> destination;
    private final int weight;

    @Override
    public int compareTo(Edge<T> edge) {
        return Integer.compare(weight, edge.getWeight());// minimum spanning tree
    }
}
