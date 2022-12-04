package kadane;

import static java.lang.Math.max;

/**
 * Maximum Subarray Problem
 * <p>
 * find the largest possible sum of a contiguous sub-array within a given one-dimensional array
 * <p>
 * The local maximum at index i is the max between: the value store at index i and the sum o f that value to the local maximum at
 * index i-1 previously calculated
 * localMax[i] = max(arr[i], arr[i] + localMax[i-1])
 */
public class KadanesAlgorithm {
    public static int solve(int[] numbers) {
        int localMaximum = 0;
        int globalMaximum = Integer.MIN_VALUE;
        for (var num : numbers) {
            localMaximum = max(num, num + localMaximum);
            globalMaximum = max(localMaximum, globalMaximum);
        }
        return globalMaximum;
    }
}
