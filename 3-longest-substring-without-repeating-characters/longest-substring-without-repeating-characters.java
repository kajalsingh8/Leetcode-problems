import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int result = 0;
        HashMap<Character, Integer> seen = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char letter = s.charAt(i);
            if (seen.containsKey(letter) && seen.get(letter) >= start) {
                start = seen.get(letter) + 1;
            }
            result = Math.max(result, i - start + 1);
            seen.put(letter, i);
        }

        return result;
    }
}