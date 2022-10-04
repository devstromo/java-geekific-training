package com.devstromo;

public record InsertionSort<T extends Comparable<T>>(T[] arr) {
    public void sort(int start, int end) {
        for (int i = start; i <= end; i++) {
            int j = i;
            // change comparator sign to descending ordering
            while (j > 0 && arr[j].compareTo(arr[j - 1]) < 0) {
                T temp = arr[j];
                arr[j] = arr[j - 1];
                arr[j - 1] = temp;
                j--;
            }
        }
    }
}
