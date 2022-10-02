package com.devtstromo;

import static java.lang.System.out;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.Arrays;
import java.util.List;

import org.junit.jupiter.api.Test;

class BucketSortTest {

    @Test
    public void testBucketSortFloat() {
        List<Float> floats = Arrays.asList(0.42F, 0.32F, 0.63F, 0.82F, 0.37F, 0.17F, 0.51F, 0.21F, 0.22F, 0.75F);
        List<Float> sortedArray = new BucketSort<Float>().sort(floats, (item, size) -> (int) (item * size));
        out.println(Arrays.toString(sortedArray.toArray()));
        assertEquals("[0.17, 0.21, 0.22, 0.32, 0.37, 0.42, 0.51, 0.63, 0.75, 0.82]", Arrays.toString(sortedArray.toArray()));
    }

    @Test
    public void testBucketSortInteger() {
        List<Integer> ints = Arrays.asList(42, 32, 63, 82, 37, 17, 51, 11, 22, 75);
        List<Integer> sortedArray = new BucketSort<Integer>().sort(ints, (item, size) -> item / size);
        out.println(Arrays.toString(sortedArray.toArray()));
        assertEquals("[11, 17, 22, 32, 37, 42, 51, 63, 75, 82]", Arrays.toString(sortedArray.toArray()));
    }
}