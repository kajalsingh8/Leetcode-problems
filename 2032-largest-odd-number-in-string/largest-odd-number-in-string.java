class Solution {
    public String largestOddNumber(String num) {
        int len = num.length() - 1;
        
        // Iterate from the last digit to the first
        while (len >= 0) {
            int d = num.charAt(len) - '0'; // Convert character to integer
            if (d % 2 != 0) { // Check if the digit is odd
                return num.substring(0, len + 1); // Return the substring up to the current position
            }
            len--; // Decrement the index
        }
        
        // If no odd digit is found, return an empty string
        return "";
    }
}
