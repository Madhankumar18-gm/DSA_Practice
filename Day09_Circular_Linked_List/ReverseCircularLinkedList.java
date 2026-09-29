package Day09_Circular_Linked_List;

import java.util.ArrayList;
import java.util.List;

public class ReverseCircularLinkedList {
    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static Node reverseNaive(Node head) {
        if (head == null || head.next == head) return head;
        List<Integer> list = new ArrayList<>();
        Node curr = head;
        do {
            list.add(curr.val);
            curr = curr.next;
        } while (curr != head);

        Node newHead = new Node(list.get(list.size() - 1));
        Node tail = newHead;
        for (int i = list.size() - 2; i >= 0; i--) {
            tail.next = new Node(list.get(i));
            tail = tail.next;
        }
        tail.next = newHead;
        return newHead;
    }

    public static Node reverseOptimal(Node head) {
        if (head == null || head.next == head) return head;
        Node prev = null;
        Node curr = head;
        Node next = null;
        do {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        } while (curr != head);

        head.next = prev;
        return prev;
    }

    public static void main(String[] args) {
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        n1.next = n2; n2.next = n3; n3.next = n1;
        Node rev = reverseNaive(n1);
        assert rev.val == 3;
        assert rev.next.val == 2;
        assert rev.next.next.val == 1;
        assert rev.next.next.next == rev;

        Node opt = reverseOptimal(rev);
        assert opt.val == 1;
        assert opt.next.val == 2;
        assert opt.next.next.val == 3;
        assert opt.next.next.next == opt;

        assert reverseOptimal(null) == null;
        Node single = new Node(42);
        single.next = single;
        assert reverseOptimal(single) == single;
    }
}
