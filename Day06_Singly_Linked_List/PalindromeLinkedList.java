/**
 * Problem 45: Palindrome Linked List (LeetCode 234)
 * 
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) in-place modification.
 */
public class PalindromeLinkedList {
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
     * Checks whether a singly linked list is a palindrome using O(1) space.
     * @param head Head of linked list
     * @return true if list is palindrome, false otherwise
     */
    public static boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null) return true;

        // Step 1: Find mid node
        ListNode slow = head;
        ListNode fast = head;
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Step 2: Reverse second half
        ListNode prev = null;
        ListNode curr = slow.next;
        while (curr != null) {
            ListNode nextTemp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = nextTemp;
        }

        // Step 3: Compare values
        ListNode p1 = head;
        ListNode p2 = prev;
        boolean result = true;
        while (p2 != null) {
            if (p1.val != p2.val) {
                result = false;
                break;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return result;
    }
}
