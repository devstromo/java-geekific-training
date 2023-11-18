package k_largest_in_array;

import java.util.PriorityQueue;

public class KthLargest {
    int k = 0;
    PriorityQueue<Integer> minHeap;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>();
        for (var item : nums) {
            minHeap.add(item);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
    }

    public int add(int val) {
        if (minHeap.isEmpty() || minHeap.size() < k) {
            minHeap.add(val);
        } else {
            minHeap.add(val);
            minHeap.poll();
        }
        return minHeap.peek();
    }
}
