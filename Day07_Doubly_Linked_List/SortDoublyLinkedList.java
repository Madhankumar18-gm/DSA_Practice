/**
 * Problem 61: Sort a Doubly Linked List (Merge Sort on DLL)
 * 
 * Given the head of an unsorted doubly linked list, sort it in ascending order using Merge Sort.
 * 
 * Algorithm:
 * 1. Split DLL into two halves using fast & slow pointers.
 * 2. Recursively sort left and right sublists.
 * 3. Merge two sorted sublists adjusting both prev and next pointers.
 * 
 * Time Complexity: O(N log N)
 * Space Complexity: O(log N) recursion stack space.
 */
public class SortDoublyLinkedList {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
}
