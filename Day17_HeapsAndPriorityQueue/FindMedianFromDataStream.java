package Day17_HeapsAndPriorityQueue;

import java.util.*;

/**
 * LeetCode 295: Find Median from Data Stream
 * Day 17 - Heaps & Priority Queue
 *
 * Complexities:
 * Naive List: addNum O(N log N), findMedian O(1)
 * Dual Heap: addNum O(log N), findMedian O(1), Space O(N)
 */
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

    public static class MedianFinderDualHeap {
        private final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        private final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        public void addNum(int num) {
            maxHeap.offer(num);
            minHeap.offer(maxHeap.poll());
            if (minHeap.size() > maxHeap.size()) {
                maxHeap.offer(minHeap.poll());
            }
        }

        public double findMedian() {
            if (maxHeap.isEmpty()) return 0.0;
            if (maxHeap.size() > minHeap.size()) return maxHeap.peek();
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        }
    }

    public static void main(String[] args) {
        MedianFinderList mf = new MedianFinderList();
        mf.addNum(1);
        mf.addNum(2);
        assert mf.findMedian() == 1.5 : "Test 1 Failed";
        mf.addNum(3);
        assert mf.findMedian() == 2.0 : "Test 2 Failed";

        MedianFinderDualHeap dh = new MedianFinderDualHeap();
        dh.addNum(1);
        dh.addNum(2);
        assert dh.findMedian() == 1.5 : "Test 3 Failed";
        dh.addNum(3);
        assert dh.findMedian() == 2.0 : "Test 4 Failed";

        dh.addNum(-1);
        dh.addNum(-2);
        assert dh.findMedian() == 1.0 : "Refactor Test Failed";

        MedianFinderDualHeap empty = new MedianFinderDualHeap();
        assert empty.findMedian() == 0.0 : "Edge Test: Empty stream";

        System.out.println("Execution completed successfully for FindMedianFromDataStream.");
    }
}
