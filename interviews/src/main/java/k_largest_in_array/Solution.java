package k_largest_in_array;

import java.util.Arrays;
import java.util.PriorityQueue;

public class Solution {

    // O(nlogn)
    public int findKthLargest(int[] nums, int k) {
        Arrays.sort(nums);
        return nums[nums.length - k];
    }

    // O(nlogk)
    public int findKthLargestMinimumHeap(int[] nums, int k) {
        var minHeap = new PriorityQueue<Integer>(k);
        for (var item : nums) {
            minHeap.offer(item);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }
}
