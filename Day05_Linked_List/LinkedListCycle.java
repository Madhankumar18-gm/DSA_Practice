/**
 * Problem 37: Linked List Cycle (LeetCode 141)
 * 
 * Given head, the head of a linked list, determine if the linked list has a cycle in it.
 * 
 * Time Complexity: O(N) where N is the number of nodes.
 * Space Complexity: O(1) memory using Floyd's Tortoise and Hare algorithm.
 */
public class LinkedListCycle {
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
     * Determines if a linked list contains a cycle using Floyd's Cycle Detection.
     * @param head Head node of linked list
     * @return true if cycle exists, false otherwise
     */
    public static boolean hasCycle(ListNode head) {
        if (head == null || head.next == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}
