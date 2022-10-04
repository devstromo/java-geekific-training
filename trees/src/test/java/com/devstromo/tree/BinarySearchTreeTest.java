package com.devstromo.tree;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class BinarySearchTreeTest {

    @Test
    public void shouldAddNewValueTest() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(1);
        assertFalse(tree.isEmpty());
    }

    @Test
    public void shouldDeleteValueTest() {
        Tree<Integer> tree = new BinarySearchTree<>();
        tree.insert(1);
        tree.insert(2);
        tree.traverse();
        assertFalse(tree.isEmpty());
        tree.delete(1);
        tree.delete(2);
        assertTrue(tree.isEmpty());
    }
}
