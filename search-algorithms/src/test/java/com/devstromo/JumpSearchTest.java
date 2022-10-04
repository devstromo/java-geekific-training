package com.devstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class JumpSearchTest {


    @Test
    public void testSearch() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new JumpSearch<>(integers).search(-5);
        assertEquals(4, index);
    }

    @Test
    public void testSearchUpperBound() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new JumpSearch<>(integers).search(1020);
        assertEquals(12, index);
    }

    @Test
    public void testSearchNotFound() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new JumpSearch<>(integers).search(-545);
        assertEquals(-1, index);
    }
}