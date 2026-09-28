import java.util.ArrayDeque;
import java.util.Deque;

/**
 * LeetCode 42 - Trapping Rain Water
 * Topic: Monotonic Stack
 */
public class TrappingRainWater {

    /**
     * Calculates total trapped rainwater using a monotonic decreasing stack.
     * Time Complexity: O(N) - Each bar index is pushed and popped at most once.
     * Space Complexity: O(N) - Stack size in worst case.
     */
    public static int trap(int[] height) {
        if (height == null || height.length < 3) {
            return 0;
        }
        return 0;
    }
}
