import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 85 - Maximal Rectangle
 * Topic: 2D Monotonic Stack Histogram
 */
public class MaximalRectangle {

    /**
     * Finds the largest rectangle containing only 1's in a binary 2D matrix.
     * Time Complexity: O(R * C) where R is rows and C is cols.
     * Space Complexity: O(C) for the dynamic histogram array & stack.
     */
    public static int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int cols = matrix[0].length;
        int[] heights = new int[cols];
        int maxArea = 0;
        
        for (char[] row : matrix) {
            for (int j = 0; j < cols; j++) {
                if (row[j] == '1') {
                    heights[j]++;
                } else {
                    heights[j] = 0;
                }
            }
            maxArea = Math.max(maxArea, largestInRow(heights));
        }
        
        return maxArea;
    }

    private static int largestInRow(int[] heights) {
        return 0;
    }
}
