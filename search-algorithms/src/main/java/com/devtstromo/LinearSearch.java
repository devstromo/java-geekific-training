package com.devtstromo;

public class LinearSearch<T extends Comparable<T>> implements Search<T> {
    private final T[] arr;

    public LinearSearch(T[] arr) {
        this.arr = arr;
    }

    public int search(T data) {
        for (int index = 0; index < arr.length; index++) {
            if (arr[index].compareTo(data) == 0) {
                return index;
            }
        }
        return -1;
    }

    public int search(T data, int index) {
        if (index > arr.length - 1) {
            return -1;
        }
        if (arr[index].compareTo(data) == 0) {
            return index;
        }

        return search(data, index + 1);
    }

}
