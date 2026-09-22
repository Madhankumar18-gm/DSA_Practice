import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Problem 6: Merge Intervals
 * 
 * Given an array of `intervals` where intervals[i] = [starti, endi], merge all overlapping intervals.
 */
public class MergeIntervals {

    public static int[][] mergeOptimal(int[][] intervals) {
        if (intervals == null || intervals.length <= 1) {
            return intervals == null ? new int[0][0] : intervals;
        }

        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        List<int[]> merged = new ArrayList<>();
        int[] currentInterval = intervals[0];
        merged.add(currentInterval);

        for (int[] interval : intervals) {
            int currentEnd = currentInterval[1];
            int nextStart = interval[0];
            int nextEnd = interval[1];

            if (currentEnd >= nextStart) {
                currentInterval[1] = Math.max(currentEnd, nextEnd);
            } else {
                currentInterval = interval;
                merged.add(currentInterval);
            }
        }
        return merged.toArray(new int[merged.size()][]);
    }

    public static int[][] merge(int[][] intervals) {
        return mergeOptimal(intervals);
    }

    public static void main(String[] args) {
        int[][] input1 = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Test 1: " + Arrays.deepToString(merge(input1)));

        System.out.println("Null Guard: " + Arrays.deepToString(merge(null)));
        System.out.println("Empty Guard: " + Arrays.deepToString(merge(new int[0][0])));
    }
}
