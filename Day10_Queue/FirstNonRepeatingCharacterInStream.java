package Day10_Queue;

public class FirstNonRepeatingCharacterInStream {
    public static String firstNonRepeatingNaive(String str) {
        StringBuilder sb = new StringBuilder();
        int[] freq = new int[26];
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            freq[ch - 'a']++;
            char first = '#';
            for (int j = 0; j <= i; j++) {
                if (freq[str.charAt(j) - 'a'] == 1) {
                    first = str.charAt(j);
                    break;
                }
            }
            sb.append(first);
        }
        return sb.toString();
    }
}
