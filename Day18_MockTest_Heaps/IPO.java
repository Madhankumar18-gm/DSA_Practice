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

        // Sort projects by capital required in ascending order
        Arrays.sort(projects, (a, b) -> Integer.compare(a[0], b[0]));

        // Max-heap to store profits of all projects we can currently afford
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
}
