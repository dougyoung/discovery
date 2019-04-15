import java.util.Arrays;

public class Solution {
    public enum CLOSEST {
        ACTUAL,
        EXACT_MATCH,
        LESS_THAN,
        GREATER_THAN,
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        assert(!solution.searchMatrix(new int[][] { {} }, 3));

        int[][] matrix = {
            { 1,   3,  5,  7 },
            { 10, 11, 16, 20 },
            { 23, 30, 34, 50 }
        };

        assert(!solution.searchMatrix(matrix, 0));
        assert(solution.searchMatrix(matrix, 1));
        assert(!solution.searchMatrix(matrix, 2));
        assert(solution.searchMatrix(matrix, 3));
        assert(!solution.searchMatrix(matrix, 4));
        assert(solution.searchMatrix(matrix, 5));
        assert(!solution.searchMatrix(matrix, 6));
        assert(solution.searchMatrix(matrix, 7));
        assert(!solution.searchMatrix(matrix, 8));
        assert(!solution.searchMatrix(matrix, 9));
        assert(solution.searchMatrix(matrix, 10));
        assert(solution.searchMatrix(matrix, 11));
        assert(!solution.searchMatrix(matrix, 12));
        assert(!solution.searchMatrix(matrix, 13));
        assert(!solution.searchMatrix(matrix, 14));
        assert(!solution.searchMatrix(matrix, 15));
        assert(solution.searchMatrix(matrix, 16));

        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, -1, CLOSEST.EXACT_MATCH) == -1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 0, CLOSEST.EXACT_MATCH) == -1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 1, CLOSEST.EXACT_MATCH) == 0);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 2, CLOSEST.EXACT_MATCH) == -1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 3, CLOSEST.EXACT_MATCH) == 1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 4, CLOSEST.EXACT_MATCH) == -1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 5, CLOSEST.EXACT_MATCH) == 2);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 6, CLOSEST.EXACT_MATCH) == -1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 7, CLOSEST.EXACT_MATCH) == 3);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 8, CLOSEST.EXACT_MATCH) == -1);

        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, -1, CLOSEST.LESS_THAN) == -1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 0, CLOSEST.LESS_THAN) == -1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 1, CLOSEST.LESS_THAN) == 0);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 2, CLOSEST.LESS_THAN) == 0);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 3, CLOSEST.LESS_THAN) == 1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 4, CLOSEST.LESS_THAN) == 1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 5, CLOSEST.LESS_THAN) == 2);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 6, CLOSEST.LESS_THAN) == 2);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 7, CLOSEST.LESS_THAN) == 3);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 8, CLOSEST.LESS_THAN) == 3);

        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, -1, CLOSEST.GREATER_THAN) == 0);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 0, CLOSEST.GREATER_THAN) == 0);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 1, CLOSEST.GREATER_THAN) == 0);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 2, CLOSEST.GREATER_THAN) == 1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 3, CLOSEST.GREATER_THAN) == 1);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 4, CLOSEST.GREATER_THAN) == 2);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 5, CLOSEST.GREATER_THAN) == 2);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 6, CLOSEST.GREATER_THAN) == 3);
        assert(solution.binarySearch(new int[] { 1, 3, 5, 7}, 7, CLOSEST.GREATER_THAN) == 3);
    }

    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix.length == 0) return false;
        if (matrix[0].length == 0) return false;

        int[] columnZero = Arrays.stream(matrix).mapToInt(ints -> ints[0]).toArray();

        if (columnZero.length == 0) return false;
        if (columnZero[0] > target) return false;

        int targetRowIndex = binarySearch(columnZero, target, CLOSEST.LESS_THAN);
        int targetIndex = binarySearch(matrix[targetRowIndex], target, CLOSEST.EXACT_MATCH);

        return targetIndex >= 0;
    }

    public int binarySearch(int[] vector, int target, CLOSEST closest) {
        if (vector.length == 0) throw new IllegalArgumentException("Vector must have length");

        return binarySearchHelper(vector, 0, vector.length - 1, target, closest);
    }

    private int binarySearchHelper(int[] vector, int left, int right, int target, CLOSEST closest) {
        if (left <= right) {
            int mid = left + (right - left) / 2;
            if (vector[mid] == target) return mid;
            if (vector[mid] < target) return binarySearchHelper(vector, mid + 1, right, target, closest);
            if (vector[mid] > target) return binarySearchHelper(vector, left, mid - 1, target, closest);
            else throw new IllegalStateException("Laws of math defied!");
        } else if (closest == CLOSEST.EXACT_MATCH) {
            return -1;
        } else if (closest == CLOSEST.GREATER_THAN) {
            return left;
        } else if (closest == CLOSEST.LESS_THAN) {
            return right;
        } else if (closest == CLOSEST.ACTUAL && (vector[left] - target) < (target - vector[right])) {
            return left;
        } else if (closest == CLOSEST.ACTUAL){
            return right;
        } else {
            throw new UnsupportedOperationException(closest + " unsupported.");
        }
    }

}
