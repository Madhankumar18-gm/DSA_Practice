/**
 * GFG / LeetCode - Check if a Linked List is Circular
 * Topic: Circular Linked List Traversal
 */
public class CheckIfLinkedListIsCircular {

    public static class Node {
        public int data;
        public Node next;
        public Node(int data) {
            this.data = data;
        }
    }

    /**
     * Checks if a linked list is circular (tail points back to head).
     * Time Complexity: O(N) where N is number of nodes.
     * Space Complexity: O(1) auxiliary space.
     */
    public static boolean isCircular(Node head) {
        if (head == null) {
            return true;
        }

        // Traverse pointer forward until reaching null or returning to head
        Node curr = head.next;
        while (curr != null && curr != head) {
            curr = curr.next;
        }

        return curr == head;
    }

    public static void printResult(boolean res) {
        System.out.println("Is Linked List Circular: " + res);
    }
}
