package com.devstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;

import org.junit.jupiter.api.Test;

class BinarySearchTest {

    @Test
    public void testSearch() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new BinarySearch<>(integers).search(-5);
        assertEquals(4, index);
    }

    @Test
    public void testSearchUpperbound() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new BinarySearch<>(integers).search(1020);
        assertEquals(12, index);
    }

    @Test
    public void testSearchNotFound() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new BinarySearch<>(integers).search(-55);
        assertEquals(-1, index);
    }

    @Test
    public void testSearchRecursive() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new BinarySearch<>(integers).search(-5, 0, integers.length);
        assertEquals(4, index);
    }

    @Test
    public void testSearchRecursiveUpperbound() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new BinarySearch<>(integers).search(100, 0, integers.length);
        assertEquals(11, index);
    }

    @Test
    public void testSearchRecursiveNotFound() {
        Integer[] integers = { 1, -5, 6, 1020, 100, -36, -78, -69, -45, 78, 24, 12, 32 };
        out.println(Arrays.toString(integers));
        new TimSort<>(integers).sort();
        out.println(Arrays.toString(integers));
        int index = new BinarySearch<>(integers).search(-55, 0, integers.length);
        assertEquals(-1, index);
    }

}