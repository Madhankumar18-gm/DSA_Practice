package Day17_HeapsAndPriorityQueue;

import java.util.Arrays;

public class KthLargestElementInArray {

    public static int findKthLargestSorting(int[] nums, int k) {
        if (nums == null || k <= 0 || k > nums.length) return -1;
        Arrays.sort(nums);
        return nums[nums.length - k];
    }
}
