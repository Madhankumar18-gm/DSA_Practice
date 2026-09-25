import java.util.PriorityQueue;

/**
 * Problem 44: Merge k Sorted Lists (LeetCode 23)
 * 
 * Merge k sorted linked lists and return it as one sorted list.
 * 
 * Time Complexity: O(N log K) where N is total nodes and K is number of linked lists.
 * Space Complexity: O(K) for PriorityQueue min-heap storage.
 */
public class MergeKSortedLists {
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
}
