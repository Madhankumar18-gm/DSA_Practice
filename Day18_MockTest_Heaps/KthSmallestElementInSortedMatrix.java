package Day18_MockTest_Heaps;

import java.util.Arrays;

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

    public static void main(String[] args) {
        int[][] mat1 = {
            {1, 5, 9},
            {10, 11, 13},
            {12, 13, 15}
        };
        assert kthSmallestNaive(mat1, 8) == 13 : "Test 1 Failed";
        assert kthSmallestNaive(new int[][]{{-5}}, 1) == -5 : "Test 2 Failed";
    }
}
