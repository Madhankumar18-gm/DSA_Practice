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
    public static int countStudentsOptimal(int[] students, int[] sandwiches) {
        if (students == null || sandwiches == null || students.length == 0) return 0;
        int count0 = 0, count1 = 0;
        for (int s : students) {
            if (s == 0) count0++;
            else count1++;
        }
        for (int s : sandwiches) {
            if (s == 0) {
                if (count0 == 0) return count1;
                count0--;
            } else {
                if (count1 == 0) return count0;
                count1--;
            }
        }
        return 0;
    }
    public static void main(String[] args) {
        int[] stud = {1, 1, 0, 0};
        int[] sand = {0, 1, 0, 1};
        assert countStudentsNaive(stud, sand) == 0;
        assert countStudentsOptimal(stud, sand) == 0;
        int[] stud2 = {1, 1, 1, 0, 0, 1};
        int[] sand2 = {1, 0, 0, 0, 1, 1};
        assert countStudentsOptimal(stud2, sand2) == 3;
    }
}
