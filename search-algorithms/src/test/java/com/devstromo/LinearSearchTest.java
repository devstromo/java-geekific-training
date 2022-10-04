package com.devstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.stream.IntStream;

import org.junit.jupiter.api.Test;

class LinearSearchTest {
    int[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };

    @Test
    public void searchTest() {
        out.println(Arrays.toString(integers));
        int index = new LinearSearch<>(IntStream.of(integers)
            .boxed()
            .toArray(Integer[]::new)).search(-78);

        assertEquals(6, index);
    }

    @Test
    public void searchNotFoundTest() {
        out.println(Arrays.toString(integers));
        int index = new LinearSearch<>(IntStream.of(integers)
            .boxed()
            .toArray(Integer[]::new)).search(-7812);

        assertEquals(-1, index);
    }

    @Test
    public void searchRecursiveTest() {
        out.println(Arrays.toString(integers));
        int index = new LinearSearch<>(IntStream.of(integers)
            .boxed()
            .toArray(Integer[]::new)).search(-78, 0);

        assertEquals(6, index);
    }

    @Test
    public void searchRecursiveNotFoundTest() {
        out.println(Arrays.toString(integers));
        int index = new LinearSearch<>(IntStream.of(integers)
            .boxed()
            .toArray(Integer[]::new)).search(-7812, 0);

        assertEquals(-1, index);
    }

    @Test
    public void searchRecursiveOutRangeTest() {
        out.println(Arrays.toString(integers));
        int index = new LinearSearch<>(IntStream.of(integers)
            .boxed()
            .toArray(Integer[]::new)).search(-7812, 150);

        assertEquals(-1, index);
    }

}