package Day10_Queue;

public class DesignCircularDeque {
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
    }
}
