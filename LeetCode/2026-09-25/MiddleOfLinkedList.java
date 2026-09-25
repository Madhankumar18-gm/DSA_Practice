/**
 * Problem 36: Middle of the Linked List (LeetCode 876)
 * 
 * Given the head of a singly linked list, return the middle node of the linked list.
 * If there are two middle nodes, return the second middle node.
 * 
 * Time Complexity: O(N) where N is the number of nodes.
 * Space Complexity: O(1) auxiliary space.
 */
public class MiddleOfLinkedList {
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
     * Finds the middle node of a linked list using Fast & Slow pointers.
     * @param head Head of the linked list
     * @return Middle node
     */
    public static ListNode middleNode(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }

    public static void main(String[] args) {
        System.out.println("=== MiddleOfLinkedList Execution Suite ===");
        
        // Test Case 1: Odd length list [1, 2, 3, 4, 5]
        ListNode list1 = buildList(new int[]{1, 2, 3, 4, 5});
        ListNode mid1 = middleNode(list1);
        System.out.println("Test 1 Input: " + toListString(list1));
        System.out.println("Test 1 Middle: " + toListString(mid1));
        assert mid1 != null && mid1.val == 3 : "Test 1 Failed!";

        // Test Case 2: Even length list [1, 2, 3, 4, 5, 6] -> second middle is 4
        ListNode list2 = buildList(new int[]{1, 2, 3, 4, 5, 6});
        ListNode mid2 = middleNode(list2);
        System.out.println("Test 2 Input: " + toListString(list2));
        System.out.println("Test 2 Middle: " + toListString(mid2));
        assert mid2 != null && mid2.val == 4 : "Test 2 Failed!";

        // Test Case 3: Single element list [1]
        ListNode list3 = buildList(new int[]{1});
        ListNode mid3 = middleNode(list3);
        System.out.println("Test 3 Input: " + toListString(list3));
        System.out.println("Test 3 Middle: " + toListString(mid3));
        assert mid3 != null && mid3.val == 1 : "Test 3 Failed!";

        System.out.println("=== All Tests Completed Successfully ===");
    }
}
