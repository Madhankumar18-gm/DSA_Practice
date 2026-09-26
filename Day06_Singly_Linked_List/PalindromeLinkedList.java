/**
 * Problem 45: Palindrome Linked List (LeetCode 234)
 * 
 * Given the head of a singly linked list, return true if it is a palindrome or false otherwise.
 * 
 * Algorithm:
 * 1. Find middle of linked list using fast & slow pointers.
 * 2. Reverse the second half of the linked list.
 * 3. Compare values of first half and reversed second half.
 * 4. Restore list structure (optional) and return result.
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
}
