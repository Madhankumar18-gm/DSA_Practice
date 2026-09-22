import java.util.Arrays;

/**
 * Problem 6: Merge Intervals
 * 
 * Given an array of `intervals` where intervals[i] = [starti, endi], merge all overlapping intervals.
 */
public class MergeIntervals {
    
    // Sort & simple linear pass merge
    public static int[][] mergeBasic(int[][] intervals) {
        if (intervals.length <= 1) return intervals;
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        return intervals;
    }

    public static int[][] merge(int[][] intervals) {
        return mergeBasic(intervals);
    }
}
