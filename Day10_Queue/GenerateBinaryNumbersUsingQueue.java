package Day10_Queue;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class GenerateBinaryNumbersUsingQueue {
    public static String[] generateBinaryNaive(int n) {
        if (n <= 0) return new String[0];
        String[] res = new String[n];
        for (int i = 1; i <= n; i++) {
            res[i - 1] = Integer.toBinaryString(i);
        }
        return res;
    }
    public static String[] generateBinaryOptimal(int n) {
        if (n <= 0) return new String[0];
        String[] result = new String[n];
        Queue<String> queue = new LinkedList<>();
        queue.offer("1");
        for (int i = 0; i < n; i++) {
            String curr = queue.poll();
            result[i] = curr;
            queue.offer(curr + "0");
            queue.offer(curr + "1");
        }
        return result;
    }
    public static void main(String[] args) {
        String[] res = generateBinaryNaive(5);
        assert Arrays.equals(res, new String[]{"1", "10", "11", "100", "101"});
        String[] resOpt = generateBinaryOptimal(5);
        assert Arrays.equals(resOpt, new String[]{"1", "10", "11", "100", "101"});
        assert generateBinaryOptimal(0).length == 0;
        assert Arrays.equals(generateBinaryOptimal(1), new String[]{"1"});
    }
}
