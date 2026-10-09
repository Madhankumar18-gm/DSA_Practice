package Day17_HeapsAndPriorityQueue;

import java.util.*;

public class FindMedianFromDataStream {

    public static class MedianFinderList {
        private final List<Integer> list = new ArrayList<>();

        public void addNum(int num) {
            list.add(num);
            Collections.sort(list);
        }

        public double findMedian() {
            int n = list.size();
            if (n == 0) return 0.0;
            if (n % 2 == 1) return list.get(n / 2);
            return (list.get(n / 2 - 1) + list.get(n / 2)) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinderList mf = new MedianFinderList();
        mf.addNum(1);
        mf.addNum(2);
        assert mf.findMedian() == 1.5 : "Test 1 Failed";
        mf.addNum(3);
        assert mf.findMedian() == 2.0 : "Test 2 Failed";
    }
}
