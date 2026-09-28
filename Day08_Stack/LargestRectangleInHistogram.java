import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 84 - Largest Rectangle in Histogram
 * Topic: Monotonic Stack
 */
public class LargestRectangleInHistogram {

    /**
     * Finds the area of the largest rectangle in the histogram.
     * Time Complexity: O(N) - Each bar is pushed and popped at most once.
     * Space Complexity: O(N) - Stack stores bar indices.
     */
    public static int largestRectangleArea(int[] heights) {
        if (heights == null || heights.length == 0) {
            return 0;
        }
        
        int n = heights.length;
        int maxArea = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i <= n; i++) {
            int currentHeight = (i == n) ? 0 : heights[i];
            while (!stack.isEmpty() && currentHeight < heights[stack.peek()]) {
                int height = heights[stack.pop()];
                int width = stack.isEmpty() ? i : i - stack.peek() - 1;
                maxArea = Math.max(maxArea, height * width);
            }
            stack.push(i);
        }
        
        return maxArea;
    }

    public static void printHistogramArea(int[] heights, int maxArea) {
        System.out.println("Histogram: " + java.util.Arrays.toString(heights) + " -> Max Area: " + maxArea);
    }

    public static void main(String[] args) {
        System.out.println("=== Testing LeetCode 84: Largest Rectangle in Histogram ===");
        int[] heights1 = {2, 1, 5, 6, 2, 3};
        int area1 = largestRectangleArea(heights1);
        printHistogramArea(heights1, area1);
    }
}
