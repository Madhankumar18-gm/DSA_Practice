package Day11_Hashing;

import java.util.HashMap;
import java.util.Map;

public class IsomorphicStrings {
    public static boolean isIsomorphicNaive(String s, String t) {
        if (s == null || t == null || s.length() != t.length()) return false;
        Map<Character, Character> m1 = new HashMap<>();
        Map<Character, Character> m2 = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            char c1 = s.charAt(i), c2 = t.charAt(i);
            if (m1.containsKey(c1) && m1.get(c1) != c2) return false;
            if (m2.containsKey(c2) && m2.get(c2) != c1) return false;
            m1.put(c1, c2);
            m2.put(c2, c1);
        }
        return true;
    }
    public static void main(String[] args) {
        assert isIsomorphicNaive("egg", "add");
        assert !isIsomorphicNaive("foo", "bar");
    }
}
