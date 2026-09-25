/**
 * Problem 41: Reorder List (LeetCode 143)
 * 
 * Reorder list to L0 -> Ln -> L1 -> Ln-1 -> L2 -> Ln-2 ...
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) in-place modification.
 */
public class ReorderList {
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
     * Reorders the linked list in-place.
     * @param head Head of linked list
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null) return;
    }
}
