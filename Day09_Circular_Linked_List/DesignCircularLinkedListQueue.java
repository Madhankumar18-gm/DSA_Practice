package Day09_Circular_Linked_List;

import java.util.ArrayList;
import java.util.List;

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
}
