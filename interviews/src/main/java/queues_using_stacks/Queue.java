package queues_using_stacks;

import java.util.Deque;
import java.util.LinkedList;

public class Queue<T> {
    private final Deque<T> stack1 = new LinkedList<>();
    private final Deque<T> stack2 = new LinkedList<>();

    public void enqueue(T value) {
        while (!stack1.isEmpty()) {
            stack2.push(stack1.pop());
        }
        stack1.push(value);
        while (!stack2.isEmpty()) {
            stack1.push(stack2.pop());
        }
    }

    public T dequeue() {
        if (stack1.isEmpty()) {
            return null;
        }
        return stack1.pop();
    }

    public T peek() {
        if (stack1.isEmpty()) {
            return null;
        }
        return stack1.peek();
    }

    public boolean isEmpty() {
        return stack1.isEmpty();
    }
}
