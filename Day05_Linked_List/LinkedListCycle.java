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
        ListNode fast = head.next;
        while (slow != fast) {
            if (fast == null || fast.next == null) {
                return false;
            }
            slow = slow.next;
            fast = fast.next.next;
        }
        return true;
    }

    public static void main(String[] args) {
        System.out.println("=== LinkedListCycle Execution Suite ===");

        // Test 1: List with cycle at index 1 [3, 2, 0, -4] -> cycle back to 2
        ListNode list1 = createListWithCycle(new int[]{3, 2, 0, -4}, 1);
        boolean ans1 = hasCycle(list1);
        System.out.println("Test 1 Cycle Detected: " + ans1);
        assert ans1 == true : "Test 1 Failed!";

        // Test 2: List with cycle at index 0 [1, 2] -> cycle back to 1
        ListNode list2 = createListWithCycle(new int[]{1, 2}, 0);
        boolean ans2 = hasCycle(list2);
        System.out.println("Test 2 Cycle Detected: " + ans2);
        assert ans2 == true : "Test 2 Failed!";

        // Test 3: List with no cycle [1] -> pos = -1
        ListNode list3 = createListWithCycle(new int[]{1}, -1);
        boolean ans3 = hasCycle(list3);
        System.out.println("Test 3 Cycle Detected: " + ans3);
        assert ans3 == false : "Test 3 Failed!";

        System.out.println("=== All Tests Completed Successfully ===");
    }
}
