package com.devstromo.queue;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    public void testQueueInsertion() {
        var queue = new Queue<Integer>(1);
        queue.enqueue(2);
        assertEquals(2, queue.peek());
        assertFalse(queue.isEmpty());
        assertTrue(queue.isFull());
        assertEquals(2, queue.dequeue());
        assertTrue(queue.isEmpty());
    }
}