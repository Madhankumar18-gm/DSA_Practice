/**
 * Problem 52: Swap Nodes in Pairs (LeetCode 24)
 * 
 * Given a linked list, swap every two adjacent nodes and return its head.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class SwapNodesInPairs {
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
     * Swaps adjacent nodes in pairs.
     * @param head Head of linked list
     * @return Head of pair-swapped list
     */
    public static ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode current = dummy;

        while (current.next != null && current.next.next != null) {
            ListNode first = current.next;
            ListNode second = current.next.next;

            first.next = second.next;
            current.next = second;
            current.next.next = first;

            current = current.next.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("=== SwapNodesInPairs Execution Suite ===");

        // Test 1: [1, 2, 3, 4] -> [2, 1, 4, 3]
        ListNode l1 = buildList(new int[]{1, 2, 3, 4});
        ListNode res1 = swapPairs(l1);
        System.out.println("Test 1 Result: " + toListString(res1));
    }
}
