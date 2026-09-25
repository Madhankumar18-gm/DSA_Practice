/**
 * Problem 43: Add Two Numbers (LeetCode 2)
 * 
 * Add two numbers represented as reverse linked lists.
 * 
 * Time Complexity: O(max(N, M)) where N and M are lengths of l1 and l2.
 * Space Complexity: O(max(N, M)) for the output list.
 */
public class AddTwoNumbers {
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
     * Adds two numbers stored in reverse order as linked lists.
     * @param l1 First number list
     * @param l2 Second number list
     * @return Head of sum linked list
     */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        if (l1 == null) return l2;
        if (l2 == null) return l1;
        return null;
    }
}
