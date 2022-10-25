package com.devstromo.behavioral.iterator;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class IteratorTest {

    @Test
    public void testIterator() {
        Vertex<Integer> v0 = new Vertex<>(0);
        Vertex<Integer> v1 = new Vertex<>(1);
        Vertex<Integer> v2 = new Vertex<>(2);
        Vertex<Integer> v3 = new Vertex<>(3);
        Vertex<Integer> v4 = new Vertex<>(4);
        Vertex<Integer> v5 = new Vertex<>(5);
        Vertex<Integer> v6 = new Vertex<>(6);

        v0.setNeighbors(Arrays.asList(v1, v5, v6));
        v1.setNeighbors(Arrays.asList(v3, v4, v5));
        v4.setNeighbors(Arrays.asList(v2, v6));
        v6.setNeighbors(List.of(v0));
        DepthFirstIterator<Integer> depthFirstIterator = new DepthFirstIterator<>(v0);
        List<Integer> result = new ArrayList<>();
        while (depthFirstIterator.hasNext()) {
            result.add(depthFirstIterator.getNext()
                .getData());
        }

        List<Integer> expected = List.of(0, 6, 5, 1, 4, 2, 3);
        assertEquals(expected, result);
    }

}