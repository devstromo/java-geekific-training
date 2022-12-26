package queues_using_stacks;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class QueueTest {

    @Test
    public void testQueue(){
        Queue<Integer> myQueue = new Queue<>();
        myQueue.enqueue(1);
        myQueue.enqueue(2);
        myQueue.enqueue(3);
        assertEquals(1, myQueue.peek());
        assertEquals(1, myQueue.dequeue());
    }

}