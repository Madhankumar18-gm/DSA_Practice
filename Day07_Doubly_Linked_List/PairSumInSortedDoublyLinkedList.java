import java.util.ArrayList;
import java.util.List;

/**
 * Problem 62: Pair Sum in Sorted Doubly Linked List
 * 
 * Given a sorted doubly linked list of distinct positive integers, find all pairs in the list whose sum equals a given target value.
 * 
 * Algorithm:
 * Two Pointers: first starts at head, second starts at tail.
 * If first.val + second.val == target, record pair and advance both pointers.
 * If sum < target, advance first = first.next.
 * Else, advance second = second.prev.
 * 
 * Time Complexity: O(N) single-pass traversal.
 * Space Complexity: O(1) auxiliary space (excluding returned result list).
 */
public class PairSumInSortedDoublyLinkedList {
    public static class Node {
        int val;
        Node prev;
        Node next;
        Node(int val) {
            this.val = val;
        }
    }
}
