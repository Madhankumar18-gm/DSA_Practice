package Day10_Queue;

import java.util.Arrays;

public class GenerateBinaryNumbersUsingQueue {
    public static String[] generateBinaryNaive(int n) {
        if (n <= 0) return new String[0];
        String[] res = new String[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = Integer.toBinaryString(i);
        }
        return res;
    }
    public static void main(String[] args) {
        String[] res = generateBinaryNaive(5);
        assert Arrays.equals(res, new String[]{"1", "10", "11", "100", "101"});
    }
}
