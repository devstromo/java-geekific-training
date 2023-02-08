package com.devstromo.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class LinkedQueueTest {

    @Test
    public void testLinkedQueue(){
        var queue = new LinkedQueue<Integer>();
        assertTrue(queue.isEmpty());
        queue.enqueue(5);
        assertFalse(queue.isEmpty());
        assertEquals(5, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}