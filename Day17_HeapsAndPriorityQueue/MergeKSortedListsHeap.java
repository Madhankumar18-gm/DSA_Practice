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

    public static void main(String[] args) {
        ListNode l1 = new ListNode(1); l1.next = new ListNode(4);
        ListNode l2 = new ListNode(1); l2.next = new ListNode(3);
        ListNode res = mergeKListsBruteForce(new ListNode[]{l1, l2});
        assert res != null && res.val == 1 && res.next.val == 1 : "Test 1 Failed";
    }
}
