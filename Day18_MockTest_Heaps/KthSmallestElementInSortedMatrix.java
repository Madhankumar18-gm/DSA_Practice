package Day18_MockTest_Heaps;

import java.util.Arrays;
import java.util.PriorityQueue;

public class KthSmallestElementInSortedMatrix {

    public static int kthSmallestNaive(int[][] matrix, int k) {
        int n = matrix.length;
        int[] flat = new int[n * n];
        int idx = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                flat[idx++] = matrix[i][j];
            }
        }
        Arrays.sort(flat);
        return flat[k - 1];
    }

    public static int kthSmallestMinHeap(int[][] matrix, int k) {
        int n = matrix.length;
        // Element: [val, row, col]
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        for (int r = 0; r < Math.min(n, k); r++) {
            pq.offer(new int[]{matrix[r][0], r, 0});
        }
        for (int i = 0; i < k - 1; i++) {
            int[] curr = pq.poll();
            int r = curr[1];
            int c = curr[2];
            if (c + 1 < n) {
                pq.offer(new int[]{matrix[r][c + 1], r, c + 1});
            }
        }
        return pq.peek()[0];
    }

    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        assert kthSmallestNaive(mat1, 8) == 13 : "Test 1 Failed";
        assert kthSmallestNaive(new int[][]{{-5}}, 1) == -5 : "Test 2 Failed";
        assert kthSmallestMinHeap(mat1, 8) == 13 : "Heap Test 1 Failed";
        assert kthSmallestMinHeap(new int[][]{{-5}}, 1) == -5 : "Heap Test 2 Failed";
    }
}
