/**
 * Problem 40: Remove Nth Node From End of List (LeetCode 19)
 * 
 * Given the head of a linked list, remove the nth node from the end of the list and return its head.
 * 
 * Time Complexity: O(N) single-pass.
 * Space Complexity: O(1) using two pointers with an n-node gap.
 */
public class RemoveNthNodeFromEnd {
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
     * Removes the nth node from the end of the linked list.
     * @param head Head of linked list
     * @param n Index from the end (1-based)
     * @return New head of modified list
     */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
        if (head == null || n <= 0) return head;

        ListNode dummy = new ListNode(0, head);
        ListNode fast = dummy;
        ListNode slow = dummy;

        for (int i = 0; i <= n; i++) {
            if (fast == null) return head;
            fast = fast.next;
        }

        while (fast != null) {
            slow = slow.next;
            fast = fast.next;
        }

        if (slow.next != null) {
            slow.next = slow.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("=== RemoveNthNodeFromEnd Execution Suite ===");

        // Test 1: [1, 2, 3, 4, 5], n = 2 -> [1, 2, 3, 5]
        ListNode l1 = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode res1 = removeNthFromEnd(l1, 2);
        System.out.println("Test 1 Result: " + toListString(res1));
        assert toListString(res1).equals("[1, 2, 3, 5]") : "Test 1 Failed!";

        // Test 2: [1], n = 1 -> []
        ListNode l2 = buildList(new int[]{1});
        ListNode res2 = removeNthFromEnd(l2, 1);
        System.out.println("Test 2 Result: " + toListString(res2));
        assert toListString(res2).equals("[]") : "Test 2 Failed!";

        // Test 3: [1, 2], n = 2 -> [2]
        ListNode l3 = buildList(new int[]{1, 2});
        ListNode res3 = removeNthFromEnd(l3, 2);
        System.out.println("Test 3 Result: " + toListString(res3));
        assert toListString(res3).equals("[2]") : "Test 3 Failed!";
    }
}
