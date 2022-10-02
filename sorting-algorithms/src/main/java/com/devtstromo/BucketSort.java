package com.devtstromo;

import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.function.BiFunction;
import java.util.stream.IntStream;

public record BucketSort<T extends Number & Comparable<T>>() {

    public List<T> sort(List<T> list, BiFunction<T, Integer, Integer> function) {
        int numOfBucket = list.size();
        Map<Integer, List<T>> buckets = new HashMap<>();
        // init buckets
        IntStream.range(0, numOfBucket)
            .forEach(i -> buckets.put(i, new LinkedList<>()));
        // fill buckets
        list.forEach(item -> buckets.get(function.apply(item, numOfBucket))
            .add(item));
        // sort data
        buckets.values()
            .forEach(Collections::sort);
        return buckets.values()
            .stream()
            .flatMap(Collection::stream)
            .toList();
    }
}
