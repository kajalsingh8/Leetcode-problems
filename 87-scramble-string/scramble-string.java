

class Solution {
    private HashMap<String, Boolean> memo;

    public boolean isScramble(String s1, String s2) {
        memo = new HashMap<>();
        return dp(s1, s2);
    }

    private boolean dp(String s1, String s2) {
        if (s1.equals(s2)) return true;
        if (s1.length() != s2.length()) return false;
        if (memo.containsKey(s1 + "#" + s2)) return memo.get(s1 + "#" + s2);

        int[] count = new int[26];
        for (int i = 0; i < s1.length(); i++) {
            count[s1.charAt(i) - 'a']++;
            count[s2.charAt(i) - 'a']--;
        }

        for (int i = 0; i < 26; i++) {
            if (count[i] != 0) {
                memo.put(s1 + "#" + s2, false);
                return false;
            }
        }

        int len = s1.length();
        for (int i = 1; i < len; i++) {
            if ((dp(s1.substring(0, i), s2.substring(0, i)) 
                 && dp(s1.substring(i), s2.substring(i))) 
                || (dp(s1.substring(0, i), s2.substring(len - i)) 
                    && dp(s1.substring(i), s2.substring(0, len - i)))) {
                memo.put(s1 + "#" + s2, true);
                return true;
            }
        }

        memo.put(s1 + "#" + s2, false);
        return false;
    }
}


