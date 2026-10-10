package Day18_MockTest_Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class MaximumSubsequenceScore {

    public static long maxScore(int[] nums1, int[] nums2, int k) {
        if (nums1 == null || nums2 == null || nums1.length == 0 || k <= 0 || k > nums1.length) {
            return 0;
        }

        int n = nums1.length;
        int[][] pairs = new int[n][2];
        for (int i = 0; i < n; i++) {
            pairs[i][0] = nums1[i];
            pairs[i][1] = nums2[i];
        }

        Arrays.sort(pairs, (a, b) -> Integer.compare(b[1], a[1]));

        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        long currentSum = 0;
        long maxScore = 0;

        for (int i = 0; i < n; i++) {
            minHeap.offer(pairs[i][0]);
            currentSum += pairs[i][0];

            if (minHeap.size() > k) {
                currentSum -= minHeap.poll();
            }

            if (minHeap.size() == k) {
                long score = currentSum * pairs[i][1];
                if (score > maxScore) {
                    maxScore = score;
                }
            }
        }

        return maxScore;
    }

    public static void main(String[] args) {
        int[] nums1 = {1, 3, 3, 2};
        int[] nums2 = {2, 1, 3, 4};
        assert maxScore(nums1, nums2, 3) == 12 : "Test 1 Failed";

        int[] a = {4, 2, 3, 1, 1};
        int[] b = {7, 5, 10, 9, 6};
        assert maxScore(a, b, 1) == 30 : "Test 2 Failed";
    }
}
