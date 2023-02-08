package com.devstromo.stack;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class StackTest {
    @Test
    public void testPushData() {
        var stack = new Stack<Integer>();
        stack.push(5);
        assertEquals(5, stack.peek());
    }

    @Test
    public void testIsEmpty() {
        var stack = new Stack<Integer>();
        stack.push(5);
        assertEquals(5, stack.pop());
        assertTrue(stack.isEmpty());
    }

}