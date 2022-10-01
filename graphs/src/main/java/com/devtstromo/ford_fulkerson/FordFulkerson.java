package com.devtstromo.ford_fulkerson;

import static java.util.Collections.singleton;

import java.util.ArrayList;

import java.util.Comparator;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FordFulkerson<T> {

    private final List<List<Vertex<T>>> paths = new ArrayList<>();

    public int run(Vertex<T> source, Vertex<T> destination) {
        findAllPaths(source, destination, new ArrayList<>(singleton(source)));
        AtomicInteger maxFlow = new AtomicInteger();
        paths.stream()
            .sorted(Comparator.comparingInt(this::getMinFlowInPath)
                .reversed())
            .forEach(path -> {
                Integer minimum = getMinFlowInPath(path);
                IntStream.range(0, path.size() - 1)
                    .forEach(vertexIdx -> removeMinFlowFromPath(path, minimum, vertexIdx));
                maxFlow.addAndGet(minimum);
            });
        return maxFlow.get();
    }

    private void findAllPaths(Vertex<T> current, Vertex<T> destination, List<Vertex<T>> currentPath) {
        if (current.equals(destination)) {
            paths.add(new ArrayList<>(currentPath));
            return;
        }

        current.setVisited(true);
        current.getNeighbors()
            .keySet()
            .stream()
            .filter(neighbor -> !neighbor.isVisited())
            .forEach(neighbor -> {
                currentPath.add(neighbor);
                findAllPaths(neighbor, destination, currentPath);
                currentPath.remove(neighbor);
            });
        current.setVisited(false);
    }

    private Integer getMinFlowInPath(List<Vertex<T>> path) {
        return IntStream.range(0, path.size() - 1)
            .mapToObj(vertexIdx -> getNeighborEdgeWeight(path, vertexIdx))
            .min(Integer::compareTo)
            .orElse(0);
    }

    private Integer getNeighborEdgeWeight(List<Vertex<T>> path, int vertexIdx) {
        return path.get(vertexIdx)
            .getNeighbors()
            .get(path.get(vertexIdx + 1));
    }

    private void removeMinFlowFromPath(List<Vertex<T>> path, Integer min, int vertexIdx) {
        path.get(vertexIdx)
            .getNeighbors()
            .put(path.get(vertexIdx + 1), getNeighborEdgeWeight(path, vertexIdx) - min);
    }

}
