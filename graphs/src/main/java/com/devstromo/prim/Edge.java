package com.devstromo.prim;

import lombok.Data;

@Data
public class Edge {
    private final int weight;
    private boolean included;
}
