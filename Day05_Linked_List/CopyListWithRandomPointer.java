/**
 * Problem 42: Copy List with Random Pointer (LeetCode 138)
 * 
 * Construct a deep copy of a linked list where each node contains an extra random pointer.
 * 
 * Algorithm (3-Pass Interleaving):
 * Pass 1: Duplicate nodes and interleave them (A -> A' -> B -> B').
 * Pass 2: Assign random pointers for cloned nodes (A'.random = A.random.next).
 * Pass 3: Decouple original and cloned lists.
 * 
 * Time Complexity: O(N)
 * Space Complexity: O(1) auxiliary space (excluding returned list).
 */
public class CopyListWithRandomPointer {
    public static class Node {
        int val;
        Node next;
        Node random;
        Node(int val) {
            this.val = val;
            this.next = null;
            this.random = null;
        }
    }
}
