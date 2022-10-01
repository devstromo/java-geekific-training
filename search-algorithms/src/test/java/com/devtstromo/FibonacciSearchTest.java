package com.devtstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class FibonacciSearchTest {

    @Test
    public void testFibonacciSearch() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new FibonacciSearch<>(integers).search(1020);
        assertEquals(12, index);
    }

    @Test
    public void testFibonacciFirstSearch() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new FibonacciSearch<>(integers).search(-78);
        assertEquals(0, index);
    }

    @Test
    public void testFibonacciSearchNotFound() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new FibonacciSearch<>(integers).search(102000);
        assertEquals(-1, index);
    }

}