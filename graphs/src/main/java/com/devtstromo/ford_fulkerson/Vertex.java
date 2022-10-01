package com.devtstromo.ford_fulkerson;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
public class Vertex<T> {
    private final T data;
    private boolean visited;
    @ToString.Exclude
    @EqualsAndHashCode.Exclude
    private Map<Vertex<T>, Integer> neighbors = new HashMap<>();
}
