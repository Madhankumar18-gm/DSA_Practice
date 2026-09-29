package Day09_Circular_Linked_List;

public class RotateCircularLinkedList {
    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static Node rotateNaive(Node head, int k) {
        if (head == null || head.next == head || k == 0) return head;
        Node curr = head;
        for (int i = 0; i < k; i++) {
            curr = curr.next;
        }
        return curr;
    }
}
