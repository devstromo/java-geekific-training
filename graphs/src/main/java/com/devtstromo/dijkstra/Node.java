package com.devtstromo.dijkstra;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class Node implements Comparable<Node> {
    private final String name;
    private Integer distance = Integer.MAX_VALUE;
    List<Node> shortestPath = new LinkedList<>();
    private Map<Node, Integer> adjacentNodes = new HashMap<>();

    public void addAdjacentNode(Node node, int weight) {
        adjacentNodes.put(node, weight);
    }

    @Override
    public int compareTo(Node node) {
        return Integer.compare(this.distance, node.getDistance());
    }
}
