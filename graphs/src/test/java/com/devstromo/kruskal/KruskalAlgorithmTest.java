package com.devstromo.kruskal;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

import com.devstromo.cycle_detection.Vertex;

class KruskalAlgorithmTest {

    @Test
    public void testKruskal() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");
        Vertex<String> vertexG = new Vertex<>("G");

        List<Edge<String>> graph1 = Arrays.asList(
            new Edge<>(vertexA, vertexB, 4),
            new Edge<>(vertexA, vertexC, 4),
            new Edge<>(vertexB, vertexC, 2),
            new Edge<>(vertexC, vertexD, 3),
            new Edge<>(vertexC, vertexF, 4),
            new Edge<>(vertexC, vertexE, 2),
            new Edge<>(vertexD, vertexF, 3),
            new Edge<>(vertexE, vertexF, 3)
        );

        new KruskalAlgorithm<>(graph1).run();
    }
}