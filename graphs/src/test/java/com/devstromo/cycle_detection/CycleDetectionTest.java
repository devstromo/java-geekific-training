package com.devstromo.cycle_detection;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class CycleDetectionTest {

    @Test
    public void testDirectedGraph() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");

        vertexA.addNeighbor(vertexB);
        vertexA.addNeighbor(vertexC);

        vertexB.addNeighbor(vertexC);
        vertexB.addNeighbor(vertexD);
        vertexB.addNeighbor(vertexE);

        vertexC.addNeighbor(vertexD);

        vertexD.addNeighbor(vertexE);

        vertexE.addNeighbor(vertexF);

        vertexF.addNeighbor(vertexD);

        List<Vertex<String>> graph = Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF);
        assertTrue(new CycleDetection<String>().hasCycle(graph));
    }

    @Test
    public void testUndirectedGraph() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");
        Vertex<String> vertexF = new Vertex<>("F");

        vertexA.addNeighbor(vertexB);
        vertexA.addNeighbor(vertexC);

        vertexB.addNeighbor(vertexA);
        vertexB.addNeighbor(vertexE);

        vertexC.addNeighbor(vertexA);
        vertexC.addNeighbor(vertexD);

        vertexD.addNeighbor(vertexC);
        vertexD.addNeighbor(vertexE);

        vertexE.addNeighbor(vertexB);
        vertexE.addNeighbor(vertexD);
        vertexE.addNeighbor(vertexF);

        vertexF.addNeighbor(vertexE);

        List<Vertex<String>> graph = Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE, vertexF);
        assertTrue(new CycleDetection<String>().hasCycleUndirected(graph));
    }
}