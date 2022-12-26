package stacks_using_queues;

import java.util.Deque;
import java.util.LinkedList;

public class Stack<T> {
    private Deque<T> queue1 = new LinkedList<>();
    private Deque<T> queue2 = new LinkedList<>();

    public void push(T value) {
        queue2.add(value);
        while (!queue1.isEmpty()) {
            queue2.add(queue1.poll());
        }

        Deque<T> q = queue1;
        queue1 = queue2;
        queue2 = q;
    }

    public T pop() {
        if (queue1.isEmpty()) {
            return null;
        }
        return queue1.pop();
    }

    public T peek() {
        if (queue1.isEmpty()) {
            return null;
        }
        return queue1.peek();
    }

    public boolean isEmpty() {
        return queue1.isEmpty();
    }
}
