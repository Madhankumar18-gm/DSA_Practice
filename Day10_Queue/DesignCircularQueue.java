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
    }
}
