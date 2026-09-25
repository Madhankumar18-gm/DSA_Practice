/**
 * Problem 39: Merge Two Sorted Lists (LeetCode 21)
 * 
 * Merge two sorted linked lists and return it as a sorted list.
 * 
 * Time Complexity: O(N + M) where N and M are the lengths of list1 and list2.
 * Space Complexity: O(1) auxiliary space (iterative splicing).
 */
public class MergeTwoSortedLists {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }

    public static ListNode buildList(int[] values) {
        if (values == null || values.length == 0) return null;
        ListNode dummy = new ListNode(-1);
        ListNode curr = dummy;
        for (int v : values) {
            curr.next = new ListNode(v);
            curr = curr.next;
        }
        return dummy.next;
    }

    public static String toListString(ListNode head) {
        StringBuilder sb = new StringBuilder("[");
        ListNode curr = head;
        while (curr != null) {
            sb.append(curr.val);
            if (curr.next != null) sb.append(", ");
            curr = curr.next;
        }
        sb.append("]");
        return sb.toString();
    }

    /**
     * Merges two sorted linked lists.
     * @param list1 First sorted list
     * @param list2 Second sorted list
     * @return Head of merged sorted list
     */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        return null;
    }
}
