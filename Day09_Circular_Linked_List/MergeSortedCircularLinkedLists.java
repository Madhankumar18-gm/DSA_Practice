package Day09_Circular_Linked_List;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MergeSortedCircularLinkedLists {
    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static Node mergeNaive(Node head1, Node head2) {
        if (head1 == null) return head2;
        if (head2 == null) return head1;

        List<Integer> list = new ArrayList<>();
        Node c1 = head1;
        do {
            list.add(c1.val);
            c1 = c1.next;
        } while (c1 != head1);

        Node c2 = head2;
        do {
            list.add(c2.val);
            c2 = c2.next;
        } while (c2 != head2);

        Collections.sort(list);
        Node newHead = new Node(list.get(0));
        Node curr = newHead;
        for (int i = 1; i < list.size(); i++) {
            curr.next = new Node(list.get(i));
            curr = curr.next;
        }
        curr.next = newHead;
        return newHead;
    }

    public static void main(String[] args) {
        Node a1 = new Node(1), a2 = new Node(3);
        a1.next = a2; a2.next = a1;
        Node b1 = new Node(2), b2 = new Node(4);
        b1.next = b2; b2.next = b1;

        Node m = mergeNaive(a1, b1);
        assert m.val == 1;
        assert m.next.val == 2;
        assert m.next.next.val == 3;
        assert m.next.next.next.val == 4;
        assert m.next.next.next.next == m;
    }
}
