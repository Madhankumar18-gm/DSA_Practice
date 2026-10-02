package Day11_Hashing;

import java.util.HashMap;
import java.util.Map;

public class FourSumII {
    public static int fourSumCountNaive(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        int count = 0;
        for (int a : nums1) {
            for (int b : nums2) {
                for (int c : nums3) {
                    for (int d : nums4) {
                        if (a + b + c + d == 0) count++;
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) {
        int[] a = {1, 2}, b = {-2, -1}, c = {-1, 2}, d = {0, 2};
        assert fourSumCountNaive(a, b, c, d) == 2;
    }
}
