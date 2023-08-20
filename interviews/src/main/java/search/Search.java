package search;

public class Search {

    /**
     * Search in rotate array
     */
    public static int searchInRotate(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;
            if (nums[mid] == target)
                return mid;
            // the first subarray is sorted
            if (nums[left] <= nums[mid]) {

                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1;
                } else {
                    left = mid + 1;
                }
                // the second subarray is sorted
            } else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1;
                } else {
                    right = mid - 1;
                }
            }
        }
        return -1;
    }

    public static boolean searchMatrix(int[][] matrix, int target) {
        for (var row : matrix) {
            if (row[0] <= target && target <= row[row.length - 1]) {
                return find(row, target); // Binary Search the target
            }
        }
        return false;
    }

    // this solution will not work as the rows are not sorted among themselves
    public static boolean searchMatrixByRow(int[][] matrix, int target) {
        var myRow = getRow(matrix, target); // Binary Search the Row
        return myRow != null && find(myRow, target);
    }

    /**
     *  Rows are sorted individually but not among other rows
     *  2  5  9  10 14
     *  3  7  11 12 17
     *  4  13 20 23 30
     *  6  15 25 26 31
     *  O(nlogn)
     */
    public static boolean searchMatrixNotSortedAmongRows(int[][] matrix, int target) {
        var result = false;
        for (var row : matrix) {
            if (row[0] <= target && target <= row[row.length - 1]) {
                result |= find(row, target); // Binary Search the target
            }
        }
        return result;
    }

    /**
     *  Rows are sorted individually but not among other rows
     *  2  5  9  10 14
     *  3  7  11 12 17
     *  4  13 20 23 30
     *  6  15 25 26 31
     *  O(n) + O(m)
     */
    public static boolean searchMatrixBySteps(int[][] matrix, int target) {
        var rows = matrix.length;
        var cols = matrix[0].length;
        var i = rows - 1;
        var j = 0;
        while (i >= 0 && j < cols) {
            if (matrix[i][j] < target)
                j++;
            else if (matrix[i][j] > target) {
                i--;
            } else
                return true;
        }
        return false;
    }

    private static boolean find(int[] nums, int target) {
        var left = 0;
        var right = nums.length - 1;
        while (left <= right) {
            var mid = left + (right - left) / 2;
            if (target < nums[mid]) {
                right = mid - 1;
            } else if (target > nums[mid]) {
                left = mid + 1;
            } else {
                return true;
            }
        }
        return false;
    }

    private static int[] getRow(int[][] matrix, int target) {
        var low = 0;
        var high = matrix.length - 1;
        while (low <= high) {
            var mid = low + (high - low) / 2;
            if (target < matrix[mid][0]) {
                high = mid - 1;
            } else if (target > matrix[mid][matrix[0].length - 1]) {
                low = mid + 1;
            } else {
                return matrix[mid];
            }
        }
        return null;
    }
}
