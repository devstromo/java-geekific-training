package com.devstromo.prim;

import static java.util.Comparator.comparingInt;

import java.util.Collection;
import java.util.List;

public record Prim<T>(List<Vertex<T>> graph) {
    public void run() {
        if (!graph.isEmpty()) {
            graph.get(0)
                .setVisited(true);
        }
        while (graph().stream()
            .anyMatch(vertex -> !vertex.isVisited())) {
            graph.stream()
                .filter(Vertex::isVisited)
                .map(Vertex::getNeighbors)
                .flatMap(Collection::stream)
                .filter(neighbor -> !neighbor.isVisited())
                .min(comparingInt(n -> n.getEdge()
                    .getWeight()))
                .ifPresent(candidate -> {
                    candidate.getVertex()
                        .setVisited(true);
                    candidate.getEdge()
                        .setIncluded(true);
                });

        }

    }
}
