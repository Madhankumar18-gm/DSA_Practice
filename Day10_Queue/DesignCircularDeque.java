package Day10_Queue;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem 85: [LeetCode 641] Design Circular Deque
 * Array-based Double-Ended Circular Ring Buffer.
 */
public class DesignCircularDeque {
    public static class NaiveDeque {
        private List<Integer> list = new ArrayList<>();
        private int k;
        public NaiveDeque(int k) { this.k = k; }
        public boolean insertFront(int value) {
            if (list.size() == k) return false;
            list.add(0, value);
            return true;
        }
        public boolean insertLast(int value) {
            if (list.size() == k) return false;
            list.add(value);
            return true;
        }
    }
    public static class MyCircularDeque {
        private int[] buffer;
        private int front;
        private int rear;
        private int size;
        private int capacity;
        public MyCircularDeque(int k) {
            this.capacity = k;
            this.buffer = new int[k];
            this.front = 0;
            this.rear = 0;
            this.size = 0;
        }
        public boolean insertFront(int value) {
            if (isFull()) return false;
            front = (front - 1 + capacity) % capacity;
            buffer[front] = value;
            size++;
            return true;
        }
        public boolean insertLast(int value) {
            if (isFull()) return false;
            buffer[rear] = value;
            rear = (rear + 1) % capacity;
            size++;
            return true;
        }
        public boolean deleteFront() {
            if (isEmpty()) return false;
            front = (front + 1) % capacity;
            size--;
            return true;
        }
        public boolean deleteLast() {
            if (isEmpty()) return false;
            rear = (rear - 1 + capacity) % capacity;
            size--;
            return true;
        }
        public int getFront() { return isEmpty() ? -1 : buffer[front]; }
        public int getRear() { return isEmpty() ? -1 : buffer[(rear - 1 + capacity) % capacity]; }
        public boolean isEmpty() { return size == 0; }
        public boolean isFull() { return size == capacity; }
    }
    public static void main(String[] args) {
        NaiveDeque nd = new NaiveDeque(2);
        assert nd.insertFront(1);
        assert nd.insertLast(2);
        assert !nd.insertFront(3);
        MyCircularDeque dq = new MyCircularDeque(3);
        assert dq.insertLast(1);
        assert dq.insertLast(2);
        assert dq.insertFront(3);
        assert !dq.insertFront(4);
        assert dq.getRear() == 2;
        assert dq.isFull();
        assert dq.deleteLast();
        assert dq.insertFront(4);
        assert dq.getFront() == 4;
        assert dq.deleteFront();
        assert dq.deleteFront();
        assert dq.deleteFront();
        assert dq.isEmpty();
    }
}
