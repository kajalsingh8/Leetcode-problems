class Solution {
    public String minWindow(String s, String t) {
        int[] map = new int[128];
        for (char c : t.toCharArray()) map[c]++;
        int l = 0, r = 0, start = 0, minLen = Integer.MAX_VALUE, count = t.length();
         while (r < s.length()) {
            if (map[s.charAt(r++)]-- > 0) count--;
            
            while (count == 0) {
                if (r - l < minLen) {
                    minLen = r - l;
                    start = l;
                }
                if (++map[s.charAt(l++)] > 0) count++;
            }
        }
        return minLen == Integer.MAX_VALUE ? "" : s.substring(start, start + minLen);
    }
}
