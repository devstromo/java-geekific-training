package com.devstromo.tree.tries;

import java.util.HashMap;
import java.util.Map;

import lombok.Data;
import lombok.ToString;

@Data
public class Node {
    private final char character;
    private boolean isEndOfWord;

    @ToString.Exclude
    private Map<Character, Node> children = new HashMap<>();
}
