/**
 * Problem 38: Linked List Cycle II (LeetCode 142)
 * 
 * Given the head of a linked list, return the node where the cycle begins.
 * If there is no cycle, return null.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space.
 */
public class LinkedListCycleII {
    public static class ListNode {
        int val;
        ListNode next;
        ListNode(int val) { this.val = val; }
    }

    public static ListNode createListWithCycle(int[] values, int cyclePos) {
        if (values == null || values.length == 0) return null;
        ListNode head = new ListNode(values[0]);
        ListNode curr = head;
        ListNode cycleTarget = (cyclePos == 0) ? head : null;

        for (int i = 1; i < values.length; i++) {
            curr.next = new ListNode(values[i]);
            curr = curr.next;
            if (i == cyclePos) {
                cycleTarget = curr;
            }
        }
        if (cyclePos != -1) {
            curr.next = cycleTarget;
        }
        return head;
    }

    /**
     * Finds the start node of a cycle in a linked list using Floyd's algorithm.
     * @param head Head of the linked list
     * @return Node where cycle begins, or null if acyclic
     */
    public static ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                ListNode entry = head;
                while (entry != slow) {
                    entry = entry.next;
                    slow = slow.next;
                }
                return entry;
            }
        }
        return null;
    }
}
