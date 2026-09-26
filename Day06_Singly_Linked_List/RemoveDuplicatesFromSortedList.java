/**
 * Problem 47: Remove Duplicates from Sorted List (LeetCode 83)
 * 
 * Given the head of a sorted linked list, delete all duplicates such that each element appears only once.
 * 
 * Time Complexity: O(N) single-pass.
 * Space Complexity: O(1) auxiliary space.
 */
public class RemoveDuplicatesFromSortedList {
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
     * Removes duplicate values from a sorted singly linked list.
     * @param head Head of sorted linked list
     * @return Head of deduplicated list
     */
    public static ListNode deleteDuplicates(ListNode head) {
        ListNode curr = head;
        while (curr != null && curr.next != null) {
            if (curr.val == curr.next.val) {
                curr.next = curr.next.next;
            } else {
                curr = curr.next;
            }
        }
        return head;
    }

    public static void main(String[] args) {
        System.out.println("=== RemoveDuplicatesFromSortedList Execution Suite ===");

        // Test 1: [1, 1, 2] -> [1, 2]
        ListNode l1 = buildList(new int[]{1, 1, 2});
        ListNode res1 = deleteDuplicates(l1);
        System.out.println("Test 1 Result: " + toListString(res1));
    }
}
