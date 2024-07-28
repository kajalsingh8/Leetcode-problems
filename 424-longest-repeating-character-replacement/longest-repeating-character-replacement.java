class Solution {

    public static int getMaxFrequency(int[] freq) {
        int maxFreq = 0;
        for (int count : freq) {
            if (count > maxFreq) {
                maxFreq = count;
            }
        }
        return maxFreq;
    }

    public int characterReplacement(String s, int k) {
        int l = 0;
        int n = s.length();
        int maxSize = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        for (int r = 0; r < n; r++) {
            freq[s.charAt(r) - 'A']++;
            maxFreq = getMaxFrequency(freq);
            if ((r - l + 1) - maxFreq <= k) {
                maxSize = Math.max(maxSize, r - l + 1);
            }
            if (maxFreq + k < (r - l + 1)) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
        }
        return maxSize;
    }
}