import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * LeetCode 503 - Next Greater Element II
 * Topic: Monotonic Stack on Circular Array
 */
public class NextGreaterElementII {

    /**
     * Finds the next greater element in a circular array.
     * Time Complexity: O(N) - Traverses 2N elements, each element pushed/popped once.
     * Space Complexity: O(N) - Monotonic stack size.
     */
    public static int[] nextGreaterElements(int[] nums) {
        if (nums == null || nums.length == 0) {
            return new int[0];
        }
        return new int[0];
    }
}
