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
                int topIndex = stack.pop();
                if (stack.isEmpty()) {
                    break;
                }
                int leftIndex = stack.peek();
                int distance = i - leftIndex - 1;
                int minHeight = Math.min(height[i], height[leftIndex]);
                int boundedHeight = minHeight - height[topIndex];
                totalWater += distance * boundedHeight;
            }
            stack.push(i);
        }
        
        return totalWater;
    }

    public static void printTrapResult(int[] height, int result) {
        System.out.println("Elevation Map: " + java.util.Arrays.toString(height) + " -> Trapped Water: " + result);
    }
}
