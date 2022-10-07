package com.devstromo;

public record DualPivotQuickSort<T extends Comparable<T>>(T[] arr) {

    public record Pivot(int left, int right) {
    }

    public void sort() {
        dualPivotQuicksort(0, arr.length - 1);
    }

    private void dualPivotQuicksort(int low, int high) {
        if (low >= high) {
            return;
        }
        Pivot pivot = partition(low, high);
        dualPivotQuicksort(low, pivot.left() - 1); // Group 1
        dualPivotQuicksort(pivot.left() + 1, pivot.right() - 1); // Group 2
        dualPivotQuicksort(pivot.right() + 1, high); //Group 3
    }

    private Pivot partition(int low, int high) {
        if (arr[low].compareTo(arr[high]) > 0)
            swap(low, high);
        int leftPivotIndex = low + 1;
        int rightPivotIndex = high - 1;
        int iterator = low + 1;
        while (iterator <= rightPivotIndex) {
            if (arr[iterator].compareTo(arr[low]) < 0) {
                swap(iterator++, leftPivotIndex++);
            } else if (arr[iterator].compareTo(arr[high]) > 0) {
                swap(iterator, rightPivotIndex--);
            } else {
                iterator++;
            }
        }
        swap(low, --leftPivotIndex);
        swap(high, ++rightPivotIndex);
        return new Pivot(leftPivotIndex, rightPivotIndex);
    }

    private void swap(int firstIndex, int secondIndex) {
        T temp = arr[firstIndex];
        arr[firstIndex] = arr[secondIndex];
        arr[secondIndex] = temp;
    }
}
