package Day10_Queue;

import java.util.LinkedList;
import java.util.Queue;

public class NumberOfStudentsUnableToEatLunch {
    public static int countStudentsNaive(int[] students, int[] sandwiches) {
        Queue<Integer> q = new LinkedList<>();
        for (int s : students) q.offer(s);
        int sIdx = 0;
        int unableCount = 0;
        while (!q.isEmpty() && unableCount < q.size()) {
            if (q.peek() == sandwiches[sIdx]) {
                q.poll();
                sIdx++;
                unableCount = 0;
            } else {
                q.offer(q.poll());
                unableCount++;
            }
        }
        return q.size();
    }
}
