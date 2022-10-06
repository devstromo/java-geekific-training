package com.devstromo.tree.heaps;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class HeapTest {

    @Test
    public void testHeapMaximum() {
        int[] integers = { 10, 55, -5, 34, 7, 22, 19, 27, -87, 12, 9, 41, -67, -32, 92, 17, 23, 45, -22, 29, 1020 };
        out.print(Arrays.toString(integers));
        Heap<Integer> maximum = new MaximumHeap<>();
        Arrays.stream(integers)
            .boxed()
            .forEach(maximum::insert);

        assertEquals(1020, maximum.getRoot());
    }

    @Test
    public void testHeapMinimum() {
        int[] integers = { 10, 55, -5, 34, 7, 22, 19, 27, -87, 12, 9, 41, -67, -32, 92, 17, 23, 45, -22, 29, 1020 };
        out.print(Arrays.toString(integers));
        Heap<Integer> minimum = new MinimumHeap<>();
        Arrays.stream(integers)
            .boxed()
            .forEach(minimum::insert);

        assertEquals(-87, minimum.getRoot());
    }

    @Test
    public void testHeapMaximumSort() {
        int[] integers = { 10, 55, -5, 34, 7, 22, 19, 27, -87, 12, 9, 41, -67, -32, 92, 17, 23, 45, -22, 29, 1020 };
        out.print(Arrays.toString(integers));
        Heap<Integer> maximum = new MaximumHeap<>();
        Arrays.stream(integers)
            .boxed()
            .forEach(maximum::insert);
        maximum.sort();
    }

    @Test
    public void testHeapMinimumSort() {
        int[] integers = { 10, 55, -5, 34, 7, 22, 19, 27, -87, 12, 9, 41, -67, -32, 92, 17, 23, 45, -22, 29, 1020 };
        out.print(Arrays.toString(integers));
        Heap<Integer> minimum = new MinimumHeap<>();
        Arrays.stream(integers)
            .boxed()
            .forEach(minimum::insert);
        minimum.sort();

    }

}