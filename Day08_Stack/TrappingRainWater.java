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
        
        int totalWater = 0;
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 0; i < height.length; i++) {
            while (!stack.isEmpty() && height[i] > height[stack.peek()]) {
                int top = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int distance = i - stack.peek() - 1;
                int boundedHeight = Math.min(height[i], height[stack.peek()]) - height[top];
                totalWater += distance * boundedHeight;
            }
            stack.push(i);
        }
        
        return totalWater;
    }
}
