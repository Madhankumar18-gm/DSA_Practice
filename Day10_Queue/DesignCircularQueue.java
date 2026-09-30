package Day10_Queue;

public class DesignCircularQueue {
    public static class MyCircularQueue {
        private int[] buffer;
        private int head;
        private int tail;
        private int size;
        private int capacity;
        public MyCircularQueue(int k) {
            this.capacity = k;
            this.buffer = new int[k];
            this.head = 0;
            this.tail = -1;
            this.size = 0;
        }
        public boolean enQueue(int value) {
            if (isFull()) return false;
            tail = (tail + 1) % capacity;
            buffer[tail] = value;
            size++;
            return true;
        }
        public boolean deQueue() {
            if (isEmpty()) return false;
            head = (head + 1) % capacity;
            size--;
            return true;
        }
        public int Front() { return isEmpty() ? -1 : buffer[head]; }
        public int Rear() { return isEmpty() ? -1 : buffer[tail]; }
        public boolean isEmpty() { return size == 0; }
        public boolean isFull() { return size == capacity; }
    }
    public static void main(String[] args) {
        MyCircularQueue q = new MyCircularQueue(3);
        assert q.isEmpty();
        assert !q.isFull();
    }
}
