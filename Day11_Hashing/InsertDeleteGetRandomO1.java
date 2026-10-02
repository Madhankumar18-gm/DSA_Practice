package Day11_Hashing;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * Problem 100: [LeetCode 380] Insert Delete GetRandom O(1)
 * ArrayList + HashMap Index Swap Map supporting O(1) average time operations.
 */
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
    public static class RandomizedSet {
        private List<Integer> list;
        private Map<Integer, Integer> map;
        private Random rand;
        public RandomizedSet() {
            list = new ArrayList<>();
            map = new HashMap<>();
            rand = new Random();
        }
        public boolean insert(int val) {
            if (map.containsKey(val)) return false;
            map.put(val, list.size());
            list.add(val);
            return true;
        }
        public boolean remove(int val) {
            if (!map.containsKey(val)) return false;
            int idx = map.get(val);
            int lastVal = list.get(list.size() - 1);
            list.set(idx, lastVal);
            map.put(lastVal, idx);
            list.remove(list.size() - 1);
            map.remove(val);
            return true;
        }
        public int getRandom() {
            return list.get(rand.nextInt(list.size()));
        }
    }
    public static void main(String[] args) {
        RandomizedSetNaive r = new RandomizedSetNaive();
        assert r.insert(1);
        assert !r.remove(2);
        assert r.insert(2);
        assert r.remove(1);
        RandomizedSet rs = new RandomizedSet();
        assert rs.insert(1);
        assert !rs.remove(2);
        assert rs.insert(2);
        assert rs.remove(1);
        assert rs.getRandom() == 2;
        assert !rs.insert(2);
        assert rs.remove(2);
        System.out.println("Execution completed successfully for InsertDeleteGetRandomO1.");
    }
}
