package Day11_Hashing;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FindAllAnagramsInString {
    public static List<Integer> findAnagramsNaive(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        int n = s.length(), m = p.length();
        char[] pArr = p.toCharArray();
        Arrays.sort(pArr);
        String pSorted = String.valueOf(pArr);
        for (int i = 0; i <= n - m; i++) {
            char[] sub = s.substring(i, i + m).toCharArray();
            Arrays.sort(sub);
            if (String.valueOf(sub).equals(pSorted)) res.add(i);
        }
        return res;
    }
    public static List<Integer> findAnagramsOptimal(String s, String p) {
        List<Integer> res = new ArrayList<>();
        if (s == null || p == null || s.length() < p.length()) return res;
        int[] pCount = new int[26];
        int[] sCount = new int[26];
        for (char c : p.toCharArray()) pCount[c - 'a']++;
        int m = p.length();
        for (int i = 0; i < s.length(); i++) {
            sCount[s.charAt(i) - 'a']++;
            if (i >= m) sCount[s.charAt(i - m) - 'a']--;
            if (Arrays.equals(pCount, sCount)) res.add(i - m + 1);
        }
        return res;
    }
    public static void main(String[] args) {
        List<Integer> res = findAnagramsNaive("cbaebabacd", "abc");
        assert res.equals(Arrays.asList(0, 6));
    }
}
