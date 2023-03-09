package com.devstromo;

public record CocktailSort<T extends Comparable<T>>(T[] arr) {

    public void sort() {
        var swapped = true;
        var start = 0;
        var end = arr.length - 1;
        while (swapped) {
            swapped = false;
            for (var i = start; i < end; i++) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    swapped = true;
                }
            }
            if (!swapped)
                break;
            swapped = false;
            end--;
            for (var i = end - 1; i >= start; i--) {
                if (arr[i].compareTo(arr[i + 1]) > 0) {
                    T aux = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = aux;
                    swapped = true;
                }
            }
            start++;
        }
    }

}
