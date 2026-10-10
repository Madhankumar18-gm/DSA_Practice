package Day18_MockTest_Heaps;

import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

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

        // Insufficient starting capital
        int[] p3 = {1, 5};
        int[] c3 = {10, 20};
        assert findMaximizedCapital(2, 5, p3, c3) == 5 : "Insufficient capital test";
    }
}
