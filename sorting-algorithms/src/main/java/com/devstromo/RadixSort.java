package com.devstromo;

import static java.lang.System.arraycopy;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// sort integers
public record RadixSort(int[] arr) {

    public void sort() {
        int max = Arrays.stream(arr)
            .max()
            .orElse(Integer.MAX_VALUE);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(exp);
        }
    }

    public void sortForNegative() {
        Map<Boolean, List<Integer>> splitArray = Arrays.stream(arr)
            .boxed()
            .collect(Collectors.partitioningBy(i -> i < 0));

        int[] negativeInts = radixSort(splitArray.get(true)
            .stream()
            .mapToInt(Integer::intValue)
            .map(Math::abs)
            .toArray());

        int[] positiveInts = radixSort(splitArray.get(false)
            .stream()
            .mapToInt(Integer::intValue)
            .toArray());
        for (int i = negativeInts.length - 1, j = 0; i >= 0; i--, j++) {
            arr[j] = -negativeInts[i];
        }
        arraycopy(positiveInts, 0, arr, negativeInts.length, positiveInts.length);
    }

    private int[] radixSort(int[] arr) {
        int max = Arrays.stream(arr)
            .max()
            .orElse(Integer.MAX_VALUE);
        for (int exp = 1; max / exp > 0; exp *= 10) {
            countingSort(exp, arr);
        }

        return arr;
    }

    private void countingSort(int exp) {
        countingSort(exp, this.arr);
    }

    private void countingSort(int exp, int[] arr) {
        int[] countArray = new int[10];
        for (int value : arr) {
            countArray[(value / exp) % 10]++;
        }

        for (int i = 1; i < 10; i++) {
            countArray[i] += countArray[i - 1];
        }

        int[] output = new int[arr.length];
        for (int i = arr.length - 1; i >= 0; i--) {
            int current = arr[i];
            int positionInArray = countArray[(current / exp) % 10] - 1;
            output[positionInArray] = current;
            countArray[(current / exp) % 10]--;
        }
        arraycopy(output, 0, arr, 0, arr.length);
    }

}
