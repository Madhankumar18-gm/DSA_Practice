import java.util.Arrays;

/**
 * Problem 6: Merge Intervals
 * 
 * Given an array of `intervals` where intervals[i] = [starti, endi], merge all overlapping intervals.
 */
public class MergeIntervals {

    public static int[][] mergeBasic(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals;
    }

    public static int[][] merge(int[][] intervals) {
        return mergeBasic(intervals);
    }

    public static void main(String[] args) {
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        System.out.println("Sorted Intervals: " + Arrays.deepToString(merge(intervals)));
    }
}
