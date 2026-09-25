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

    private static ListNode reverse(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    /**
     * Reorders the linked list in-place.
     * @param head Head of linked list
     */
    public static void reorderList(ListNode head) {
        if (head == null || head.next == null || head.next.next == null) return;

        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        ListNode second = reverse(slow.next);
        slow.next = null;

        ListNode first = head;
        while (second != null) {
            ListNode tmp1 = first.next;
            ListNode tmp2 = second.next;

            first.next = second;
            second.next = tmp1;

            first = tmp1;
            second = tmp2;
        }
    }

    public static void main(String[] args) {
        System.out.println("=== ReorderList Execution Suite ===");

        // Test 1: [1, 2, 3, 4] -> [1, 4, 2, 3]
        ListNode l1 = buildList(new int[]{1, 2, 3, 4});
        reorderList(l1);
        System.out.println("Test 1 Reordered: " + toListString(l1));
        assert toListString(l1).equals("[1, 4, 2, 3]") : "Test 1 Failed!";

        // Test 2: [1, 2, 3, 4, 5] -> [1, 5, 2, 4, 3]
        ListNode l2 = buildList(new int[]{1, 2, 3, 4, 5});
        reorderList(l2);
        System.out.println("Test 2 Reordered: " + toListString(l2));
        assert toListString(l2).equals("[1, 5, 2, 4, 3]") : "Test 2 Failed!";

        // Test 3: [1] -> [1]
        ListNode l3 = buildList(new int[]{1});
        reorderList(l3);
        System.out.println("Test 3 Reordered: " + toListString(l3));
        assert toListString(l3).equals("[1]") : "Test 3 Failed!";

        System.out.println("=== All Tests Completed Successfully ===");
    }
}
