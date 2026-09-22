import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;

/**
 * Problem 13: Sliding Window Maximum
 * 
 * You are given an array of integers `nums`, there is a sliding window of size `k`.
 */
public class SlidingWindowMaximum {

    public static int[] maxSlidingWindowDeque(int[] nums, int k) {
        if (nums == null || nums.length == 0 || k <= 0) {
            return new int[]{};
        }

        int n = nums.length;
        int[] result = new int[n - k + 1];
        Deque<Integer> deque = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!deque.isEmpty() && deque.peekFirst() < i - k + 1) {
                deque.pollFirst();
            }
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
        System.out.println("Null Guard:  " + Arrays.toString(maxSlidingWindow(null, 3)));
        System.out.println("Empty Guard: " + Arrays.toString(maxSlidingWindow(new int[]{}, 3)));
    }
}
