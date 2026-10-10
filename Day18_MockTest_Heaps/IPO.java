package Day18_MockTest_Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode 502: IPO
 * 
 * Problem:
 * Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital,
 * LeetCode would like to work on some projects to increase its capital before the IPO.
 * Since it has limited resources, it can only finish at most k distinct projects before the IPO.
 * You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
 * Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
 * Pick a list of at most k distinct projects from given projects to maximize your final capital.
 * 
 * Complexity:
 * - Sorting projects by required capital: O(N log N) time.
 * - Max-Heap for available profits: Each project offered and polled at most once -> O(N log N) time, O(N) space.
 * - Overall: O(N log N) time, O(N) space.
 */
public class IPO {

    public static int findMaximizedCapital(int k, int w, int[] profits, int[] capital) {
        if (profits == null || capital == null || profits.length == 0 || k <= 0) {
            return w;
        }

        int n = profits.length;
        int[][] projects = new int[n][2];
        for (int i = 0; i < n; i++) {
            projects[i][0] = capital[i];
            projects[i][1] = profits[i];
        }

        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));
        PriorityQueue<Integer> availableProfits = new PriorityQueue<>(Collections.reverseOrder());

        int projIdx = 0;
        for (int turn = 0; turn < k; turn++) {
            while (projIdx < n && projects[projIdx][0] <= w) {
                availableProfits.offer(projects[projIdx][1]);
                projIdx++;
            }

            if (availableProfits.isEmpty()) {
                break;
            }

            w += availableProfits.poll();
        }

        return w;
    }

    public static void main(String[] args) {
        int[] profits1 = {1, 2, 3};
        int[] capital1 = {0, 1, 1};
        assert findMaximizedCapital(2, 0, profits1, capital1) == 4 : "Test 1 Failed";

        int[] profits2 = {1, 2, 3};
        int[] capital2 = {0, 1, 2};
        assert findMaximizedCapital(3, 0, profits2, capital2) == 6 : "Test 2 Failed";

        int[] p3 = {1, 5};
        int[] c3 = {10, 20};
        assert findMaximizedCapital(2, 5, p3, c3) == 5 : "Insufficient capital test";

        int[] p4 = {2, 7, 3, 9};
        int[] c4 = {1, 2, 1, 3};
        assert findMaximizedCapital(2, 10, p4, c4) == 26 : "Top 2 profit picks (9 + 7 = 16 + 10 = 26)";

        assert findMaximizedCapital(10, 5, new int[]{2}, new int[]{1}) == 7 : "k > n";
        assert findMaximizedCapital(0, 5, new int[]{2}, new int[]{1}) == 5 : "k == 0";
        assert findMaximizedCapital(2, 5, null, null) == 5 : "Null arrays";
    }
}
