package Day17_HeapsAndPriorityQueue;

import java.util.*;

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
}
