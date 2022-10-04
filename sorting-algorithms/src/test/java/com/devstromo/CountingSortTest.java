package com.devstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class CountingSortTest {

    @Test
    public void testCountingSort() {
        int[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        out.println(Arrays.toString(integers));
        new CountingSort(integers).sort();
        out.println(Arrays.toString(integers));
        assertEquals("[-5, 7, 10, 19, 22, 34, 55]", (Arrays.toString(integers)));
    }

    @Test
    public void testCountingAltSort() {
        int[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        out.println(Arrays.toString(integers));
        new CountingSort(integers).sortAlt();
        out.println(Arrays.toString(integers));
        assertEquals("[-5, 7, 10, 19, 22, 34, 55]", (Arrays.toString(integers)));
    }
}