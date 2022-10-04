package com.devstromo;

import static java.lang.System.arraycopy;

public record MergeSort<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        mergesort(0, arr.length - 1);
    }

    private void mergesort(int low, int high) {
        if (low >= high) {
            return; // no need to divide anymore
        }
        int middle = (low + high) / 2;
        mergesort(low, middle);
        mergesort(middle + 1, high);
        merge(low, middle, high);
    }

    public void merge(int low, int middle, int high) {
        T[] leftArray = (T[]) new Comparable[middle - low + 1];
        T[] rightArray = (T[]) new Comparable[high - middle];
        arraycopy(arr, low, leftArray, 0, leftArray.length);
        arraycopy(arr, middle + 1, rightArray, 0, rightArray.length);
        int leftSubArrCounter = 0;
        int rightSubArrCounter = 0;
        int arrCounter = low;
        // change comparator sign to change ordering type
        while (leftSubArrCounter < leftArray.length && rightSubArrCounter < rightArray.length) {
            if (leftArray[leftSubArrCounter].compareTo(rightArray[rightSubArrCounter]) <= 0) {
                arr[arrCounter] = leftArray[leftSubArrCounter];
                arrCounter++;
                leftSubArrCounter++;
            } else {
                arr[arrCounter] = rightArray[rightSubArrCounter];
                arrCounter++;
                rightSubArrCounter++;
            }
        }

        while (leftSubArrCounter < leftArray.length) {
            arr[arrCounter++] = leftArray[leftSubArrCounter++];
        }
        while (rightSubArrCounter < rightArray.length) {
            arr[arrCounter++] = rightArray[rightSubArrCounter++];
        }

    }

    private void mergeV2(int low, int middle, int high) {
        T[] tempArray = (T[]) new Comparable[arr.length];
        if (high + 1 - low >= 0)
            arraycopy(arr, low, tempArray, low, high + 1 - low);

        int firstSubArrCounter = low;
        int secondSubArrCounter = middle + 1;
        int arrCounter = low;

        while (firstSubArrCounter <= middle && secondSubArrCounter <= high) {
            arr[arrCounter++] = tempArray[firstSubArrCounter].compareTo(tempArray[secondSubArrCounter]) <= 0 ? tempArray[firstSubArrCounter++] :
                tempArray[secondSubArrCounter++];
        }

        while (firstSubArrCounter <= middle) {
            arr[arrCounter++] = tempArray[firstSubArrCounter++];
        }
        while (secondSubArrCounter <= high) {
            arr[arrCounter++] = tempArray[secondSubArrCounter++];
        }
    }
}
