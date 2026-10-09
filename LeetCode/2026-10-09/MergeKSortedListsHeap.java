package Day17_HeapsAndPriorityQueue;

import java.util.*;

/**
 * LeetCode 23: Merge k Sorted Lists
 * Day 17 - Heaps & Priority Queue
 *
 * Complexities:
 * Brute Force: Time O(N log N), Space O(N)
 * Min-Heap: Time O(N log K), Space O(K)
 */
public class MergeKSortedListsHeap {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode mergeKListsBruteForce(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        List<Integer> vals = new ArrayList<>();
        for (ListNode node : lists) {
            while (node != null) {
                vals.add(node.val);
                node = node.next;
            }
        }
        Collections.sort(vals);
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        for (int v : vals) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static ListNode mergeKListsMinHeap(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a.val));
        for (ListNode node : lists) {
            if (node != null) pq.offer(node);
        }
        ListNode dummy = new ListNode(0);
        ListNode curr = dummy;
        while (!pq.isEmpty()) {
            ListNode top = pq.poll();
            curr.next = top;
            curr = curr.next;
            if (top.next != null) pq.offer(top.next);
        }
        return dummy.next;
    }

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1); l1.next = new ListNode(4);
        ListNode l2 = new ListNode(1); l2.next = new ListNode(3);
        ListNode res = mergeKListsBruteForce(new ListNode[]{l1, l2});
        assert res != null && res.val == 1 && res.next.val == 1 : "Test 1 Failed";

        ListNode l3 = new ListNode(1); l3.next = new ListNode(4);
        ListNode l4 = new ListNode(1); l4.next = new ListNode(3);
        ListNode res2 = mergeKListsMinHeap(new ListNode[]{l3, l4});
        assert res2 != null && res2.val == 1 && res2.next.val == 1 : "Test 2 Failed";

        ListNode r = mergeKListsMinHeap(new ListNode[]{new ListNode(5), new ListNode(2), new ListNode(9)});
        assert r.val == 2 && r.next.val == 5 && r.next.next.val == 9 : "Refactor Test Failed";

        assert mergeKListsMinHeap(new ListNode[]{}) == null : "Edge Test: Empty array";
        assert mergeKListsMinHeap(null) == null : "Edge Test: Null input";

        System.out.println("Execution completed successfully for MergeKSortedListsHeap.");
    }
}
