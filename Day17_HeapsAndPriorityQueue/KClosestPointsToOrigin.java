package Day17_HeapsAndPriorityQueue;

import java.util.Arrays;
import java.util.PriorityQueue;

/**
 * LeetCode 973: K Closest Points to Origin
 * Day 17 - Heaps & Priority Queue
 *
 * Complexities:
 * Sorting: Time O(N log N), Space O(log N)
 * Max-Heap: Time O(N log K), Space O(K)
 */
public class KClosestPointsToOrigin {

    public static int[][] kClosestSorting(int[][] points, int k) {
        if (points == null || k <= 0) return new int[0][0];
        int[][] copy = points.clone();
        Arrays.sort(copy, (a, b) -> (a[0] * a[0] + a[1] * a[1]) - (b[0] * b[0] + b[1] * b[1]));
        return Arrays.copyOfRange(copy, 0, k);
    }

    public static int[][] kClosestMaxHeap(int[][] points, int k) {
        if (points == null || k <= 0) return new int[0][0];
        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) ->
            (b[0] * b[0] + b[1] * b[1]) - (a[0] * a[0] + a[1] * a[1])
        );
        for (int[] p : points) {
            maxHeap.offer(p);
            if (maxHeap.size() > k) maxHeap.poll();
        }
        int[][] res = new int[k][2];
        for (int i = 0; i < k; i++) res[i] = maxHeap.poll();
        return res;
    }

    public static void main(String[] args) {
        int[][] res = kClosestSorting(new int[][]{{1, 3}, {-2, 2}}, 1);
        assert res.length == 1 && res[0][0] == -2 && res[0][1] == 2 : "Test 1 Failed";

        int[][] res2 = kClosestMaxHeap(new int[][]{{1, 3}, {-2, 2}}, 1);
        assert res2.length == 1 && res2[0][0] == -2 && res2[0][1] == 2 : "Test 2 Failed";

        int[][] res3 = kClosestMaxHeap(new int[][]{{3, 3}, {5, -1}, {-2, 4}}, 2);
        assert res3.length == 2 : "Refactor Test Failed";

        assert kClosestMaxHeap(null, 1).length == 0 : "Edge Test: Null points";
        assert kClosestMaxHeap(new int[][]{{0, 0}}, 0).length == 0 : "Edge Test: k=0";

        System.out.println("Execution completed successfully for KClosestPointsToOrigin.");
    }
}
