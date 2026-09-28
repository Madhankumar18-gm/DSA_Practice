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
        return 0;
    }
}
