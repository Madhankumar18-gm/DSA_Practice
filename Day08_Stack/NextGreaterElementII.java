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
        
        int n = nums.length;
        int[] res = new int[n];
        Arrays.fill(res, -1);
        // Monotonic decreasing stack storing elements
        Deque<Integer> stack = new ArrayDeque<>();
        
        for (int i = 2 * n - 1; i >= 0; i--) {
            int currentNum = nums[i % n];
            while (!stack.isEmpty() && stack.peek() <= currentNum) {
                stack.pop();
            }
            if (i < n) {
                res[i] = stack.isEmpty() ? -1 : stack.peek();
            }
            stack.push(currentNum);
        }
        
        return res;
    }

    public static void printNextGreater(int[] nums, int[] res) {
        System.out.println("Nums: " + Arrays.toString(nums) + " -> Next Greater: " + Arrays.toString(res));
    }
}
