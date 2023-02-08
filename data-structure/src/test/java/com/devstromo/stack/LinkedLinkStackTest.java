package com.devstromo.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LinkedLinkStackTest {

    @Test
    public void testPushData() {
        var stack = new LinkedLinkStack<Integer>();
        stack.push(5);
        assertEquals(5, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        var stack = new LinkedLinkStack<Integer>();
        stack.push(5);
        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
    }
}