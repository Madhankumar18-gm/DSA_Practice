package Day18_MockTest_Heaps;

import java.util.PriorityQueue;

public class ReorganizeString {

    public static boolean isValidReorganization(String s) {
        if (s == null) return false;
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) return false;
        }
        return true;
    }

    public static String reorganizeStringMaxHeap(String s) {
        if (s == null || s.length() == 0) return "";
        int[] freq = new int[26];
        for (char c : s.toCharArray()) freq[c - 'a']++;

        PriorityQueue<int[]> maxHeap = new PriorityQueue<>((a, b) -> Integer.compare(b[1], a[1]));
        for (int i = 0; i < 26; i++) {
            if (freq[i] > 0) {
                if (freq[i] > (s.length() + 1) / 2) return "";
                maxHeap.offer(new int[]{i, freq[i]});
            }
        }

        StringBuilder sb = new StringBuilder();
        int[] prev = null;
        while (!maxHeap.isEmpty()) {
            int[] curr = maxHeap.poll();
            sb.append((char) ('a' + curr[0]));
            curr[1]--;

            if (prev != null && prev[1] > 0) {
                maxHeap.offer(prev);
            }
            prev = curr;
        }

        return sb.length() == s.length() ? sb.toString() : "";
    }

    public static String reorganizeStringCounting(String s) {
        if (s == null || s.length() == 0) return "";
        int[] freq = new int[26];
        int maxFreq = 0;
        int maxChar = 0;
        for (char c : s.toCharArray()) {
            freq[c - 'a']++;
            if (freq[c - 'a'] > maxFreq) {
                maxFreq = freq[c - 'a'];
                maxChar = c - 'a';
            }
        }
        if (maxFreq > (s.length() + 1) / 2) return "";

        char[] res = new char[s.length()];
        int idx = 0;
        while (freq[maxChar] > 0) {
            res[idx] = (char) ('a' + maxChar);
            idx += 2;
            freq[maxChar]--;
        }
        for (int i = 0; i < 26; i++) {
            while (freq[i] > 0) {
                if (idx >= res.length) idx = 1;
                res[idx] = (char) ('a' + i);
                idx += 2;
                freq[i]--;
            }
        }
        return new String(res);
    }

    public static void main(String[] args) {
        String res1 = reorganizeStringMaxHeap("aab");
        assert "aba".equals(res1) : "Test 1 Failed: " + res1;
        assert "".equals(reorganizeStringMaxHeap("aaab")) : "Test 2 Failed";
        assert "aba".equals(reorganizeStringCounting("aab")) : "Counting Test 1 Failed";

        String multi = reorganizeStringMaxHeap("vvvlo");
        assert isValidReorganization(multi) : "Multi test invalid: " + multi;
    }
}
