package Day17_HeapsAndPriorityQueue;

import java.util.Arrays;

public class KClosestPointsToOrigin {

    public static int[][] kClosestSorting(int[][] points, int k) {
        if (points == null || k <= 0) return new int[0][0];
        int[][] copy = points.clone();
        Arrays.sort(copy, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(copy, 0, k);
    }

    public static void main(String[] args) {
        int[][] res = kClosestSorting(new int[][]{{1, 3}, {-2, 2}}, 1);
        assert res.length == 1 && res[0][0] == -2 && res[0][1] == 2 : "Test 1 Failed";
    }
}
