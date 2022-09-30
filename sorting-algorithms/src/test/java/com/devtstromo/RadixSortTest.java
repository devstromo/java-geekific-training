package com.devtstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class RadixSortTest {
    @Test
    public void testRadixSort() {
        // no negative
        int[] integers = { 10, 55, 5, 34, 7, 22, 19 };
        out.println(Arrays.toString(integers));
        new RadixSort(integers).sort();
        out.println(Arrays.toString(integers));
        assertEquals("[5, 7, 10, 19, 22, 34, 55]", (Arrays.toString(integers)));
    }

    @Test
    public void testRadixSortForNegative() {
        int[] integers = { 10, 55, -5, 34, 7, 22, 19 };
        out.println(Arrays.toString(integers));
        new RadixSort(integers).sortForNegative();
        out.println(Arrays.toString(integers));
        assertEquals("[-5, 7, 10, 19, 22, 34, 55]", (Arrays.toString(integers)));
    }
}