package Day09_Circular_Linked_List;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 79: Design Circular Singly Linked List Queue
 * Implements a FIFO Queue using a single tail pointer in a Circular Linked List (O(1) Enqueue & Dequeue).
 */
public class DesignCircularLinkedListQueue {
    public static class Node {
        public int val;
        public Node next;
        public Node(int val) {
            this.val = val;
        }
    }

    public static class NaiveQueue {
        private List<Integer> list = new ArrayList<>();
        public void enqueue(int val) {
            list.add(val);
        }
        public int dequeue() {
            if (isEmpty()) return -1;
            return list.remove(0);
        }
        public boolean isEmpty() {
            return list.isEmpty();
        }
    }

    public static class CircularQueue {
        private Node tail = null;
        private int size = 0;

        public void enqueue(int val) {
            Node newNode = new Node(val);
            if (tail == null) {
                tail = newNode;
                tail.next = tail;
            } else {
                newNode.next = tail.next;
                tail.next = newNode;
                tail = newNode;
            }
            size++;
        }

        public int dequeue() {
            if (isEmpty()) return -1;
            int val = tail.next.val;
            if (tail.next == tail) {
                tail = null;
            } else {
                tail.next = tail.next.next;
            }
            size--;
            return val;
        }

        public int peek() {
            if (isEmpty()) return -1;
            return tail.next.val;
        }

        public boolean isEmpty() {
            return tail == null;
        }

        public int size() {
            return size;
        }
    }

    public static void main(String[] args) {
        NaiveQueue nq = new NaiveQueue();
        nq.enqueue(10);
        nq.enqueue(20);
        assert nq.dequeue() == 10;
        assert nq.dequeue() == 20;

        CircularQueue cq = new CircularQueue();
        assert cq.isEmpty();
        cq.enqueue(100);
        cq.enqueue(200);
        cq.enqueue(300);
        assert cq.size() == 3;
        assert cq.peek() == 100;
        assert cq.dequeue() == 100;
        assert cq.dequeue() == 200;
        assert cq.size() == 1;
        assert cq.dequeue() == 300;
        assert cq.isEmpty();
        assert cq.dequeue() == -1;
    }
}
