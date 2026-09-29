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

    public static void main(String[] args) {
        System.out.println("=== Testing Check if Linked List is Circular ===");
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.next = n3; n3.next = n1;

        boolean c1 = isCircular(n1);
        printResult(c1);
        assert c1 : "Circular list test failed!";

        Node l1 = new Node(1); Node l2 = new Node(2);
        l1.next = l2; // linear list
        assert !isCircular(l1) : "Linear list test failed!";
    }
}
