/**
 * Problem 48: Remove Duplicates from Sorted List II (LeetCode 82)
 * 
 * Given the head of a sorted linked list, delete ALL nodes that have duplicate numbers,
 * leaving only distinct numbers from the original list.
 * 
 * Time Complexity: O(N) single-pass.
 * Space Complexity: O(1) auxiliary space.
 */
public class RemoveDuplicatesFromSortedListII {
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
     * Removes all nodes with duplicate numbers.
     * @param head Head of sorted list
     * @return Head of modified list with distinct values only
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode prev = dummy;
        ListNode curr = head;

        while (curr != null) {
            boolean hasDuplicate = false;
            while (curr.next != null && curr.val == curr.next.val) {
                curr = curr.next;
                hasDuplicate = true;
            }

            if (hasDuplicate) {
                prev.next = curr.next;
            } else {
                prev = prev.next;
            }
            curr = curr.next;
        }

        return dummy.next;
    }

    public static void main(String[] args) {
        System.out.println("=== RemoveDuplicatesFromSortedListII Execution Suite ===");

        // Test 1: [1, 2, 3, 3, 4, 4, 5] -> [1, 2, 5]
        ListNode l1 = buildList(new int[]{1, 2, 3, 3, 4, 4, 5});
        ListNode res1 = deleteDuplicates(l1);
        System.out.println("Test 1 Result: " + toListString(res1));
    }
}
