package Day17_HeapsAndPriorityQueue;

import java.util.Arrays;

public class KClosestPointsToOrigin {

    public static int[][] kClosestSorting(int[][] points, int k) {
        if (points == null || k <= 0) return new int[0][0];
        Arrays.sort(points, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(points, 0, k);
    }
}
