import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem 13: Sliding Window Maximum
 * 
 * You are given an array of integers `nums`, there is a sliding window of size `k`.
 */
public class SlidingWindowMaximum {

    // Monotonic Deque O(N) solution
    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            // Remove indices out of window bounds
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
            // Maintain monotonic decreasing deque order
            while (!deque.isEmpty() && nums[deque.peekLast()] < nums[i]) {
                deque.pollLast();
            }
            deque.offerLast(i);

            if (i >= k - 1) {
                result[i - k + 1] = nums[deque.peekFirst()];
            }
        }
        return result;
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        return maxSlidingWindowDeque(nums, k);
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, -1, -3, 5, 3, 6, 7};
        int k = 3;
        System.out.println("Max Sliding Window: " + Arrays.toString(maxSlidingWindow(nums, k)));
    }
}
