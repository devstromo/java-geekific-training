package com.devtstromo;

import static java.lang.Math.min;

public record FibonacciSearch<T extends Comparable<T>>(T[] arr) implements Search<T> {

    @Override
    public int search(T data) {
        int f0 = 0;
        int f1 = 1;
        int fk = f0 + f1;
        int n = arr.length;
        // Find the largest Fk less than n
        while (fk < n) {
            f0 = f1;
            f1 = fk;
            fk = f0 + f1;
        }
        int offset = -1;
        while (fk > 1) {
            int index = min(offset + f0, n - 1);
            // arr[index] < data search to left of f0
            if (arr[index].compareTo(data) < 0) {
                fk = f1;
                f1 = f0;
                f0 = fk - f1;
                offset = index;
            } else if (arr[index].compareTo(data) > 0) {
                // arr[index] < data search to right of f0
                fk = f0;
                f1 = f1 - f0;
                f0 = fk - f1;
            } else {
                // element found
                return index;
            }
        }

        // Compare the last element of the array
        if (f1 == 1 && arr[offset + 1].compareTo(data) == 0) {
            return offset + 1;
        }
        // not found
        return -1;
    }
}
