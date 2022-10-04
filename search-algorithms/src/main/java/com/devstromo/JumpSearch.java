package com.devstromo;

import static java.lang.Math.floor;
import static java.lang.Math.min;
import static java.lang.Math.sqrt;

// Time Complexity : O(√n)
public record JumpSearch<T extends Comparable<T>>(T[] arr) implements Search<T> {
    @Override
    public int search(T data) {
        int n = arr.length;
        int stepBound = (int) floor(sqrt(n));
        int step = stepBound;
        int prev = 0;
        while (arr[min(step, n) - 1].compareTo(data) < 0) {
            prev = step;
            step += stepBound;
            if (prev >= n) {
                return -1;
            }
        }

        while (arr[prev].compareTo(data) < 0) {
            prev++;
            // If we reached next block or end of
            // array, element is not present.
            if (prev == min(step, n)) {
                return -1;
            }
        }
        if (arr[prev].compareTo(data) == 0) {
            return prev;
        }
        return -1;
    }
}
