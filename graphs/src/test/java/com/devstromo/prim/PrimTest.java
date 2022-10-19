package com.devstromo.prim;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.api.Test;

class PrimTest {

    @Test
    public void testPrim() {
        Vertex<String> vertexA = new Vertex<>("A");
        Vertex<String> vertexB = new Vertex<>("B");
        Vertex<String> vertexC = new Vertex<>("C");
        Vertex<String> vertexD = new Vertex<>("D");
        Vertex<String> vertexE = new Vertex<>("E");

        Edge edgeAB = new Edge(5);
        Edge edgeAC = new Edge(2);
        Edge edgeBC = new Edge(3);
        Edge edgeBD = new Edge(8);
        Edge edgeBE = new Edge(7);
        Edge edgeCE = new Edge(4);
        Edge edgeDE = new Edge(6);

        vertexA.addNeighbor(vertexB, edgeAB);
        vertexA.addNeighbor(vertexC, edgeAC);

        vertexB.addNeighbor(vertexA, edgeAB);
        vertexB.addNeighbor(vertexC, edgeBC);
        vertexB.addNeighbor(vertexD, edgeBD);
        vertexB.addNeighbor(vertexE, edgeBE);

        vertexC.addNeighbor(vertexA, edgeAC);
        vertexC.addNeighbor(vertexB, edgeBC);
        vertexC.addNeighbor(vertexE, edgeCE);

        vertexD.addNeighbor(vertexB, edgeBD);
        vertexD.addNeighbor(vertexE, edgeDE);

        vertexE.addNeighbor(vertexB, edgeBE);
        vertexE.addNeighbor(vertexC, edgeCE);
        vertexE.addNeighbor(vertexD, edgeDE);

        List<Vertex<String>> graph = Arrays.asList(vertexA, vertexB, vertexC, vertexD, vertexE);
        new Prim<>(graph).run();
        graph.forEach(System.out::println);

        Integer minimum = Stream.of(edgeAB, edgeAC, edgeBC, edgeBD, edgeBE, edgeCE, edgeDE)
            .filter(Edge::isIncluded).map(Edge::getWeight).reduce(0, Integer::sum);
        System.out.println("Minimum Weight: " + minimum);
        assertEquals(15, minimum);
    }

}