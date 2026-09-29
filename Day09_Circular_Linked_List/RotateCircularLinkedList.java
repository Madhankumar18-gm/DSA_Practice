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

    public static Node rotateOptimal(Node head, int k) {
        if (head == null || head.next == head || k <= 0) return head;
        int len = 0;
        Node curr = head;
        do {
            len++;
            curr = curr.next;
        } while (curr != head);

        k = k % len;
        if (k == 0) return head;

        for (int i = 0; i < k; i++) {
            head = head.next;
        }
        return head;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.next = n3; n3.next = n1;
        Node rotated = rotateNaive(n1, 1);
        assert rotated.val == 2;
        Node rOpt = rotateOptimal(n1, 1);
        assert rOpt.val == 2;
    }
}
