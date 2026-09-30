package Day10_Queue;

import java.util.ArrayList;
import java.util.List;

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
}
