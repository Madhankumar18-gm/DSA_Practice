package Day11_Hashing;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Random;
import java.util.Set;

public class InsertDeleteGetRandomO1 {
    public static class RandomizedSetNaive {
        private Set<Integer> set = new HashSet<>();
        private Random rand = new Random();
        public boolean insert(int val) { return set.add(val); }
        public boolean remove(int val) { return set.remove(val); }
        public int getRandom() {
            List<Integer> list = new ArrayList<>(set);
            return list.get(rand.nextInt(list.size()));
        }
    }
    public static void main(String[] args) {
        RandomizedSetNaive r = new RandomizedSetNaive();
        assert r.insert(1);
        assert !r.remove(2);
        assert r.insert(2);
        assert r.remove(1);
    }
}
