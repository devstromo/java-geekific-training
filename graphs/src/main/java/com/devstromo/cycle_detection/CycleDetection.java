package com.devstromo.cycle_detection;

import java.util.List;

public class CycleDetection<T> {

    public boolean hasCycle(List<Vertex<T>> vertices) {
        for (Vertex<T> vertex : vertices) {
            if (!vertex.isVisited() && hasCycle(vertex)) {
                return true;
            }
        }
        return false;
    }

    public boolean hasCycleUndirected(List<Vertex<T>> vertices) {
        for (Vertex<T> vertex : vertices) {
            if (!vertex.isVisited() && hasCycle(null, vertex)) {
                return true;
            }
        }
        return false;
    }

    // for directed graph
    public boolean hasCycle(Vertex<T> sourceVertex) {
        sourceVertex.setBeingVisited(true);
        for (Vertex<T> neighbor : sourceVertex.getNeighbors()) {
            if (neighbor.isBeingVisited() || !neighbor.isVisited() && hasCycle(neighbor)) {
                return true;
            }
        }
        sourceVertex.setBeingVisited(false);
        sourceVertex.setVisited(true);
        return false;
    }

    // for directed graph
    public boolean hasCycle(Vertex<T> caller, Vertex<T> current) {
        current.setVisited(true);
        for (Vertex<T> neighbor : current.getNeighbors()) {
            if (neighbor.isVisited() && !neighbor.equals(caller) || !neighbor.isVisited() && hasCycle(current, neighbor)) {
                return true;
            }
        }
        return false;
    }
}
