package Day18_MockTest_Heaps;

import java.util.Arrays;

public class LastStoneWeight {

    public static int lastStoneWeightNaive(int[] stones) {
        if (stones == null || stones.length == 0) return 0;
        int n = stones.length;
        int[] arr = stones.clone();
        while (n > 1) {
            Arrays.sort(arr, 0, n);
            int y = arr[n - 1];
            int x = arr[n - 2];
            if (x == y) {
                n -= 2;
            } else {
                arr[n - 2] = y - x;
                n -= 1;
            }
        }
        return n == 1 ? arr[0] : 0;
    }

    public static void main(String[] args) {
        assert lastStoneWeightNaive(new int[]{2, 7, 4, 1, 8, 1}) == 1 : "Test 1 Failed";
        assert lastStoneWeightNaive(new int[]{1}) == 1 : "Test 2 Failed";
    }
}
