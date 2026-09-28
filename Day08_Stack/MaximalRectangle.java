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
                heights[j] = (row[j] == '1') ? heights[j] + 1 : 0;
            }
            maxArea = Math.max(maxArea, largestInRow(heights));
        }
        
        return maxArea;
    }

    private static int largestInRow(int[] heights) {
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            int curHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && curHeight < heights[stack.peek()]) {
                int h = heights[stack.pop()];
                int w = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, h * w);
            }
            stack.push(i);
        }
        return maxArea;
    }
}
