/**
 * Problem 51: Reverse Linked List II (LeetCode 92)
 * 
 * Given the head of a singly linked list and two integers left and right where left <= right,
 * reverse the nodes of the list from position left to position right, and return the reversed list.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class ReverseLinkedListII {
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
     * Reverses a subsegment of a linked list.
     * @param head Head of linked list
     * @param left Start position (1-based)
     * @param right End position (1-based)
     * @return Modified linked list head
     */
    public static ListNode reverseBetween(ListNode head, int left, int right) {
        if (head == null || left == right) return head;

        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        for (int i = 0; i < left - 1; i++) {
            prev = prev.next;
        }

        ListNode start = prev.next;
        ListNode then = start.next;

        for (int i = 0; i < right - left; i++) {
            start.next = then.next;
            then.next = prev.next;
            prev.next = then;
            then = start.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("=== ReverseLinkedListII Execution Suite ===");

        // Test 1: [1, 2, 3, 4, 5], left = 2, right = 4 -> [1, 4, 3, 2, 5]
        ListNode l1 = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode res1 = reverseBetween(l1, 2, 4);
        System.out.println("Test 1 Result: " + toListString(res1));
    }
}
