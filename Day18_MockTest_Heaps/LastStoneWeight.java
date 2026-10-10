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
}
