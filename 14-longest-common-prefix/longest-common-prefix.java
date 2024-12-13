import java.util.Arrays;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        // If the input array is empty, return an empty string
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Sort the array to compare the first and last strings
        Arrays.sort(strs);
        
        // First and last strings after sorting
        String str1 = strs[0];
        String str2 = strs[strs.length - 1];

        int indx = 0;
        // Compare the characters of the first and last string
        while (indx < str1.length() && indx < str2.length() && str1.charAt(indx) == str2.charAt(indx)) {
            indx++;
        }

        // Return the common prefix
        return str1.substring(0, indx);
    }
}
