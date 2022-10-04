package com.devstromo;

public record BinarySearch<T extends Comparable<T>>(T[] arr) implements Search<T> {
    @Override
    public int search(T data) {
        int min = 0;
        int max = arr.length;
        int middle;

        while (min <= max) {
            // * middle = (max + min) / 2 could contain bugs
            // * it fails for larger values of int variables low and high
            // *  if the sum of low and high is greater than the maximum positive int value(2^31 – 1 )
            middle = min + (max - min) / 2;
            if (arr[middle].compareTo(data) < 0) {
                min = middle + 1;
            } else if (arr[middle].compareTo(data) > 0) {
                max = middle - 1;
            } else {
                return middle;
            }
        }
        return -1;
    }

    public int search(T data, int min, int max) {
        if (min > max) {
            return -1;
        }
        int middle = (max + min) / 2;
        if (arr[middle].compareTo(data) < 0) {
            return search(data, middle + 1, max);
        } else if (arr[middle].compareTo(data) > 0) {
            return search(data, min, middle - 1);
        } else {
            return middle;
        }
    }
}
